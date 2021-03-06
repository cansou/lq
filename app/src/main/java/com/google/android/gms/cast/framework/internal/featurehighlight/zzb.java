package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector;
import android.view.MotionEvent;

final class zzb extends GestureDetector.SimpleOnGestureListener {
    private /* synthetic */ zza zzatc;

    zzb(zza zza) {
        this.zzatc = zza;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.zzatc.zzc(x, y) && this.zzatc.zzasS.zzd(x, y)) {
            return true;
        }
        this.zzatc.zzata.dismiss();
        return true;
    }
}
