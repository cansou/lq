package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import java.lang.Thread;

final class zzcgi implements Thread.UncaughtExceptionHandler {
    private final String zzbsg;
    private /* synthetic */ zzcgg zzbsh;

    public zzcgi(zzcgg zzcgg, String str) {
        this.zzbsh = zzcgg;
        zzbo.zzu(str);
        this.zzbsg = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zzbsh.zzwF().zzyx().zzj(this.zzbsg, th);
    }
}
