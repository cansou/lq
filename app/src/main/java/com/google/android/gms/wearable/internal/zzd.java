package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzd extends zza {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    private zzdk zzbRJ;
    private IntentFilter[] zzbRK;
    private String zzbRL;
    private String zzbRM;

    zzd(IBinder iBinder, IntentFilter[] intentFilterArr, String str, String str2) {
        zzdk zzdk = null;
        if (iBinder != null) {
            if (iBinder != null) {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
                zzdk = queryLocalInterface instanceof zzdk ? (zzdk) queryLocalInterface : new zzdm(iBinder);
            }
            this.zzbRJ = zzdk;
        } else {
            this.zzbRJ = null;
        }
        this.zzbRK = intentFilterArr;
        this.zzbRL = str;
        this.zzbRM = str2;
    }

    public zzd(zzga zzga) {
        this.zzbRJ = zzga;
        this.zzbRK = zzga.zzDY();
        this.zzbRL = zzga.zzDZ();
        this.zzbRM = null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzbRJ == null ? null : this.zzbRJ.asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, (T[]) this.zzbRK, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, this.zzbRL, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 5, this.zzbRM, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzI(parcel, zze);
    }
}
