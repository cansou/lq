package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;

public final class zzeo extends zza {
    public static final Parcelable.Creator<zzeo> CREATOR = new zzep();
    private int zzaku;
    private zzdk zzbRJ;

    zzeo(int i, IBinder iBinder) {
        zzdk zzdk = null;
        this.zzaku = i;
        if (iBinder != null) {
            if (iBinder != null) {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
                zzdk = queryLocalInterface instanceof zzdk ? (zzdk) queryLocalInterface : new zzdm(iBinder);
            }
            this.zzbRJ = zzdk;
            return;
        }
        this.zzbRJ = null;
    }

    public zzeo(zzdk zzdk) {
        this.zzaku = 1;
        this.zzbRJ = zzdk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zza(parcel, 2, this.zzbRJ == null ? null : this.zzbRJ.asBinder(), false);
        zzd.zzI(parcel, zze);
    }
}
