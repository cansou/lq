package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

public final class zzax extends OutputStream {
    private volatile zzah zzbSr;
    private final OutputStream zzbSt;

    public zzax(OutputStream outputStream) {
        this.zzbSt = (OutputStream) zzbo.zzu(outputStream);
    }

    private final IOException zza(IOException iOException) {
        zzah zzah = this.zzbSr;
        if (zzah == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new ChannelIOException("Channel closed unexpectedly before stream was finished", zzah.zzbSh, zzah.zzbSi);
    }

    public final void close() throws IOException {
        try {
            this.zzbSt.close();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public final void flush() throws IOException {
        try {
            this.zzbSt.flush();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public final void write(int i) throws IOException {
        try {
            this.zzbSt.write(i);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public final void write(byte[] bArr) throws IOException {
        try {
            this.zzbSt.write(bArr);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.zzbSt.write(bArr, i, i2);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzah zzah) {
        this.zzbSr = zzah;
    }
}
