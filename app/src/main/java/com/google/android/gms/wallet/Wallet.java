package com.google.android.gms.wallet;

import android.os.RemoteException;
import android.support.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.fv;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.zzbay;
import com.google.android.gms.wallet.wobs.zzs;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API = new Api<>("Wallet.API", zzajS, zzajR);
    public static final Payments Payments = new gl();
    private static final Api.zzf<gu> zzajR = new Api.zzf<>();
    private static final Api.zza<gu, WalletOptions> zzajS = new zzaa();
    private static zzs zzbPQ = new hb();
    private static fv zzbPR = new ha();

    public static final class WalletOptions implements Api.ApiOptions.HasOptions {
        public final int environment;
        public final int theme;
        @VisibleForTesting
        final boolean zzbPS;

        public static final class Builder {
            /* access modifiers changed from: private */
            public int mTheme = 0;
            /* access modifiers changed from: private */
            public int zzbPT = 3;
            /* access modifiers changed from: private */
            public boolean zzbPU = true;

            public final WalletOptions build() {
                return new WalletOptions(this, (zzaa) null);
            }

            public final Builder setEnvironment(int i) {
                if (i == 0 || i == 0 || i == 2 || i == 1 || i == 3) {
                    this.zzbPT = i;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(i)}));
            }

            public final Builder setTheme(int i) {
                if (i == 0 || i == 1) {
                    this.mTheme = i;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(i)}));
            }

            @Deprecated
            public final Builder useGoogleWallet() {
                this.zzbPU = false;
                return this;
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.zzbPT;
            this.theme = builder.mTheme;
            this.zzbPS = builder.zzbPU;
        }

        /* synthetic */ WalletOptions(Builder builder, zzaa zzaa) {
            this(builder);
        }

        /* synthetic */ WalletOptions(zzaa zzaa) {
            this();
        }
    }

    public static abstract class zza<R extends Result> extends zzbay<R, gu> {
        public zza(GoogleApiClient googleApiClient) {
            super((Api<?>) Wallet.API, googleApiClient);
        }

        public final /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((Result) obj);
        }

        /* access modifiers changed from: protected */
        @VisibleForTesting
        public abstract void zza(gu guVar) throws RemoteException;
    }

    public static abstract class zzb extends zza<Status> {
        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Result zzb(Status status) {
            return status;
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String str, String str2, int i) {
        Payments.changeMaskedWallet(googleApiClient, str, str2, i);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int i) {
        Payments.checkForPreAuthorization(googleApiClient, i);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
        Payments.loadFullWallet(googleApiClient, fullWalletRequest, i);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
        Payments.loadMaskedWallet(googleApiClient, maskedWalletRequest, i);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        Payments.notifyTransactionStatus(googleApiClient, notifyTransactionStatusRequest);
    }
}
