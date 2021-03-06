package com.google.android.gms.gcm;

import android.os.Bundle;

public final class zzi {
    public static final zzi zzbgb = new zzi(0, 30, 3600);
    private static zzi zzbgc = new zzi(1, 30, 3600);
    private final int zzbgd;
    private final int zzbge = 30;
    private final int zzbgf = 3600;

    private zzi(int i, int i2, int i3) {
        this.zzbgd = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzi)) {
            return false;
        }
        zzi zzi = (zzi) obj;
        return zzi.zzbgd == this.zzbgd && zzi.zzbge == this.zzbge && zzi.zzbgf == this.zzbgf;
    }

    public final int hashCode() {
        return (((((this.zzbgd + 1) ^ 1000003) * 1000003) ^ this.zzbge) * 1000003) ^ this.zzbgf;
    }

    public final String toString() {
        int i = this.zzbgd;
        int i2 = this.zzbge;
        return new StringBuilder(74).append("policy=").append(i).append(" initial_backoff=").append(i2).append(" maximum_backoff=").append(this.zzbgf).toString();
    }

    public final int zzvE() {
        return this.zzbgd;
    }

    public final int zzvF() {
        return this.zzbge;
    }

    public final int zzvG() {
        return this.zzbgf;
    }

    public final Bundle zzx(Bundle bundle) {
        bundle.putInt("retry_policy", this.zzbgd);
        bundle.putInt("initial_backoff_seconds", this.zzbge);
        bundle.putInt("maximum_backoff_seconds", this.zzbgf);
        return bundle;
    }
}
