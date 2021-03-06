package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.internal.zzcpj;
import java.util.Arrays;

public class Message extends zza implements ReflectedParcelable {
    public static final Parcelable.Creator<Message> CREATOR = new zza();
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    public static final String MESSAGE_NAMESPACE_RESERVED = "__reserved_namespace";
    public static final String MESSAGE_TYPE_AUDIO_BYTES = "__audio_bytes";
    public static final String MESSAGE_TYPE_EDDYSTONE_UID = "__eddystone_uid";
    public static final String MESSAGE_TYPE_I_BEACON_ID = "__i_beacon_id";
    private static final zzcpj[] zzbxT = {zzcpj.zzbyM};
    private final byte[] content;
    private final String type;
    private int versionCode;
    private final String zzbxU;
    @Deprecated
    private zzcpj[] zzbxV;
    private final long zzbxW;

    Message(int i, @Nullable byte[] bArr, @Nullable String str, String str2, @Nullable zzcpj[] zzcpjArr, long j) {
        this.versionCode = i;
        this.type = (String) zzbo.zzu(str2);
        this.zzbxU = str == null ? "" : str;
        this.zzbxW = 0;
        zzbo.zzu(bArr);
        zzbo.zzb(bArr.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(bArr.length), Integer.valueOf(MAX_CONTENT_SIZE_BYTES));
        this.content = bArr;
        this.zzbxV = (zzcpjArr == null || zzcpjArr.length == 0) ? zzbxT : zzcpjArr;
        zzbo.zzb(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), 32);
    }

    public Message(byte[] bArr) {
        this(bArr, "", "");
    }

    public Message(byte[] bArr, String str) {
        this(bArr, "", str);
    }

    public Message(byte[] bArr, String str, String str2) {
        this(bArr, str, str2, zzbxT);
    }

    private Message(byte[] bArr, String str, String str2, zzcpj[] zzcpjArr) {
        this(bArr, str, str2, zzcpjArr, 0);
    }

    private Message(byte[] bArr, String str, String str2, zzcpj[] zzcpjArr, long j) {
        this(2, bArr, str, str2, zzcpjArr, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.zzbxU, message.zzbxU) && TextUtils.equals(this.type, message.type) && Arrays.equals(this.content, message.content) && 0 == 0;
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getNamespace() {
        return this.zzbxU;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzbxU, this.type, Integer.valueOf(Arrays.hashCode(this.content)), 0L});
    }

    public String toString() {
        String str = this.zzbxU;
        String str2 = this.type;
        return new StringBuilder(String.valueOf(str).length() + 59 + String.valueOf(str2).length()).append("Message{namespace='").append(str).append("', type='").append(str2).append("', content=[").append(this.content == null ? 0 : this.content.length).append(" bytes]}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 1, getContent(), false);
        zzd.zza(parcel, 2, getType(), false);
        zzd.zza(parcel, 3, getNamespace(), false);
        zzd.zza(parcel, 4, (T[]) this.zzbxV, i, false);
        zzd.zza(parcel, 5, 0);
        zzd.zzc(parcel, 1000, this.versionCode);
        zzd.zzI(parcel, zze);
    }

    public final boolean zzeD(String str) {
        return MESSAGE_NAMESPACE_RESERVED.equals(getNamespace()) && str.equals(getType());
    }
}
