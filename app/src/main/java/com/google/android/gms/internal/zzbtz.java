package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;

public final class zzbtz extends zza {
    public static final Parcelable.Creator<zzbtz> CREATOR = new zzbua();
    private int mIndex;
    private int zzaRJ;
    private int zzaRK;
    private String zzaSk;
    private int zzaSl;

    zzbtz(int i, int i2, int i3, String str, int i4) {
        this.mIndex = i;
        this.zzaRJ = i2;
        this.zzaRK = i3;
        this.zzaSk = str;
        this.zzaSl = i4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 2, this.mIndex);
        zzd.zzc(parcel, 3, this.zzaRJ);
        zzd.zzc(parcel, 4, this.zzaRK);
        zzd.zza(parcel, 5, this.zzaSk, false);
        zzd.zzc(parcel, 6, this.zzaSl);
        zzd.zzI(parcel, zze);
    }
}
