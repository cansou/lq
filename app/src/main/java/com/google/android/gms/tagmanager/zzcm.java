package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzef;

public final class zzcm extends zzed implements zzck {
    zzcm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.IMeasurementInterceptor");
    }

    public final void interceptEvent(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel zzZ = zzZ();
        zzZ.writeString(str);
        zzZ.writeString(str2);
        zzef.zza(zzZ, (Parcelable) bundle);
        zzZ.writeLong(j);
        zzb(2, zzZ);
    }
}
