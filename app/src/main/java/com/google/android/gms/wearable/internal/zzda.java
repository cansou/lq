package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;

public final class zzda extends zza {
    public static final Parcelable.Creator<zzda> CREATOR = new zzdb();
    public final int statusCode;
    public final zzcb zzbSP;

    public zzda(int i, zzcb zzcb) {
        this.statusCode = i;
        this.zzbSP = zzcb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 2, this.statusCode);
        zzd.zza(parcel, 3, (Parcelable) this.zzbSP, i, false);
        zzd.zzI(parcel, zze);
    }
}
