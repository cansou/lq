package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;

public final class WalletFragmentOptions extends zza implements ReflectedParcelable {
    public static final Parcelable.Creator<WalletFragmentOptions> CREATOR = new zzf();
    /* access modifiers changed from: private */
    public int mTheme;
    /* access modifiers changed from: private */
    public int zzaLU;
    /* access modifiers changed from: private */
    public int zzbPT;
    /* access modifiers changed from: private */
    public WalletFragmentStyle zzbQv;

    public final class Builder {
        private Builder() {
        }

        public final WalletFragmentOptions build() {
            return WalletFragmentOptions.this;
        }

        public final Builder setEnvironment(int i) {
            int unused = WalletFragmentOptions.this.zzbPT = i;
            return this;
        }

        public final Builder setFragmentStyle(int i) {
            WalletFragmentStyle unused = WalletFragmentOptions.this.zzbQv = new WalletFragmentStyle().setStyleResourceId(i);
            return this;
        }

        public final Builder setFragmentStyle(WalletFragmentStyle walletFragmentStyle) {
            WalletFragmentStyle unused = WalletFragmentOptions.this.zzbQv = walletFragmentStyle;
            return this;
        }

        public final Builder setMode(int i) {
            int unused = WalletFragmentOptions.this.zzaLU = i;
            return this;
        }

        public final Builder setTheme(int i) {
            int unused = WalletFragmentOptions.this.mTheme = i;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.zzbPT = 3;
        this.zzbQv = new WalletFragmentStyle();
    }

    WalletFragmentOptions(int i, int i2, WalletFragmentStyle walletFragmentStyle, int i3) {
        this.zzbPT = i;
        this.mTheme = i2;
        this.zzbQv = walletFragmentStyle;
        this.zzaLU = i3;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    public static WalletFragmentOptions zza(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_fragmentMode, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.zzbPT = i2;
        walletFragmentOptions.zzbQv = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.zzbQv.zzby(context);
        walletFragmentOptions.zzaLU = i3;
        return walletFragmentOptions;
    }

    public final int getEnvironment() {
        return this.zzbPT;
    }

    public final WalletFragmentStyle getFragmentStyle() {
        return this.zzbQv;
    }

    public final int getMode() {
        return this.zzaLU;
    }

    public final int getTheme() {
        return this.mTheme;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 2, getEnvironment());
        zzd.zzc(parcel, 3, getTheme());
        zzd.zza(parcel, 4, (Parcelable) getFragmentStyle(), i, false);
        zzd.zzc(parcel, 5, getMode());
        zzd.zzI(parcel, zze);
    }

    public final void zzby(Context context) {
        if (this.zzbQv != null) {
            this.zzbQv.zzby(context);
        }
    }
}
