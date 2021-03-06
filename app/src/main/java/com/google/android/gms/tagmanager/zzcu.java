package com.google.android.gms.tagmanager;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzcvg;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;

public abstract class zzcu extends zzee implements zzct {
    public zzcu() {
        attachInterface(this, "com.google.android.gms.tagmanager.ITagManagerServiceProvider");
    }

    public static zzct asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.tagmanager.ITagManagerServiceProvider");
        return queryLocalInterface instanceof zzct ? (zzct) queryLocalInterface : new zzcv(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzcn zzcp;
        zzce zzce = null;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        IObjectWrapper zzM = IObjectWrapper.zza.zzM(parcel.readStrongBinder());
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzcp = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.tagmanager.IMeasurementProxy");
            zzcp = queryLocalInterface instanceof zzcn ? (zzcn) queryLocalInterface : new zzcp(readStrongBinder);
        }
        IBinder readStrongBinder2 = parcel.readStrongBinder();
        if (readStrongBinder2 != null) {
            IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.tagmanager.ICustomEvaluatorProxy");
            zzce = queryLocalInterface2 instanceof zzce ? (zzce) queryLocalInterface2 : new zzcg(readStrongBinder2);
        }
        zzcvg service = getService(zzM, zzcp, zzce);
        parcel2.writeNoException();
        zzef.zza(parcel2, (IInterface) service);
        return true;
    }
}
