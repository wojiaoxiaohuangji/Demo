package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.radio.p080b.p103a.C2108a;
import com.baidu.carlife.radio.p080b.p103a.C2109c;
import java.util.Map;

/* compiled from: FeedbackAddRequest */
/* renamed from: com.baidu.carlife.radio.b.h */
public class C2118h extends C2108a {
    /* renamed from: a */
    public String mo1770a() {
        return C2109c.m7935i();
    }

    /* renamed from: a */
    public void mo1771a(int statusCode, String response) {
        LogUtil.m4440c("radio_request", "statusCode = " + statusCode + "; response=" + response);
    }

    /* renamed from: a */
    public void mo1773a(Map<String, String> map) {
    }

    /* renamed from: a */
    public void mo1772a(String url, String error) {
        LogUtil.m4445e("radio_request", "error = " + error);
    }
}