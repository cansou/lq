package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;

public final class zzcyy implements zzcxo {
    public final dp<?> zzb(zzcwa zzcwa, dp<?>... dpVarArr) {
        zzbo.zzaf(dpVarArr != null);
        zzbo.zzaf(dpVarArr.length == 2);
        dp<?> zza = ed.zza(zzcwa, (dp) dpVarArr[0]);
        return zzcxp.zza(zza) ? zza : ed.zza(zzcwa, (dp) dpVarArr[1]);
    }
}
