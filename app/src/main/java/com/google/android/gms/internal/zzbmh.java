package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.common.util.zzw;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.events.zzd;
import com.google.android.gms.drive.events.zzj;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzbmh extends zzz<zzbom> {
    private final Bundle zzaNQ;
    private final boolean zzaNR;
    private volatile DriveId zzaNS;
    private volatile DriveId zzaNT;
    private volatile boolean zzaNU = false;
    private GoogleApiClient.ConnectionCallbacks zzaNV;
    private Map<DriveId, Map<ChangeListener, zzboc>> zzaNW = new HashMap();
    private Map<zzd, zzboc> zzaNX = new HashMap();
    private Map<DriveId, Map<Object, zzboc>> zzaNY = new HashMap();
    private Map<DriveId, Map<Object, zzboc>> zzaNZ = new HashMap();
    private final String zzake;

    public zzbmh(Context context, Looper looper, zzq zzq, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, zzq, connectionCallbacks, onConnectionFailedListener);
        this.zzake = zzq.zzrq();
        this.zzaNV = connectionCallbacks;
        this.zzaNQ = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case 0:
                this.zzaNR = false;
                return;
            case 1:
                ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                if (!serviceInfo.exported) {
                    String valueOf = String.valueOf(serviceInfo.name);
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 60).append("Drive event service ").append(valueOf).append(" must be exported in AndroidManifest.xml").toString());
                } else {
                    this.zzaNR = true;
                    return;
                }
            default:
                String valueOf2 = String.valueOf(intent.getAction());
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf2).length() + 72).append("AndroidManifest.xml can only define one service that handles the ").append(valueOf2).append(" action").toString());
        }
    }

    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzbom) zzrf()).zza(new zzblm());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        synchronized (this.zzaNW) {
            this.zzaNW.clear();
        }
        synchronized (this.zzaNX) {
            this.zzaNX.clear();
        }
        synchronized (this.zzaNY) {
            this.zzaNY.clear();
        }
        synchronized (this.zzaNZ) {
            this.zzaNZ.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId) {
        zzbkr zzbkr = new zzbkr(1, driveId);
        zzbo.zzaf(zzj.zza(zzbkr.zzaJo, zzbkr.zzaLV));
        zzbo.zza(isConnected(), (Object) "Client must be connected");
        if (this.zzaNR) {
            return googleApiClient.zze(new zzbmk(this, googleApiClient, zzbkr));
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    /* access modifiers changed from: package-private */
    public final PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        HashMap hashMap;
        PendingResult<Status> zzbme;
        zzbo.zzaf(zzj.zza(1, driveId));
        zzbo.zzb(changeListener, (Object) "listener");
        zzbo.zza(isConnected(), (Object) "Client must be connected");
        synchronized (this.zzaNW) {
            Map map = this.zzaNW.get(driveId);
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.zzaNW.put(driveId, hashMap2);
                hashMap = hashMap2;
            } else {
                hashMap = map;
            }
            zzboc zzboc = (zzboc) hashMap.get(changeListener);
            if (zzboc == null) {
                zzboc = new zzboc(getLooper(), getContext(), 1, changeListener);
                hashMap.put(changeListener, zzboc);
            } else if (zzboc.zzaO(1)) {
                zzbme = new zzbme(googleApiClient, Status.zzaBm);
            }
            zzboc.zzaN(1);
            zzbme = googleApiClient.zze(new zzbmi(this, googleApiClient, new zzbkr(1, driveId), zzboc));
        }
        return zzbme;
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaNS = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.zzaNT = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
            this.zzaNU = true;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    /* access modifiers changed from: package-private */
    public final PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        PendingResult<Status> zze;
        zzbo.zzaf(zzj.zza(1, driveId));
        zzbo.zza(isConnected(), (Object) "Client must be connected");
        zzbo.zzb(changeListener, (Object) "listener");
        synchronized (this.zzaNW) {
            Map map = this.zzaNW.get(driveId);
            if (map == null) {
                zze = new zzbme(googleApiClient, Status.zzaBm);
            } else {
                zzboc zzboc = (zzboc) map.remove(changeListener);
                if (zzboc == null) {
                    zze = new zzbme(googleApiClient, Status.zzaBm);
                } else {
                    if (map.isEmpty()) {
                        this.zzaNW.remove(driveId);
                    }
                    zze = googleApiClient.zze(new zzbmj(this, googleApiClient, new zzbqk(driveId, 1), zzboc));
                }
            }
        }
        return zze;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
        return queryLocalInterface instanceof zzbom ? (zzbom) queryLocalInterface : new zzbon(iBinder);
    }

    /* access modifiers changed from: protected */
    public final String zzdb() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    /* access modifiers changed from: protected */
    public final String zzdc() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    /* access modifiers changed from: protected */
    public final Bundle zzmo() {
        String packageName = getContext().getPackageName();
        zzbo.zzu(packageName);
        zzbo.zzae(!zzry().zzro().isEmpty());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.zzake)) {
            bundle.putString("proxy_package_name", this.zzake);
        }
        bundle.putAll(this.zzaNQ);
        return bundle;
    }

    public final boolean zzmv() {
        return !getContext().getPackageName().equals(this.zzake) || !zzw.zzf(getContext(), Process.myUid());
    }

    public final boolean zzrg() {
        return true;
    }

    public final DriveId zztf() {
        return this.zzaNS;
    }

    public final DriveId zztg() {
        return this.zzaNT;
    }

    public final boolean zzth() {
        return this.zzaNU;
    }

    public final boolean zzti() {
        return this.zzaNR;
    }
}
