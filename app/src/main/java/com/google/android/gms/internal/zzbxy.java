package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.GoalsReadRequest;
import com.google.android.gms.fitness.result.GoalsResult;
import java.util.Collections;

final class zzbxy extends zzbuy<GoalsResult> {
    private /* synthetic */ GoalsReadRequest zzaVE;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbxy(zzbxx zzbxx, GoogleApiClient googleApiClient, GoalsReadRequest goalsReadRequest) {
        super(googleApiClient);
        this.zzaVE = goalsReadRequest;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Api.zzb zzb) throws RemoteException {
        ((zzbwl) ((zzbux) zzb).zzrf()).zza(new GoalsReadRequest(this.zzaVE, (zzbwe) new zzbxz(this)));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result zzb(Status status) {
        return new GoalsResult(status, Collections.emptyList());
    }
}
