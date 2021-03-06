package com.google.android.gms.vision.barcode;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.internal.eu;
import com.google.android.gms.internal.ew;
import com.google.android.gms.internal.fc;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;

public final class BarcodeDetector extends Detector<Barcode> {
    private final ew zzbNg;

    public static class Builder {
        private Context mContext;
        private eu zzbNh = new eu();

        public Builder(Context context) {
            this.mContext = context;
        }

        public BarcodeDetector build() {
            return new BarcodeDetector(new ew(this.mContext, this.zzbNh));
        }

        public Builder setBarcodeFormats(int i) {
            this.zzbNh.zzbNi = i;
            return this;
        }
    }

    private BarcodeDetector() {
        throw new IllegalStateException("Default constructor called");
    }

    private BarcodeDetector(ew ewVar) {
        this.zzbNg = ewVar;
    }

    public final SparseArray<Barcode> detect(Frame frame) {
        Barcode[] barcodeArr;
        if (frame == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        fc zzc = fc.zzc(frame);
        if (frame.getBitmap() != null) {
            barcodeArr = this.zzbNg.zza(frame.getBitmap(), zzc);
            if (barcodeArr == null) {
                throw new IllegalArgumentException("Internal barcode detector error; check logcat output.");
            }
        } else {
            barcodeArr = this.zzbNg.zza(frame.getGrayscaleImageData(), zzc);
        }
        SparseArray<Barcode> sparseArray = new SparseArray<>(barcodeArr.length);
        for (Barcode barcode : barcodeArr) {
            sparseArray.append(barcode.rawValue.hashCode(), barcode);
        }
        return sparseArray;
    }

    public final boolean isOperational() {
        return this.zzbNg.isOperational();
    }

    public final void release() {
        super.release();
        this.zzbNg.zzDQ();
    }
}
