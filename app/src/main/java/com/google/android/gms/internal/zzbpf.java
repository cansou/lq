package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.drive.DriveId;

public final class zzbpf extends zza {
    public static final Parcelable.Creator<zzbpf> CREATOR = new zzbpg();
    DriveId zzaNt;

    public zzbpf(DriveId driveId) {
        this.zzaNt = driveId;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, (Parcelable) this.zzaNt, i, false);
        zzd.zzI(parcel, zze);
    }
}
