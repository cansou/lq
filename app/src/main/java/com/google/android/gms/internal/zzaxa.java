package com.google.android.gms.internal;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;

final class zzaxa implements Cast.MessageReceivedCallback {
    private /* synthetic */ zzawz zzaxe;

    zzaxa(zzawz zzawz) {
        this.zzaxe = zzawz;
    }

    public final void onMessageReceived(CastDevice castDevice, String str, String str2) {
        this.zzaxe.zzaxd.zzch(str2);
    }
}
