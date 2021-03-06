package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.wearable.ConnectionConfiguration;

@Deprecated
public final class zzcu extends zza {
    public static final Parcelable.Creator<zzcu> CREATOR = new zzcv();
    private int statusCode;
    private ConnectionConfiguration zzbSM;

    public zzcu(int i, ConnectionConfiguration connectionConfiguration) {
        this.statusCode = i;
        this.zzbSM = connectionConfiguration;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 2, this.statusCode);
        zzd.zza(parcel, 3, (Parcelable) this.zzbSM, i, false);
        zzd.zzI(parcel, zze);
    }
}
