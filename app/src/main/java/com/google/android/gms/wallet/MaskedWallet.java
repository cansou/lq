package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet extends zza implements ReflectedParcelable {
    public static final Parcelable.Creator<MaskedWallet> CREATOR = new zzq();
    String zzbOq;
    String zzbOr;
    String zzbOt;
    private zza zzbOu;
    private zza zzbOv;
    String[] zzbOw;
    UserAddress zzbOx;
    UserAddress zzbOy;
    InstrumentInfo[] zzbOz;
    private LoyaltyWalletObject[] zzbPo;
    private OfferWalletObject[] zzbPp;

    public final class Builder {
        private Builder() {
        }

        public final MaskedWallet build() {
            return MaskedWallet.this;
        }

        public final Builder setBuyerBillingAddress(UserAddress userAddress) {
            MaskedWallet.this.zzbOx = userAddress;
            return this;
        }

        public final Builder setBuyerShippingAddress(UserAddress userAddress) {
            MaskedWallet.this.zzbOy = userAddress;
            return this;
        }

        public final Builder setEmail(String str) {
            MaskedWallet.this.zzbOt = str;
            return this;
        }

        public final Builder setGoogleTransactionId(String str) {
            MaskedWallet.this.zzbOq = str;
            return this;
        }

        public final Builder setInstrumentInfos(InstrumentInfo[] instrumentInfoArr) {
            MaskedWallet.this.zzbOz = instrumentInfoArr;
            return this;
        }

        public final Builder setMerchantTransactionId(String str) {
            MaskedWallet.this.zzbOr = str;
            return this;
        }

        public final Builder setPaymentDescriptions(String[] strArr) {
            MaskedWallet.this.zzbOw = strArr;
            return this;
        }
    }

    private MaskedWallet() {
    }

    MaskedWallet(String str, String str2, String[] strArr, String str3, zza zza, zza zza2, LoyaltyWalletObject[] loyaltyWalletObjectArr, OfferWalletObject[] offerWalletObjectArr, UserAddress userAddress, UserAddress userAddress2, InstrumentInfo[] instrumentInfoArr) {
        this.zzbOq = str;
        this.zzbOr = str2;
        this.zzbOw = strArr;
        this.zzbOt = str3;
        this.zzbOu = zza;
        this.zzbOv = zza2;
        this.zzbPo = loyaltyWalletObjectArr;
        this.zzbPp = offerWalletObjectArr;
        this.zzbOx = userAddress;
        this.zzbOy = userAddress2;
        this.zzbOz = instrumentInfoArr;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedWallet) {
        zzbo.zzu(maskedWallet);
        MaskedWallet maskedWallet2 = new MaskedWallet();
        maskedWallet2.getClass();
        Builder email = new Builder().setGoogleTransactionId(maskedWallet.getGoogleTransactionId()).setMerchantTransactionId(maskedWallet.getMerchantTransactionId()).setPaymentDescriptions(maskedWallet.getPaymentDescriptions()).setInstrumentInfos(maskedWallet.getInstrumentInfos()).setEmail(maskedWallet.getEmail());
        MaskedWallet.this.zzbPo = maskedWallet.zzbPo;
        MaskedWallet.this.zzbPp = maskedWallet.zzbPp;
        return email.setBuyerBillingAddress(maskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedWallet.getBuyerShippingAddress());
    }

    public final UserAddress getBuyerBillingAddress() {
        return this.zzbOx;
    }

    public final UserAddress getBuyerShippingAddress() {
        return this.zzbOy;
    }

    public final String getEmail() {
        return this.zzbOt;
    }

    public final String getGoogleTransactionId() {
        return this.zzbOq;
    }

    public final InstrumentInfo[] getInstrumentInfos() {
        return this.zzbOz;
    }

    public final String getMerchantTransactionId() {
        return this.zzbOr;
    }

    public final String[] getPaymentDescriptions() {
        return this.zzbOw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, this.zzbOq, false);
        zzd.zza(parcel, 3, this.zzbOr, false);
        zzd.zza(parcel, 4, this.zzbOw, false);
        zzd.zza(parcel, 5, this.zzbOt, false);
        zzd.zza(parcel, 6, (Parcelable) this.zzbOu, i, false);
        zzd.zza(parcel, 7, (Parcelable) this.zzbOv, i, false);
        zzd.zza(parcel, 8, (T[]) this.zzbPo, i, false);
        zzd.zza(parcel, 9, (T[]) this.zzbPp, i, false);
        zzd.zza(parcel, 10, (Parcelable) this.zzbOx, i, false);
        zzd.zza(parcel, 11, (Parcelable) this.zzbOy, i, false);
        zzd.zza(parcel, 12, (T[]) this.zzbOz, i, false);
        zzd.zzI(parcel, zze);
    }
}
