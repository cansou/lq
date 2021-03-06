package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class MaskedWalletRequest extends zza implements ReflectedParcelable {
    public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new zzs();
    String zzVJ;
    Cart zzbOB;
    String zzbOn;
    String zzbOr;
    boolean zzbPA;
    ArrayList<CountrySpecification> zzbPB;
    PaymentMethodTokenizationParameters zzbPC;
    ArrayList<Integer> zzbPD;
    boolean zzbPr;
    boolean zzbPs;
    boolean zzbPt;
    String zzbPu;
    String zzbPv;
    private boolean zzbPw;
    boolean zzbPx;
    private CountrySpecification[] zzbPy;
    boolean zzbPz;

    public final class Builder {
        private Builder() {
        }

        public final Builder addAllowedCardNetwork(int i) {
            if (MaskedWalletRequest.this.zzbPD == null) {
                MaskedWalletRequest.this.zzbPD = new ArrayList<>();
            }
            MaskedWalletRequest.this.zzbPD.add(Integer.valueOf(i));
            return this;
        }

        public final Builder addAllowedCardNetworks(Collection<Integer> collection) {
            if (collection != null) {
                if (MaskedWalletRequest.this.zzbPD == null) {
                    MaskedWalletRequest.this.zzbPD = new ArrayList<>();
                }
                MaskedWalletRequest.this.zzbPD.addAll(collection);
            }
            return this;
        }

        public final Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (MaskedWalletRequest.this.zzbPB == null) {
                MaskedWalletRequest.this.zzbPB = new ArrayList<>();
            }
            MaskedWalletRequest.this.zzbPB.add(countrySpecification);
            return this;
        }

        public final Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> collection) {
            if (collection != null) {
                if (MaskedWalletRequest.this.zzbPB == null) {
                    MaskedWalletRequest.this.zzbPB = new ArrayList<>();
                }
                MaskedWalletRequest.this.zzbPB.addAll(collection);
            }
            return this;
        }

        public final MaskedWalletRequest build() {
            return MaskedWalletRequest.this;
        }

        public final Builder setAllowDebitCard(boolean z) {
            MaskedWalletRequest.this.zzbPA = z;
            return this;
        }

        public final Builder setAllowPrepaidCard(boolean z) {
            MaskedWalletRequest.this.zzbPz = z;
            return this;
        }

        public final Builder setCart(Cart cart) {
            MaskedWalletRequest.this.zzbOB = cart;
            return this;
        }

        public final Builder setCountryCode(String str) {
            MaskedWalletRequest.this.zzVJ = str;
            return this;
        }

        public final Builder setCurrencyCode(String str) {
            MaskedWalletRequest.this.zzbOn = str;
            return this;
        }

        public final Builder setEstimatedTotalPrice(String str) {
            MaskedWalletRequest.this.zzbPu = str;
            return this;
        }

        @Deprecated
        public final Builder setIsBillingAgreement(boolean z) {
            MaskedWalletRequest.this.zzbPx = z;
            return this;
        }

        public final Builder setMerchantName(String str) {
            MaskedWalletRequest.this.zzbPv = str;
            return this;
        }

        public final Builder setMerchantTransactionId(String str) {
            MaskedWalletRequest.this.zzbOr = str;
            return this;
        }

        public final Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters) {
            MaskedWalletRequest.this.zzbPC = paymentMethodTokenizationParameters;
            return this;
        }

        public final Builder setPhoneNumberRequired(boolean z) {
            MaskedWalletRequest.this.zzbPr = z;
            return this;
        }

        public final Builder setShippingAddressRequired(boolean z) {
            MaskedWalletRequest.this.zzbPs = z;
            return this;
        }

        @Deprecated
        public final Builder setUseMinimalBillingAddress(boolean z) {
            MaskedWalletRequest.this.zzbPt = z;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.zzbPz = true;
        this.zzbPA = true;
    }

    MaskedWalletRequest(String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4, Cart cart, boolean z4, boolean z5, CountrySpecification[] countrySpecificationArr, boolean z6, boolean z7, ArrayList<CountrySpecification> arrayList, PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, ArrayList<Integer> arrayList2, String str5) {
        this.zzbOr = str;
        this.zzbPr = z;
        this.zzbPs = z2;
        this.zzbPt = z3;
        this.zzbPu = str2;
        this.zzbOn = str3;
        this.zzbPv = str4;
        this.zzbOB = cart;
        this.zzbPw = z4;
        this.zzbPx = z5;
        this.zzbPy = countrySpecificationArr;
        this.zzbPz = z6;
        this.zzbPA = z7;
        this.zzbPB = arrayList;
        this.zzbPC = paymentMethodTokenizationParameters;
        this.zzbPD = arrayList2;
        this.zzVJ = str5;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public final boolean allowDebitCard() {
        return this.zzbPA;
    }

    public final boolean allowPrepaidCard() {
        return this.zzbPz;
    }

    public final ArrayList<Integer> getAllowedCardNetworks() {
        return this.zzbPD;
    }

    public final ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.zzbPB;
    }

    public final CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.zzbPy;
    }

    public final Cart getCart() {
        return this.zzbOB;
    }

    public final String getCountryCode() {
        return this.zzVJ;
    }

    public final String getCurrencyCode() {
        return this.zzbOn;
    }

    public final String getEstimatedTotalPrice() {
        return this.zzbPu;
    }

    public final String getMerchantName() {
        return this.zzbPv;
    }

    public final String getMerchantTransactionId() {
        return this.zzbOr;
    }

    public final PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters() {
        return this.zzbPC;
    }

    @Deprecated
    public final boolean isBillingAgreement() {
        return this.zzbPx;
    }

    public final boolean isPhoneNumberRequired() {
        return this.zzbPr;
    }

    public final boolean isShippingAddressRequired() {
        return this.zzbPs;
    }

    @Deprecated
    public final boolean useMinimalBillingAddress() {
        return this.zzbPt;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, this.zzbOr, false);
        zzd.zza(parcel, 3, this.zzbPr);
        zzd.zza(parcel, 4, this.zzbPs);
        zzd.zza(parcel, 5, this.zzbPt);
        zzd.zza(parcel, 6, this.zzbPu, false);
        zzd.zza(parcel, 7, this.zzbOn, false);
        zzd.zza(parcel, 8, this.zzbPv, false);
        zzd.zza(parcel, 9, (Parcelable) this.zzbOB, i, false);
        zzd.zza(parcel, 10, this.zzbPw);
        zzd.zza(parcel, 11, this.zzbPx);
        zzd.zza(parcel, 12, (T[]) this.zzbPy, i, false);
        zzd.zza(parcel, 13, this.zzbPz);
        zzd.zza(parcel, 14, this.zzbPA);
        zzd.zzc(parcel, 15, this.zzbPB, false);
        zzd.zza(parcel, 16, (Parcelable) this.zzbPC, i, false);
        zzd.zza(parcel, 17, (List<Integer>) this.zzbPD, false);
        zzd.zza(parcel, 18, this.zzVJ, false);
        zzd.zzI(parcel, zze);
    }
}
