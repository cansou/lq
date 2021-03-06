package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import com.google.firebase.FirebaseApp;
import java.util.Random;

public final class abu {
    private static zze zzalN = zzi.zzrY();
    private static Random zzbRi = new Random();
    private static abw zzcqe = new abx();
    private volatile boolean zzJ;
    private FirebaseApp zzckw;
    private long zzcqf;

    public abu(FirebaseApp firebaseApp, long j) {
        this.zzckw = firebaseApp;
        this.zzcqf = j;
    }

    public static boolean zzcj(int i) {
        return (i >= 500 && i < 600) || i == -2 || i == 429 || i == 408;
    }

    public final void cancel() {
        this.zzJ = true;
    }

    public final void reset() {
        this.zzJ = false;
    }

    public final void zza(@NonNull acf acf, boolean z) {
        zzbo.zzu(acf);
        long elapsedRealtime = zzalN.elapsedRealtime() + this.zzcqf;
        if (z) {
            acf.zze(abz.zzf(this.zzckw), this.zzckw.getApplicationContext());
        } else {
            acf.zzhN(abz.zzf(this.zzckw));
        }
        int i = 1000;
        while (zzalN.elapsedRealtime() + ((long) i) <= elapsedRealtime && !acf.zzLk() && zzcj(acf.getResultCode())) {
            try {
                zzcqe.zzck(zzbRi.nextInt(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + i);
                if (i < 30000) {
                    if (acf.getResultCode() != -2) {
                        i <<= 1;
                        Log.w("ExponenentialBackoff", "network error occurred, backing off/sleeping.");
                    } else {
                        Log.w("ExponenentialBackoff", "network unavailable, sleeping.");
                        i = 1000;
                    }
                }
                if (!this.zzJ) {
                    acf.reset();
                    if (z) {
                        acf.zze(abz.zzf(this.zzckw), this.zzckw.getApplicationContext());
                    } else {
                        acf.zzhN(abz.zzf(this.zzckw));
                    }
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                Log.w("ExponenentialBackoff", "thread interrupted during exponential backoff.");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
