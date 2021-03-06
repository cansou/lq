package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaxx;
import com.google.android.gms.internal.zzayi;
import com.google.android.gms.internal.zzbaz;

final class zzj extends zzayi {
    zzj(Cast.CastApi.zza zza, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final void zza(zzaxx zzaxx) throws RemoteException {
        try {
            zzaxx.zzb((zzbaz<Status>) this);
        } catch (IllegalStateException e) {
            zzad(2001);
        }
    }
}
