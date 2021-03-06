package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class VideoInfo extends zza {
    public static final Parcelable.Creator<VideoInfo> CREATOR = new zzbj();
    public static final int HDR_TYPE_DV = 3;
    public static final int HDR_TYPE_HDR = 4;
    public static final int HDR_TYPE_HDR10 = 2;
    public static final int HDR_TYPE_SDR = 1;
    public static final int HDR_TYPE_UNKNOWN = 0;
    private int zzarI;
    private int zzrW;
    private int zzrX;

    VideoInfo(int i, int i2, int i3) {
        this.zzrW = i;
        this.zzrX = i2;
        this.zzarI = i3;
    }

    static VideoInfo zzn(JSONObject jSONObject) {
        int i = 2;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("hdrType");
            char c = 65535;
            switch (string.hashCode()) {
                case 3218:
                    if (string.equals("dv")) {
                        c = 0;
                        break;
                    }
                    break;
                case 103158:
                    if (string.equals("hdr")) {
                        c = 2;
                        break;
                    }
                    break;
                case 113729:
                    if (string.equals("sdr")) {
                        c = 3;
                        break;
                    }
                    break;
                case 99136405:
                    if (string.equals("hdr10")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    i = 3;
                    break;
                case 1:
                    break;
                case 2:
                    i = 4;
                    break;
                case 3:
                    i = 1;
                    break;
                default:
                    Log.d("VideoInfo", String.format(Locale.ROOT, "Unknown HDR type: %s", new Object[]{string}));
                    i = 0;
                    break;
            }
            return new VideoInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), i);
        } catch (JSONException e) {
            Log.d("VideoInfo", String.format(Locale.ROOT, "Error while creating a VideoInfo instance from JSON: %s", new Object[]{e.getMessage()}));
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) obj;
        return this.zzrX == videoInfo.getHeight() && this.zzrW == videoInfo.getWidth() && this.zzarI == videoInfo.getHdrType();
    }

    public final int getHdrType() {
        return this.zzarI;
    }

    public final int getHeight() {
        return this.zzrX;
    }

    public final int getWidth() {
        return this.zzrW;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzrX), Integer.valueOf(this.zzrW), Integer.valueOf(this.zzarI)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 2, getWidth());
        zzd.zzc(parcel, 3, getHeight());
        zzd.zzc(parcel, 4, getHdrType());
        zzd.zzI(parcel, zze);
    }
}
