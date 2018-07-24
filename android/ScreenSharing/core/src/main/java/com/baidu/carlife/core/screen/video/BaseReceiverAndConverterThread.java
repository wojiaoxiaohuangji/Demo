package com.baidu.carlife.core.screen.video;

import android.graphics.Bitmap;
import android.os.Build;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.Locale;

/* compiled from: BaseReceiverAndConverterThread */
/* renamed from: com.baidu.carlife.core.screen.video.a */
public abstract class BaseReceiverAndConverterThread extends Thread {
    /* renamed from: d */
    protected static byte[] f3831d = null;
    /* renamed from: e */
    protected static ByteBuffer f3832e = null;
    /* renamed from: f */
    protected static Bitmap f3833f = null;
    /* renamed from: h */
    private static final String f3834h = "BaseReceiverAndConverterThread";
    /* renamed from: a */
    protected boolean f3835a = true;
    /* renamed from: b */
    protected DataInputStream f3836b;
    /* renamed from: c */
    protected DataOutputStream f3837c;
    /* renamed from: g */
    protected ByteArrayOutputStream f3838g = new ByteArrayOutputStream();

    /* renamed from: a */
    public abstract void mo1523a();

    /* renamed from: a */
    public abstract void mo1524a(int i);

    /* renamed from: b */
    protected void m4792b() {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        Exception e3;
        File file = new File("/data/local/tmp/bdscdata");
        if (file.exists()) {
            long lastModify = file.lastModified();
            long deltaTime = System.currentTimeMillis() - lastModify;
            if (lastModify <= 0 || deltaTime <= BNOffScreenParams.MIN_ENTER_INTERVAL) {
                FileInputStream fileInputStream = null;
                FileOutputStream out = null;
                byte[] buffer = new byte[10];
                try {
                    FileInputStream in = new FileInputStream(file);
                    try {
                        StringBuffer versionStr = new StringBuffer();
                        while (true) {
                            int index = in.read(buffer);
                            if (index == -1) {
                                break;
                            }
                            versionStr.append(new String(buffer, 0, index));
                        }
                        String[] verArr = versionStr.toString().split("\\.");
                        if (((verArr.length > 2 ? 1 : 0) & (verArr != null ? 1 : 0)) != 0 && Integer.parseInt(verArr[0]) + Integer.parseInt(verArr[1]) >= 2) {
                            if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("xiaomi")) {
                                this.f3837c.write(206);
                            } else {
                                int layerZ = 18;
                                try {
                                    Class<?> pwmClass = Class.forName("com.android.internal.policy.impl.PhoneWindowManager");
                                    Constructor<?> c = pwmClass.getConstructor(new Class[0]);
                                    c.setAccessible(true);
                                    layerZ = ((Integer) pwmClass.getDeclaredMethod("windowTypeToLayerLw", new Class[]{Integer.TYPE}).invoke(c.newInstance(new Object[0]), new Object[]{Integer.valueOf(2006)})).intValue();
                                } catch (ClassNotFoundException e4) {
                                    e4.printStackTrace();
                                } catch (NoSuchMethodException e5) {
                                    e5.printStackTrace();
                                } catch (InstantiationException e6) {
                                    e6.printStackTrace();
                                } catch (IllegalAccessException e7) {
                                    e7.printStackTrace();
                                } catch (IllegalArgumentException e8) {
                                    e8.printStackTrace();
                                } catch (InvocationTargetException e9) {
                                    e9.printStackTrace();
                                }
                                this.f3837c.write(layerZ + 200);
                            }
                            MsgHandlerCenter.m4461b((int) CommonParams.hx);
                        }
                        String wStr = "";
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(wStr.getBytes());
                            if (in != null) {
                                try {
                                    in.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e102) {
                                    e102.printStackTrace();
                                }
                            }
                        } catch (FileNotFoundException e11) {
                            e2 = e11;
                            out = fileOutputStream;
                            fileInputStream = in;
                            try {
                                e2.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e1022) {
                                        e1022.printStackTrace();
                                    }
                                }
                                if (out == null) {
                                    try {
                                        out.close();
                                    } catch (IOException e10222) {
                                        e10222.printStackTrace();
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e102222) {
                                        e102222.printStackTrace();
                                    }
                                }
                                if (out != null) {
                                    try {
                                        out.close();
                                    } catch (IOException e1022222) {
                                        e1022222.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e12) {
                            e1022222 = e12;
                            out = fileOutputStream;
                            fileInputStream = in;
                            e1022222.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e10222222) {
                                    e10222222.printStackTrace();
                                }
                            }
                            if (out == null) {
                                try {
                                    out.close();
                                } catch (IOException e102222222) {
                                    e102222222.printStackTrace();
                                }
                            }
                        } catch (Exception e13) {
                            e3 = e13;
                            out = fileOutputStream;
                            fileInputStream = in;
                            LogUtil.m4445e(f3834h, e3.toString());
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e1022222222) {
                                    e1022222222.printStackTrace();
                                }
                            }
                            if (out == null) {
                                try {
                                    out.close();
                                } catch (IOException e10222222222) {
                                    e10222222222.printStackTrace();
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            out = fileOutputStream;
                            fileInputStream = in;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (out != null) {
                                out.close();
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e14) {
                        e2 = e14;
                        fileInputStream = in;
                        e2.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (out == null) {
                            out.close();
                        }
                    } catch (IOException e15) {
                        e10222222222 = e15;
                        fileInputStream = in;
                        e10222222222.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (out == null) {
                            out.close();
                        }
                    } catch (Exception e16) {
                        e3 = e16;
                        fileInputStream = in;
                        LogUtil.m4445e(f3834h, e3.toString());
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (out == null) {
                            out.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = in;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (out != null) {
                            out.close();
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e17) {
                    e2 = e17;
                    e2.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (out == null) {
                        out.close();
                    }
                } catch (IOException e18) {
                    e10222222222 = e18;
                    e10222222222.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (out == null) {
                        out.close();
                    }
                } catch (Exception e19) {
                    e3 = e19;
                    LogUtil.m4445e(f3834h, e3.toString());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (out == null) {
                        out.close();
                    }
                }
            }
        }
    }
}
