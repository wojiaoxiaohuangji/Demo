package com.baidu.carlife.p087l;

import android.content.Context;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.audio.C1163a;
import com.baidu.carlife.core.audio.C1173g;

/* compiled from: CarlifeCustomAudio */
/* renamed from: com.baidu.carlife.l.e */
public class C1668e {
    /* renamed from: a */
    private static final String f5156a = (C1163a.f3010n + C1668e.class.getSimpleName());
    /* renamed from: b */
    private static C1668e f5157b;
    /* renamed from: c */
    private C1173g f5158c = new C1173g();
    /* renamed from: d */
    private Context f5159d = C1157a.m3876a().getApplicationContext();

    private C1668e() {
    }

    /* renamed from: a */
    public static C1668e m6122a() {
        if (f5157b == null) {
            f5157b = new C1668e();
        }
        return f5157b;
    }

    /* renamed from: a */
    public boolean m6124a(String filePath) {
        return this.f5158c.m3938a(filePath);
    }

    /* renamed from: b */
    public byte[] m6125b() {
        return this.f5158c.m3939a();
    }

    /* renamed from: c */
    public void m6126c() {
        this.f5158c.m3940b();
    }

    /* renamed from: a */
    public void m6123a(byte[] pData) {
        this.f5158c.m3937a(pData);
    }
}