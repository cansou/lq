package com.google.android.gms.internal;

import java.io.IOException;

public final class acm extends adj<acm> {
    public acm() {
        this.zzcso = null;
        this.zzcsx = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof acm)) {
            return false;
        }
        acm acm = (acm) obj;
        return (this.zzcso == null || this.zzcso.isEmpty()) ? acm.zzcso == null || acm.zzcso.isEmpty() : this.zzcso.equals(acm.zzcso);
    }

    public final int hashCode() {
        return ((this.zzcso == null || this.zzcso.isEmpty()) ? 0 : this.zzcso.hashCode()) + ((getClass().getName().hashCode() + 527) * 31);
    }

    public final /* synthetic */ adp zza(adg adg) throws IOException {
        int zzLA;
        do {
            zzLA = adg.zzLA();
            switch (zzLA) {
                case 0:
                    break;
            }
            return this;
        } while (super.zza(adg, zzLA));
        return this;
    }
}
