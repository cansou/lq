package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzu implements Parcelable.Creator<zzt> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzb.zzd(parcel);
        while (parcel.dataPosition() < zzd) {
            zzb.zzb(parcel, parcel.readInt());
        }
        zzb.zzF(parcel, zzd);
        return new zzt();
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzt[i];
    }
}
