package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzbae extends zzee implements zzbad {
    public zzbae() {
        attachInterface(this, "com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzl((Status) zzef.zza(parcel, Status.CREATOR));
                break;
            case 2:
                zzm((Status) zzef.zza(parcel, Status.CREATOR));
                break;
            case 3:
                zza((Status) zzef.zza(parcel, Status.CREATOR), parcel.readLong());
                break;
            case 4:
                zzn((Status) zzef.zza(parcel, Status.CREATOR));
                break;
            case 5:
                zzb((Status) zzef.zza(parcel, Status.CREATOR), parcel.readLong());
                break;
            case 6:
                zza((Status) zzef.zza(parcel, Status.CREATOR), (zzazu[]) parcel.createTypedArray(zzazu.CREATOR));
                break;
            case 7:
                zza((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
