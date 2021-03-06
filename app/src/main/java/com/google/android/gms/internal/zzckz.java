package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.nearby.connection.Connections;

final class zzckz extends zzcnb {
    private final zzbdw<Connections.EndpointDiscoveryListener> zzbwL;

    zzckz(zzbdw<Connections.EndpointDiscoveryListener> zzbdw) {
        this.zzbwL = (zzbdw) zzbo.zzu(zzbdw);
    }

    public final void zza(zzcny zzcny) {
        this.zzbwL.zza(new zzcla(this, zzcny));
    }

    public final void zza(zzcoa zzcoa) {
        this.zzbwL.zza(new zzclb(this, zzcoa));
    }

    public final void zza(zzcok zzcok) {
    }
}
