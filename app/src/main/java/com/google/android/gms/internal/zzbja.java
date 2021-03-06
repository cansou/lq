package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.awareness.fence.FenceQueryRequest;
import com.google.android.gms.common.internal.safeparcel.zzd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class zzbja extends FenceQueryRequest {
    public static final Parcelable.Creator<zzbja> CREATOR = new zzbjc();
    private zzbjb zzaLb;

    public zzbja() {
        this(zzbjb.zza(1, (List<String>) null));
    }

    zzbja(zzbjb zzbjb) {
        this.zzaLb = zzbjb;
    }

    public zzbja(Collection<String> collection) {
        this(zzbjb.zza(2, new ArrayList(collection)));
    }

    public zzbja(String... strArr) {
        this(zzbjb.zza(2, Arrays.asList(strArr)));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, (Parcelable) this.zzaLb, i, false);
        zzd.zzI(parcel, zze);
    }
}
