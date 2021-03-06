package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzk;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzp;
import com.google.android.gms.dynamic.zzq;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public final class gz extends zzp<gh> {
    private static gz zzbQF;

    protected gz() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    public static ga zza(Activity activity, zzk zzk, WalletFragmentOptions walletFragmentOptions, gd gdVar) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            if (zzbQF == null) {
                zzbQF = new gz();
            }
            return ((gh) zzbQF.zzaS(activity)).zza(zzn.zzw(activity), zzk, walletFragmentOptions, gdVar);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (zzq e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
        return queryLocalInterface instanceof gh ? (gh) queryLocalInterface : new gi(iBinder);
    }
}
