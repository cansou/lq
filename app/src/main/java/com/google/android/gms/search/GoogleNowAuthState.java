package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;

public class GoogleNowAuthState extends zza {
    public static final Parcelable.Creator<GoogleNowAuthState> CREATOR = new zza();
    private String zzbCw;
    private String zzbCx;
    private long zzbCy;

    GoogleNowAuthState(String str, String str2, long j) {
        this.zzbCw = str;
        this.zzbCx = str2;
        this.zzbCy = j;
    }

    public String getAccessToken() {
        return this.zzbCx;
    }

    public String getAuthCode() {
        return this.zzbCw;
    }

    public long getNextAllowedTimeMillis() {
        return this.zzbCy;
    }

    public String toString() {
        String str = this.zzbCw;
        String str2 = this.zzbCx;
        return new StringBuilder(String.valueOf(str).length() + 74 + String.valueOf(str2).length()).append("mAuthCode = ").append(str).append("\nmAccessToken = ").append(str2).append("\nmNextAllowedTimeMillis = ").append(this.zzbCy).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 1, getAuthCode(), false);
        zzd.zza(parcel, 2, getAccessToken(), false);
        zzd.zza(parcel, 3, getNextAllowedTimeMillis());
        zzd.zzI(parcel, zze);
    }
}
