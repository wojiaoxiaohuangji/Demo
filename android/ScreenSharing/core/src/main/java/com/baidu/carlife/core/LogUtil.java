package com.baidu.carlife.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.baidu.mobstat.Config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LogUtil implements KeepClass {
    /* renamed from: a */
    public static final boolean IS_WRITE_TO_FILE = false;
    /* renamed from: b */
    public static final String LOG_FILE = "_Carlife.log";
    /* renamed from: c */
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault());
    /* renamed from: e */
    private static final String Tag = "com.baidu.carlife#";
    /* renamed from: f */
    private static Map<String, Long> sLogMap = new HashMap();
    /* renamed from: g */
    private static LogUtil sLogUtil;
    /* renamed from: d */
    public LogUtilThread mLogUtilThread;

    /* compiled from: LogUtil */
    /* renamed from: com.baidu.carlife.core.i$a */
    private class LogUtilThread extends Thread {
        /* renamed from: a */
        final /* synthetic */ LogUtil f3606a;
        /* renamed from: b */
        private final long f3607b;
        /* renamed from: c */
        private final long f3608c;
        /* renamed from: d */
        private final long f3609d;
        /* renamed from: e */
        private final String f3610e;
        /* renamed from: f */
        private final SimpleDateFormat f3611f;
        /* renamed from: g */
        private final SimpleDateFormat f3612g;
        /* renamed from: h */
        private Handler f3613h;
        /* renamed from: i */
        private Looper f3614i;
        /* renamed from: j */
        private File f3615j;
        /* renamed from: k */
        private File f3616k;
        /* renamed from: l */
        private FileWriter f3617l;
        /* renamed from: m */
        private Comparator<File> f3618m;

        /* compiled from: LogUtil */
        /* renamed from: com.baidu.carlife.core.i$a$1 */
        class C12571 implements Comparator<File> {
            // renamed from: a
            final /* synthetic */ LogUtilThread f3604a;

            C12571(LogUtilThread this$1) {
                this.f3604a = this$1;
            }

            @Override
            public int compare(File file, File t1) {
                return (int) (t1.lastModified() - file.lastModified());
            }
        }

        private LogUtilThread(LogUtil LogUtil) {
            this.f3606a = LogUtil;
            this.f3607b = 5242880;
            this.f3608c = 86400000;
            this.f3609d = 20;
            this.f3610e = CommonParams.jm + File.separator + "debugLog" + File.separator;
            this.f3611f = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
            this.f3612g = new SimpleDateFormat("MM-dd_HH_mm_ss.SS");
            this.f3618m = new C12571(this);
        }

        /* renamed from: a */
        public File m4421a() {
            return this.f3616k;
        }

        public void run() {
            this.f3615j = new File(this.f3610e);
            if (!this.f3615j.exists()) {
                this.f3615j.mkdirs();
            }
            File tempFile = null;
            File[] files = this.f3615j.listFiles();
            Arrays.sort(files, this.f3618m);
            if (files != null && files.length > 0) {
                tempFile = files[0];
            }
            if (tempFile != null) {
                long fileCreateTime = 0;
                try {
                    fileCreateTime = this.f3611f.parse(tempFile.getName().substring(0, tempFile.getName().length() - 4)).getTime();
                } catch (ParseException e) {
                    tempFile.delete();
                }
                if (fileCreateTime > 0 && new Date().getTime() - fileCreateTime < 86400000) {
                    this.f3616k = tempFile;
                    try {
                        this.f3617l = new FileWriter(this.f3616k, true);
                    } catch (IOException e2) {
                    }
                }
            }
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            this.f3614i = Looper.myLooper();
            this.f3613h = new Handler(this.f3614i) {
                /* renamed from: a */
//                final /* synthetic */ LogUtilThread f3605a;

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void handleMessage(Message r13) {
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.core.i.a.2.handleMessage(android.os.Message):void");
                }
            };
            Looper.loop();
        }

        /* renamed from: a */
        public void m4422a(File file) {
            LogUtil.d(LogUtil.Tag, "insertDivider not impl.");
        }

        /* renamed from: b */
        public void m4425b() {
            if (this.f3617l != null) {
                try {
                    this.f3617l.close();
                    this.f3617l = null;
                } catch (IOException e) {
                }
            }
            if (this.f3614i != null) {
                this.f3614i.quit();
                this.f3613h = null;
            }
        }

        /* renamed from: a */
        public void m4424a(Throwable throwable) {
            if (this.f3613h != null) {
                String log = this.f3612g.format(new Date()) + "/CarLife Crash!\n";
                Message msg = Message.obtain();
                msg.obj = log + Log.getStackTraceString(throwable);
                this.f3613h.sendMessage(msg);
            }
        }

        /* renamed from: a */
        public void m4423a(String level, String tag, String format) {
            if (this.f3613h != null) {
                String log = this.f3612g.format(new Date()) + " " + level + "/" + tag + Config.TRACE_TODAY_VISIT_SPLIT + format + "\n";
                Message msg = Message.obtain();
                msg.obj = log;
                this.f3613h.sendMessage(msg);
            }
        }
    }

    /* renamed from: a */
    public static LogUtil m4426a() {
        if (sLogUtil == null) {
            sLogUtil = new LogUtil();
        }
        return sLogUtil;
    }

    /* renamed from: b */
    public void m4448b() {
        if (CarlifeUtil.m4382t() && CommonParams.ju && this.mLogUtilThread == null) {
            this.mLogUtilThread = new LogUtilThread(this.sLogUtil);
            this.mLogUtilThread.start();
        }
    }

    /* renamed from: c */
    public void m4449c() {
        if (this.mLogUtilThread != null) {
            this.mLogUtilThread.m4425b();
        }
    }

    /* renamed from: d */
    public void m4450d() {
        if (this.mLogUtilThread != null && this.mLogUtilThread.m4421a() != null) {
            this.mLogUtilThread.m4422a(this.mLogUtilThread.m4421a());
        }
    }

    /* renamed from: b */
    private void m4436b(String level, String tag, String format) {
        if (this.mLogUtilThread != null && CarlifeUtil.m4382t() && CommonParams.ju) {
            this.mLogUtilThread.m4423a(level, tag, format);
        }
    }

    /* renamed from: c */
    private void m4442c(Throwable throwable) {
        if (this.mLogUtilThread != null && CarlifeUtil.m4382t() && CommonParams.ju) {
            this.mLogUtilThread.m4424a(throwable);
        }
    }

    /* renamed from: a */
    public static void m4430a(String level, String tag, String format) {
        if (sLogUtil != null) {
            sLogUtil.m4436b(level, tag, format);
        }
    }

    /* renamed from: a */
    public static void m4433a(Throwable t) {
        if (CommonParams.jp <= 5) {
            StringBuilder err = new StringBuilder(256);
            err.append("Got exception: ");
            err.append(t.toString());
            err.append("\n");
            System.out.println(err.toString());
            t.printStackTrace(System.out);
        }
    }

    /* renamed from: a */
    public static void m4431a(String tag, String format, Object... args) {
        LogUtil.m4427a(2, tag, format, args);
        if (sLogUtil != null) {
            sLogUtil.m4436b("V", tag, format);
        }
    }

    /* renamed from: a */
    public static void m4429a(String tag, String format) {
        if (CommonParams.jp <= 2) {
            Log.v(Tag + tag, format);
        }
        if (sLogUtil != null) {
            sLogUtil.m4436b("V", tag, format);
        }
    }

    /* renamed from: b */
    public static void m4437b(String tag, String format, Object... args) {
        LogUtil.m4427a(3, tag, format, args);
        if (sLogUtil != null) {
            sLogUtil.m4436b("D", tag, format);
        }
    }

    /* renamed from: b */
    public static void d(String tag, String format) {
        if (CommonParams.jp <= 3) {
            Log.d(Tag + tag, format);
        }
        if (sLogUtil != null) {
            sLogUtil.m4436b("D", tag, format);
        }
    }

    /* renamed from: c */
    public static void m4441c(String tag, String format, Object... args) {
        LogUtil.m4427a(4, tag, format, args);
        if (sLogUtil != null) {
            sLogUtil.m4436b("I", tag, format);
        }
    }

    /* renamed from: c */
    public static void m4440c(String tag, String format) {
        if (CommonParams.jp <= 4) {
            Log.i(Tag + tag, format);
        }
        if (sLogUtil != null) {
            sLogUtil.m4436b("I", tag, format);
        }
    }

    /* renamed from: d */
    public static void m4444d(String tag, String format, Object... args) {
        LogUtil.m4427a(5, tag, format, args);
        if (sLogUtil != null) {
            sLogUtil.m4436b("W", tag, format);
        }
    }

    /* renamed from: d */
    public static void m4443d(String tag, String format) {
        if (CommonParams.jp <= 5) {
            Log.w(Tag + tag, format);
        }
        if (sLogUtil != null) {
            sLogUtil.m4436b("W", tag, format);
        }
    }

    /* renamed from: a */
    public static void m4432a(String tag, Throwable throwable) {
        if (CommonParams.jp <= 6) {
            Log.w(Tag + tag, "CarLife Exception!", throwable);
        }
        if (sLogUtil != null) {
            sLogUtil.m4442c(throwable);
        }
    }

    /* renamed from: e */
    public static void e(String tag, String format, Object... args) {
        LogUtil.m4427a(6, tag, format, args);
        if (sLogUtil != null) {
            sLogUtil.m4436b("E", tag, format);
        }
    }

    /* renamed from: e */
    public static void m4445e(String tag, String format) {
        if (CommonParams.jp <= 6) {
            Log.e(Tag + tag, format);
        }
        if (sLogUtil != null) {
            sLogUtil.m4436b("E", tag, format);
        }
    }

    /* renamed from: b */
    public static void m4439b(Throwable throwable) {
        if (CommonParams.jp <= 6) {
            Log.e(Tag, "CarLife Crash!", throwable);
        }
        if (sLogUtil != null) {
            sLogUtil.m4442c(throwable);
        }
    }

    /* renamed from: b */
    public static void m4438b(String tag, Throwable throwable) {
        if (CommonParams.jp <= 6) {
            Log.e(Tag + tag, "CarLife Exception!", throwable);
        }
        if (sLogUtil != null) {
            sLogUtil.m4442c(throwable);
        }
    }

    /* renamed from: a */
    private static void m4427a(int level, String tag, String format, Object... args) {
        if (CommonParams.jp <= level && tag != null && format != null) {
            Log.println(level, Tag + tag, String.format(format, args));
        }
    }

    /* renamed from: f */
    public static void m4447f(String tag, String format) {
        if (tag != null && format != null) {
            try {
                int len = format.length();
                int max = 120;
                if (len <= 120) {
                    max = len;
                }
                String tformat = format.substring(0, max);
                String date = DATE_FORMAT.format(new Date());
                String log = "[" + date + "]" + tformat + "\r\n";
                if (date != null && date.length() >= 10) {
                    FileWriter fw = new FileWriter(CommonParams.jm + "/" + date.substring(0, 10) + LOG_FILE, true);
                    fw.write(log);
                    fw.flush();
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m4428a(String tagName) {
        if (CarlifeUtil.m4382t() && !TextUtils.isEmpty(tagName)) {
            sLogMap.put(tagName, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* renamed from: b */
    public static void m4434b(String tagName) {
        if (CarlifeUtil.m4382t() && !TextUtils.isEmpty(tagName) && sLogMap.containsKey(tagName)) {
            Log.d(Tag + tagName, "QA time is:" + (System.currentTimeMillis() - ((Long) sLogMap.get(tagName)).longValue()) + "ms");
            sLogMap.remove(tagName);
        }
    }
}