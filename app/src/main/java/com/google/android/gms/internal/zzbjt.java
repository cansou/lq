package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;

public final class zzbjt extends zza {
    public static final Parcelable.Creator<zzbjt> CREATOR = new zzbju();
    private int type;
    private String zzaLf;
    private zzbiw zzaLo;
    public zzbjl zzaLp;
    public final com.google.android.gms.awareness.fence.zza zzaLq;
    private PendingIntent zzaLr;
    private long zzaLs;
    private long zzaLt;

    zzbjt(int i, zzbiw zzbiw, IBinder iBinder, PendingIntent pendingIntent, String str, long j, long j2) {
        zzbjl zzbjn;
        this.type = i;
        this.zzaLo = zzbiw;
        if (iBinder == null) {
            zzbjn = null;
        } else if (iBinder == null) {
            zzbjn = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.contextmanager.fence.internal.IContextFenceListener");
            zzbjn = queryLocalInterface instanceof zzbjl ? (zzbjl) queryLocalInterface : new zzbjn(iBinder);
        }
        this.zzaLp = zzbjn;
        this.zzaLq = null;
        this.zzaLr = pendingIntent;
        this.zzaLf = str;
        this.zzaLs = j;
        this.zzaLt = j2;
    }

    private zzbjt(int i, zzbiw zzbiw, com.google.android.gms.awareness.fence.zza zza, PendingIntent pendingIntent, String str, long j, long j2) {
        this.type = i;
        this.zzaLo = zzbiw;
        this.zzaLp = null;
        this.zzaLq = null;
        this.zzaLr = pendingIntent;
        this.zzaLf = str;
        this.zzaLs = -1;
        this.zzaLt = -1;
    }

    public static final zzbjt zza(PendingIntent pendingIntent) {
        return new zzbjt(4, (zzbiw) null, (com.google.android.gms.awareness.fence.zza) null, pendingIntent, (String) null, -1, -1);
    }

    public static final zzbjt zza(String str, long j, zzbiy zzbiy, PendingIntent pendingIntent) {
        return new zzbjt(2, new zzbiw(str, 0, zzbiy), (com.google.android.gms.awareness.fence.zza) null, pendingIntent, (String) null, -1, -1);
    }

    public static final zzbjt zzcN(String str) {
        return new zzbjt(5, (zzbiw) null, (com.google.android.gms.awareness.fence.zza) null, (PendingIntent) null, str, -1, -1);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 2, this.type);
        zzd.zza(parcel, 3, (Parcelable) this.zzaLo, i, false);
        zzd.zza(parcel, 4, this.zzaLp == null ? null : this.zzaLp.asBinder(), false);
        zzd.zza(parcel, 5, (Parcelable) this.zzaLr, i, false);
        zzd.zza(parcel, 6, this.zzaLf, false);
        zzd.zza(parcel, 7, this.zzaLs);
        zzd.zza(parcel, 8, this.zzaLt);
        zzd.zzI(parcel, zze);
    }
}
