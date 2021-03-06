package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public final class gu extends zzz<gf> {
    private final Context mContext;
    private final int mTheme;
    private final String zzakh;
    private final int zzbPT;
    private final boolean zzbPU;

    public gu(Context context, Looper looper, zzq zzq, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, int i, int i2, boolean z) {
        super(context, looper, 4, zzq, connectionCallbacks, onConnectionFailedListener);
        this.mContext = context;
        this.zzbPT = i;
        this.zzakh = zzq.getAccountName();
        this.mTheme = i2;
        this.zzbPU = z;
    }

    private final Bundle zzDT() {
        int i = this.zzbPT;
        String packageName = this.mContext.getPackageName();
        String str = this.zzakh;
        int i2 = this.mTheme;
        boolean z = this.zzbPU;
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putBoolean("com.google.android.gms.wallet.EXTRA_USING_ANDROID_PAY_BRAND", z);
        bundle.putString("androidPackageName", packageName);
        if (!TextUtils.isEmpty(str)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(str, "com.google"));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    public final void zza(FullWalletRequest fullWalletRequest, int i) {
        gy gyVar = new gy(this.mContext, i);
        try {
            ((gf) zzrf()).zza(fullWalletRequest, zzDT(), (gj) gyVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            gyVar.zza(8, (FullWallet) null, Bundle.EMPTY);
        }
    }

    public final void zza(IsReadyToPayRequest isReadyToPayRequest, zzbaz<BooleanResult> zzbaz) {
        gx gxVar = new gx(zzbaz);
        try {
            ((gf) zzrf()).zza(isReadyToPayRequest, zzDT(), (gj) gxVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException during isReadyToPay", e);
            gxVar.zza(Status.zzaBo, false, Bundle.EMPTY);
        }
    }

    public final void zza(MaskedWalletRequest maskedWalletRequest, int i) {
        Bundle zzDT = zzDT();
        gy gyVar = new gy(this.mContext, i);
        try {
            ((gf) zzrf()).zza(maskedWalletRequest, zzDT, (gj) gyVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            gyVar.zza(8, (MaskedWallet) null, Bundle.EMPTY);
        }
    }

    public final void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        try {
            ((gf) zzrf()).zza(notifyTransactionStatusRequest, zzDT());
        } catch (RemoteException e) {
        }
    }

    public final void zzbP(int i) {
        Bundle zzDT = zzDT();
        gy gyVar = new gy(this.mContext, i);
        try {
            ((gf) zzrf()).zza(zzDT, (gj) gyVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            gyVar.zza(8, false, Bundle.EMPTY);
        }
    }

    public final void zzbQ(int i) {
        Bundle zzDT = zzDT();
        gy gyVar = new gy(this.mContext, i);
        try {
            ((gf) zzrf()).zzb(zzDT, gyVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException during isNewUser", e);
            gyVar.zzb(8, false, Bundle.EMPTY);
        }
    }

    public final void zzc(String str, String str2, int i) {
        Bundle zzDT = zzDT();
        gy gyVar = new gy(this.mContext, i);
        try {
            ((gf) zzrf()).zza(str, str2, zzDT, gyVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            gyVar.zza(8, (MaskedWallet) null, Bundle.EMPTY);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
        return queryLocalInterface instanceof gf ? (gf) queryLocalInterface : new gg(iBinder);
    }

    /* access modifiers changed from: protected */
    public final String zzdb() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    /* access modifiers changed from: protected */
    public final String zzdc() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    public final boolean zzrg() {
        return true;
    }
}
