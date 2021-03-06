package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.internal.zzayq;
import java.util.List;

final class zzi implements zzayq {
    private /* synthetic */ RemoteMediaClient zzauy;

    zzi(RemoteMediaClient remoteMediaClient) {
        this.zzauy = remoteMediaClient;
    }

    private final void zzoa() {
        MediaStatus mediaStatus;
        if (this.zzauy.zzaux != null && (mediaStatus = this.zzauy.getMediaStatus()) != null) {
            mediaStatus.zzV(this.zzauy.zzaux.parseIsPlayingAdFromMediaStatus(mediaStatus));
            List<AdBreakInfo> parseAdBreaksFromMediaStatus = this.zzauy.zzaux.parseAdBreaksFromMediaStatus(mediaStatus);
            MediaInfo mediaInfo = this.zzauy.getMediaInfo();
            if (mediaInfo != null) {
                mediaInfo.zzz(parseAdBreaksFromMediaStatus);
            }
        }
    }

    public final void onAdBreakStatusUpdated() {
        for (RemoteMediaClient.Listener onAdBreakStatusUpdated : this.zzauy.mListeners) {
            onAdBreakStatusUpdated.onAdBreakStatusUpdated();
        }
    }

    public final void onMetadataUpdated() {
        zzoa();
        for (RemoteMediaClient.Listener onMetadataUpdated : this.zzauy.mListeners) {
            onMetadataUpdated.onMetadataUpdated();
        }
    }

    public final void onPreloadStatusUpdated() {
        for (RemoteMediaClient.Listener onPreloadStatusUpdated : this.zzauy.mListeners) {
            onPreloadStatusUpdated.onPreloadStatusUpdated();
        }
    }

    public final void onQueueStatusUpdated() {
        for (RemoteMediaClient.Listener onQueueStatusUpdated : this.zzauy.mListeners) {
            onQueueStatusUpdated.onQueueStatusUpdated();
        }
    }

    public final void onStatusUpdated() {
        zzoa();
        this.zzauy.zznZ();
        for (RemoteMediaClient.Listener onStatusUpdated : this.zzauy.mListeners) {
            onStatusUpdated.onStatusUpdated();
        }
    }
}
