package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n;

class ay implements n.a {
    final /* synthetic */ TbsLogReport a;

    ay(TbsLogReport tbsLogReport) {
        this.a = tbsLogReport;
    }

    public void a(int i) {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i);
        if (i < 300) {
            this.a.h();
        }
    }
}
