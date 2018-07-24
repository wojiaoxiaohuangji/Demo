package com.baidu.carlife.core.screen.presentation;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.OnSurfaceListener;
import com.baidu.carlife.core.screen.video.Recorder;

@TargetApi(17)
/* compiled from: AbsCarlifeFakePresentation */
/* renamed from: com.baidu.carlife.core.screen.presentation.a */
public class AbsCarlifeFakePresentation extends Presentation implements KeepClass {
    /* renamed from: a */
    public static String f3808a = "CarlifeFakePresentation";
    /* renamed from: b */
    protected OnSurfaceListener f3809b;
    /* renamed from: c */
    protected TextureView f3810c;
    /* renamed from: d */
    SurfaceTextureListener f3811d = new C12941(this);
    /* renamed from: e */
    private long f3812e = 0;
    /* renamed from: f */
    private Recorder f3813f;

    /* compiled from: AbsCarlifeFakePresentation */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a$1 */
    class C12941 implements SurfaceTextureListener {
        /* renamed from: a */
        final /* synthetic */ AbsCarlifeFakePresentation f3728a;

        C12941(AbsCarlifeFakePresentation this$0) {
            this.f3728a = this$0;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            if (CommonParams.jp <= 3) {
            }
            if (this.f3728a.f3813f.m4879j()) {
                synchronized (this.f3728a.f3813f.f3905f) {
                    this.f3728a.f3810c.getBitmap(this.f3728a.f3813f.f3905f);
                }
            }
            long sleepTime = ((long) Recorder.f3864e) - (System.currentTimeMillis() - this.f3728a.f3812e);
            this.f3728a.f3812e = System.currentTimeMillis();
            if (sleepTime > 0 && sleepTime < 500) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            LogUtil.d(AbsCarlifeFakePresentation.f3808a, "onSurfaceTextureSizeChanged, SurfaceTexture = " + surface.toString());
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            LogUtil.d(AbsCarlifeFakePresentation.f3808a, "onSurfaceTextureDestroyed, SurfaceTexture = " + surface.toString());
            return true;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            LogUtil.d(AbsCarlifeFakePresentation.f3808a, "onSurfaceTextureAvailable, SurfaceTexture = " + surface.toString());
            LogUtil.d(AbsCarlifeFakePresentation.f3808a, "width = " + width + ", height = " + height);
            Surface mSurface = new Surface(surface);
            CarlifeScreenUtil carlifeScreenUtil = CarlifeScreenUtil.m4331a();
            this.f3728a.m4748a(new DisplaySpec(carlifeScreenUtil.m4351h(), carlifeScreenUtil.m4352i(), carlifeScreenUtil.m4350g(), mSurface, 2));
        }
    }

    public AbsCarlifeFakePresentation(Context outerContext, Display display, OnSurfaceListener listener) {
        super(outerContext, display);
        this.f3809b = listener;
        m4746a();
        this.f3813f = Recorder.m4826b();
    }

    /* renamed from: a */
    private void m4746a() {
        Window window = getWindow();
        window.setType(CommonParams.fW);
        window.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        window.addFlags(16777216);
        window.addFlags(1024);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f3810c = new TextureView(getContext());
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.f3810c, new LayoutParams(-1, -1));
        LayoutParams flp = new LayoutParams(-1, -1);
        flp.gravity = 17;
        setContentView(frameLayout, flp);
        if (this.f3813f.m4879j()) {
            this.f3810c.setSurfaceTextureListener(this.f3811d);
            return;
        }
        CarlifeScreenUtil carlifeScreenUtil = CarlifeScreenUtil.m4331a();
        float scaleX = 0.0f;
        float scaleY = 0.0f;
        if (carlifeScreenUtil.m4351h() != 0) {
            scaleX = (((float) Recorder.m4828c()) * 1.0f) / ((float) carlifeScreenUtil.m4351h());
        }
        if (carlifeScreenUtil.m4352i() != 0) {
            scaleY = (((float) Recorder.m4830d()) * 1.0f) / ((float) carlifeScreenUtil.m4352i());
        }
        this.f3810c.setScaleX(scaleX);
        this.f3810c.setScaleY(scaleY);
        ViewGroup parentView = (ViewGroup) this.f3810c.getParent();
        ViewGroup.LayoutParams lp = parentView.getLayoutParams();
        lp.width = carlifeScreenUtil.m4351h();
        lp.height = carlifeScreenUtil.m4352i();
        parentView.setLayoutParams(lp);
        parentView.invalidate();
        this.f3810c.setSurfaceTextureListener(this.f3811d);
    }

    /* renamed from: a */
    protected void m4748a(DisplaySpec spec) {
        if (this.f3809b != null) {
            this.f3809b.mo1453a(spec);
        }
    }
}