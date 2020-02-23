package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzw implements Parcelable.Creator<zzv> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzb.zzd(parcel);
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    filterHolder = (FilterHolder) zzb.zza(parcel, readInt, FilterHolder.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, readInt);
                    break;
            }
        }
        zzb.zzF(parcel, zzd);
        return new zzv(filterHolder);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzv[i];
    }
}
