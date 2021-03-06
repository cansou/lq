package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;

public final class zzdo extends zzed implements zzdn {
    zzdo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wearable.internal.IWearableService");
    }

    public final void zza(zzdi zzdi) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzb(8, zzZ);
    }

    public final void zza(zzdi zzdi, int i) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzZ.writeInt(i);
        zzb(43, zzZ);
    }

    public final void zza(zzdi zzdi, Uri uri) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzef.zza(zzZ, (Parcelable) uri);
        zzb(7, zzZ);
    }

    public final void zza(zzdi zzdi, Uri uri, int i) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzef.zza(zzZ, (Parcelable) uri);
        zzZ.writeInt(i);
        zzb(40, zzZ);
    }

    public final void zza(zzdi zzdi, Asset asset) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzef.zza(zzZ, (Parcelable) asset);
        zzb(13, zzZ);
    }

    public final void zza(zzdi zzdi, PutDataRequest putDataRequest) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzef.zza(zzZ, (Parcelable) putDataRequest);
        zzb(6, zzZ);
    }

    public final void zza(zzdi zzdi, zzd zzd) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzef.zza(zzZ, (Parcelable) zzd);
        zzb(16, zzZ);
    }

    public final void zza(zzdi zzdi, zzdg zzdg, String str) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzef.zza(zzZ, (IInterface) zzdg);
        zzZ.writeString(str);
        zzb(34, zzZ);
    }

    public final void zza(zzdi zzdi, zzeo zzeo) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzef.zza(zzZ, (Parcelable) zzeo);
        zzb(17, zzZ);
    }

    public final void zza(zzdi zzdi, String str) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzZ.writeString(str);
        zzb(46, zzZ);
    }

    public final void zza(zzdi zzdi, String str, int i) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzZ.writeString(str);
        zzZ.writeInt(i);
        zzb(42, zzZ);
    }

    public final void zza(zzdi zzdi, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzZ.writeString(str);
        zzef.zza(zzZ, (Parcelable) parcelFileDescriptor);
        zzb(38, zzZ);
    }

    public final void zza(zzdi zzdi, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzZ.writeString(str);
        zzef.zza(zzZ, (Parcelable) parcelFileDescriptor);
        zzZ.writeLong(j);
        zzZ.writeLong(j2);
        zzb(39, zzZ);
    }

    public final void zza(zzdi zzdi, String str, String str2) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzZ.writeString(str);
        zzZ.writeString(str2);
        zzb(31, zzZ);
    }

    public final void zza(zzdi zzdi, String str, String str2, byte[] bArr) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzZ.writeString(str);
        zzZ.writeString(str2);
        zzZ.writeByteArray(bArr);
        zzb(12, zzZ);
    }

    public final void zzb(zzdi zzdi) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzb(14, zzZ);
    }

    public final void zzb(zzdi zzdi, Uri uri, int i) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzef.zza(zzZ, (Parcelable) uri);
        zzZ.writeInt(i);
        zzb(41, zzZ);
    }

    public final void zzb(zzdi zzdi, zzdg zzdg, String str) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzef.zza(zzZ, (IInterface) zzdg);
        zzZ.writeString(str);
        zzb(35, zzZ);
    }

    public final void zzb(zzdi zzdi, String str) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzZ.writeString(str);
        zzb(47, zzZ);
    }

    public final void zzb(zzdi zzdi, String str, int i) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzZ.writeString(str);
        zzZ.writeInt(i);
        zzb(33, zzZ);
    }

    public final void zzc(zzdi zzdi) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzb(15, zzZ);
    }

    public final void zzc(zzdi zzdi, String str) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzdi);
        zzZ.writeString(str);
        zzb(32, zzZ);
    }
}
