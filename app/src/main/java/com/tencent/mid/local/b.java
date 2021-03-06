package com.tencent.mid.local;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

class b extends g {
    b(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return i.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted");
    }

    /* access modifiers changed from: protected */
    public String b() {
        String str;
        String str2 = null;
        synchronized (this) {
            i.a("read mid from InternalStorage");
            File file = new File(Environment.getExternalStorageDirectory(), c());
            if (file != null) {
                try {
                    Iterator<String> it = a.a(file).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str = null;
                            break;
                        }
                        String[] split = it.next().split(",");
                        if (split.length == 2 && split[0].equals(e())) {
                            i.a("read mid from InternalStorage:" + split[1]);
                            str = split[1];
                            break;
                        }
                    }
                    str2 = str;
                } catch (IOException e) {
                    i.a((Throwable) e);
                }
            }
        }
        return str2;
    }
}
