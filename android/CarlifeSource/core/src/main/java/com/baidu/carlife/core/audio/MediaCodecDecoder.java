package com.baidu.carlife.core.audio;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;

import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: MediaCodecDecoder */
/* renamed from: com.baidu.carlife.core.audio.l */
public class MediaCodecDecoder implements AudioDecoderInterface {
    /* renamed from: a */
    private static final String Tag = (AudioUtil.AUDIO + MediaCodecDecoder.class.getSimpleName());
    /* renamed from: b */
    private static final int f3083b = 1;
    /* renamed from: c */
    private static final int f3084c = 0;
    /* renamed from: d */
    private static final int f3085d = -1;
    /* renamed from: e */
    private static final int f3086e = -2;
    /* renamed from: f */
    private static final int f3087f = -3;
    /* renamed from: g */
    private static final int f3088g = -4;
    /* renamed from: h */
    private static final int f3089h = -10;
    /* renamed from: i */
    private static final int f3090i = -11;
    /* renamed from: j */
    private static final int f3091j = -12;
    /* renamed from: k */
    private static final int f3092k = 1000;
    /* renamed from: l */
    private static final int f3093l = 10;
    /* renamed from: m */
    private MediaCodec mMediaCodec;
    /* renamed from: n */
    private MediaExtractor mMediaExtractor;
    /* renamed from: o */
    private MediaFormat mMediaFormat;
    /* renamed from: p */
    private BufferInfo mBufferInfo;
    /* renamed from: q */
    private boolean mSawOutputEOS = false;
    /* renamed from: r */
    private boolean mSawInputEOS = false;
    /* renamed from: s */
    private ByteBuffer[] mCodecInputBuffers;
    /* renamed from: t */
    private ByteBuffer[] mCodecOutputBuffers;
    /* renamed from: u */
    private int mSampleRate = -1;
    /* renamed from: v */
    private int mChannelConfig = -1;
    /* renamed from: w */
    private int mReSampleRate = -1;
    /* renamed from: x */
    private byte[] mChunk;
    /* renamed from: y */
    private String f3106y;

    MediaCodecDecoder() {
        setChunk(new byte[AudioUtil.M_CHUNK_LENGTH]);
    }

    /* renamed from: d */
    public static int m3991d() {
        return 1000;
    }

    /* renamed from: a */
    public synchronized int decodeAudio(String url) {
        int i = -1;
        synchronized (this) {
            try {
                if (this.mMediaExtractor != null) {
                    this.mMediaExtractor.release();
                }
                m3993o();
                this.mMediaExtractor = new MediaExtractor();
                LogUtil.d(Tag, "the decode file path is " + url);
                this.mMediaExtractor.setDataSource(url);
                this.mMediaFormat = this.mMediaExtractor.getTrackFormat(0);
                this.f3106y = getMediaFormat().getString("mime");
                LogUtil.d(Tag, "mMine= " + this.f3106y);
                if (m3990b(this.f3106y)) {
                    setChannelConfig(getMediaFormat().getInteger("channel-count"));
                    LogUtil.d(Tag, "mChannelConfig= " + getChannelConfig());
                    if (Build.MODEL.equals("GT-N7100") && getChannelConfig() == 1) {
                        setChannelConfig(2);
                    }
                    setSampleRate(getMediaFormat().getInteger("sample-rate"));
                    LogUtil.d(Tag, "samplerate = " + getSampleRate());
                    if (getSampleRate() < 4000 || getSampleRate() > 48000) {
                        LogUtil.d(Tag, "4000>sample rate || sample rate>48000: " + getSampleRate());
                        m3995a(404);
                    } else {
                        this.mReSampleRate = 16;
                        this.mMediaCodec = MediaCodec.createDecoderByType(this.f3106y);
                        setSawOutputEOS(false);
                        setSawInputEOS(false);
                        getMediaCodec().configure(getMediaFormat(), null, null, 0);
                        getMediaCodec().start();
                        if (VERSION.SDK_INT < 21) {
                            setCodecInputBuffers(getMediaCodec().getInputBuffers());
                            setCodecOutputBuffers(getMediaCodec().getOutputBuffers());
                        }
                        this.mBufferInfo = new BufferInfo();
                        this.mMediaExtractor.selectTrack(0);
                        int retVal = m3992n();
                        if (retVal >= 0) {
                            LogUtil.d(Tag, "Reconfigure sample rate in success,retVal = " + retVal);
                        } else {
                            LogUtil.d(Tag, "Reconfigure sample rate in failure,retVal = " + retVal);
                        }
                        i = 0;
                    }
                } else {
                    m3995a(404);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
                LogUtil.d(Tag, "IOException happen!-decoder");
                m3995a(404);
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                LogUtil.d(Tag, "IllegalStateException happen!-decoder");
                m3995a(404);
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
                LogUtil.d(Tag, "IllegalArgumentException happen!-decoder");
                m3995a(404);
            } catch (CryptoException e6) {
                e6.printStackTrace();
                LogUtil.d(Tag, "MediaCodec.CryptoException happen!-decoder");
                m3995a(404);
            } catch (NullPointerException e7) {
                e7.printStackTrace();
                LogUtil.d(Tag, "NullPointerException happen!-decoder");
                m3995a(404);
            }
        }
        return i;
    }

    /* renamed from: a */
    public int initialization(String url, ArrayList arrayList) {
        return 0;
    }

    /* renamed from: a */
    public int getSampleRate() {
        return this.mSampleRate;
    }

    /* renamed from: b */
    public int getChannelConfig() {
        return this.mChannelConfig;
    }

    /* renamed from: c */
    public int getReSampleRate() {
        return this.mReSampleRate;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: n */
    private int m3992n() {
        /*
        r19 = this;
        r9 = 0;
        r14 = 0;
        r2 = r19.getMediaCodec();
        if (r2 != 0) goto L_0x01ba;
    L_0x0008:
        r2 = -1;
    L_0x0009:
        return r2;
    L_0x000a:
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = 21;
        if (r2 >= r4) goto L_0x0022;
    L_0x0010:
        r2 = -3;
        r0 = r17;
        if (r0 != r2) goto L_0x0022;
    L_0x0015:
        r2 = r19.getMediaCodec();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = r2.getOutputBuffers();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r0 = r19;
        r0.setCodecOutputBuffers (r2);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
    L_0x0022:
        r10 = r9;
    L_0x0023:
        r9 = r10 + 1;
        r2 = 10;
        if (r10 >= r2) goto L_0x010e;
    L_0x0029:
        r2 = r19.getMediaCodec();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = com.baidu.carlife.core.audio.MediaCodecDecoder.m3991d();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = (long) r4;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r3 = r2.dequeueInputBuffer(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = Tag;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4.<init>();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "inputBuffIndex = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.append(r3);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.toString();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        com.baidu.carlife.core.LogUtil.d(r2, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        if (r3 < 0) goto L_0x0126;
    L_0x0051:
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = 21;
        if (r2 < r4) goto L_0x0115;
    L_0x0057:
        r2 = r19.getMediaCodec();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r15 = r2.getInputBuffer(r3);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
    L_0x005f:
        r0 = r19;
        r2 = r0.mMediaExtractor;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = 0;
        r5 = r2.readSampleData(r15, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = Tag;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4.<init>();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "inputBuffIndex = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.append(r3);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "sampleSize = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.append(r5);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.toString();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        com.baidu.carlife.core.LogUtil.d(r2, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r16 = 0;
        if (r5 >= 0) goto L_0x011d;
    L_0x0090:
        r16 = 1;
        r5 = 0;
    L_0x0093:
        r2 = r19.getMediaCodec();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = 0;
        r6 = 0;
        if (r16 == 0) goto L_0x0121;
    L_0x009c:
        r8 = 4;
    L_0x009d:
        r2.queueInputBuffer(r3, r4, r5, r6, r8);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        if (r16 != 0) goto L_0x0124;
    L_0x00a2:
        r0 = r19;
        r2 = r0.mMediaExtractor;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2.advance();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
    L_0x00a9:
        r2 = r19.getMediaCodec();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r19.getBufferInfo();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = com.baidu.carlife.core.audio.MediaCodecDecoder.m3991d();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = (long) r6;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r17 = r2.dequeueOutputBuffer(r4, r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = Tag;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4.<init>();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "outputBuffIndex = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r0 = r17;
        r4 = r4.append(r0);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.toString();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        com.baidu.carlife.core.LogUtil.d(r2, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        if (r17 < 0) goto L_0x012b;
    L_0x00d7:
        r2 = r19.getMediaCodec();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r0 = r17;
        r18 = r2.getOutputFormat(r0);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = Tag;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4.<init>();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "output format no change, sample rate = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "sample-rate";
        r0 = r18;
        r6 = r0.getInteger(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.toString();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        com.baidu.carlife.core.LogUtil.d(r2, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = r19.getMediaCodec();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = 0;
        r0 = r17;
        r2.releaseOutputBuffer(r0, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r14 = 0;
    L_0x010e:
        r2 = 10;
        if (r9 < r2) goto L_0x01b7;
    L_0x0112:
        r2 = -4;
        goto L_0x0009;
    L_0x0115:
        r2 = r19.getCodecInputBuffers();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r15 = r2[r3];	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        goto L_0x005f;
    L_0x011d:
        r16 = 0;
        goto L_0x0093;
    L_0x0121:
        r8 = 0;
        goto L_0x009d;
    L_0x0124:
        r14 = -2;
        goto L_0x010e;
    L_0x0126:
        r2 = -1;
        if (r3 == r2) goto L_0x00a9;
    L_0x0129:
        r14 = -3;
        goto L_0x010e;
    L_0x012b:
        r2 = -2;
        r0 = r17;
        if (r0 != r2) goto L_0x000a;
    L_0x0130:
        r2 = r19.getMediaCodec();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r18 = r2.getOutputFormat();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = "sample-rate";
        r0 = r18;
        r2 = r0.getInteger(r2);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r0 = r19;
        r0.setSampleRate(r2);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = "channel-count";
        r0 = r18;
        r2 = r0.getInteger(r2);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r0 = r19;
        r0.setChannelConfig(r2);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = Tag;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4.<init>();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = "output format changed, sample rate = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = r19.getSampleRate();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = ",channel count = ";
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r6 = r19.getChannelConfig();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.append(r6);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r4 = r4.toString();	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        com.baidu.carlife.core.LogUtil.d(r2, r4);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r2 = 425; // 0x1a9 float:5.96E-43 double:2.1E-321;
        com.baidu.carlife.core.MsgHandlerCenter.dispatchMessage(r2);	 Catch:{ IllegalStateException -> 0x0187, IllegalArgumentException -> 0x0197, CryptoException -> 0x01a7 }
        r14 = 1;
        goto L_0x010e;
    L_0x0187:
        r11 = move-exception;
        r11.printStackTrace();
        r2 = Tag;
        r4 = "IllegalStateException happen!-getDecodedAudioData";
        com.baidu.carlife.core.LogUtil.d(r2, r4);
        r14 = -10;
        goto L_0x010e;
    L_0x0197:
        r12 = move-exception;
        r12.printStackTrace();
        r2 = Tag;
        r4 = "IllegalArgumentException happen!-getDecodedAudioData";
        com.baidu.carlife.core.LogUtil.d(r2, r4);
        r14 = -11;
        goto L_0x010e;
    L_0x01a7:
        r13 = move-exception;
        r13.printStackTrace();
        r2 = Tag;
        r4 = "MediaCodec.CryptoException happen!-getDecodedAudioData";
        com.baidu.carlife.core.LogUtil.d(r2, r4);
        r14 = -12;
        goto L_0x010e;
    L_0x01b7:
        r2 = r14;
        goto L_0x0009;
    L_0x01ba:
        r10 = r9;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.core.audio.l.n():int");
    }

    /* renamed from: a */
    public synchronized int changeOutput(Pair p, int pos) {
        int i;
        if (getMediaCodec() == null || this.mMediaExtractor == null) {
            i = -1;
        } else {
            i = 0;
            p.setData(getChunk());
            p.setSize(0);
            try {
                int inputBufIndex = getMediaCodec().dequeueInputBuffer((long) MediaCodecDecoder.m3991d());
                if (inputBufIndex >= 0 && !getSawInputEOS()) {
                    ByteBuffer dstBuf;
                    if (VERSION.SDK_INT >= 21) {
                        dstBuf = getMediaCodec().getInputBuffer(inputBufIndex);
                    } else {
                        dstBuf = getCodecInputBuffers()[inputBufIndex];
                    }
                    int sampleSize = this.mMediaExtractor.readSampleData(dstBuf, 0);
                    if (sampleSize < 0) {
                        setSawInputEOS(true);
                        sampleSize = 0;
                    } else {
                        long presentationTimeUs = this.mMediaExtractor.getSampleTime();
                        setSawInputEOS(false);
                    }
                    getMediaCodec().queueInputBuffer(inputBufIndex, 0, sampleSize, 0, getSawInputEOS() ? 4 : 0);
                    if (getSawInputEOS()) {
                        m3995a(417);
                    } else {
                        this.mMediaExtractor.advance();
                    }
                }
                int res = getMediaCodec().dequeueOutputBuffer(getBufferInfo(), (long) MediaCodecDecoder.m3991d());
                if (res >= 0) {
                    ByteBuffer buf;
                    int outputBufIndex = res;
                    if (VERSION.SDK_INT >= 21) {
                        buf = getMediaCodec().getOutputBuffer(outputBufIndex);
                    } else {
                        buf = getCodecOutputBuffers()[outputBufIndex];
                    }
                    int chunkLen = getBufferInfo().size;
                    if (getChunk().length < chunkLen + pos) {
                        setChunk(new byte[(chunkLen + pos)]);
                        p.setData(getChunk());
                    }
                    buf.get(getChunk(), pos, chunkLen);
                    buf.clear();
                    if (chunkLen > 0) {
                        p.setSize(chunkLen);
                        i = chunkLen;
                    }
                    getMediaCodec().releaseOutputBuffer(outputBufIndex, false);
                    if ((getBufferInfo().flags & 4) != 0) {
                        setSawOutputEOS(true);
                    } else {
                        setSawOutputEOS(false);
                    }
                } else if (VERSION.SDK_INT < 21) {
                    if (res == -3) {
                        setCodecOutputBuffers(getMediaCodec().getOutputBuffers());
                        LogUtil.d(Tag, "res = MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED");
                    }
                } else if (res == -2) {
                    int newSamplerate = getMediaCodec().getOutputFormat().getInteger("sample-rate");
                    LogUtil.d(Tag, "res = MediaCodec.INFO_OUTPUT_FORMAT_CHANGED");
                }
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                LogUtil.d(Tag, "IllegalStateException happen!-getDecodedAudioData");
                m3995a(404);
                i = -1;
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
                LogUtil.d(Tag, "IllegalArgumentException happen!-getDecodedAudioData");
                m3995a(404);
                i = -1;
            } catch (CryptoException e6) {
                e6.printStackTrace();
                LogUtil.d(Tag, "MediaCodec.CryptoException happen!-getDecodedAudioData");
                m3995a(404);
                i = -1;
            }
        }
        return i;
    }

    /* renamed from: a */
    protected int m3995a(int type) {
        MsgHandlerCenter.dispatchMessage(type);
        if (type == 404) {
            m3993o();
        }
        return -1;
    }

    /* renamed from: o */
    private void m3993o() {
        if (getMediaCodec() != null) {
            try {
                getMediaCodec().flush();
                getMediaCodec().stop();
            } catch (IllegalStateException e1) {
                e1.printStackTrace();
            } finally {
                getMediaCodec().release();
                this.mMediaCodec = null;
            }
        }
    }

    /* renamed from: b */
    private boolean m3990b(String mimeType) {
        int numCodecs = MediaCodecList.getCodecCount();
        for (int i = 0; i < numCodecs; i++) {
            MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(i);
            LogUtil.d(Tag, "codecInfo = " + codecInfo.getName());
            if (!codecInfo.isEncoder()) {
                String[] types = codecInfo.getSupportedTypes();
                for (int j = 0; j < types.length; j++) {
                    LogUtil.d(Tag, "support type = " + types[j]);
                    if (types[j].equalsIgnoreCase(mimeType)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* renamed from: e */
    public MediaCodec getMediaCodec() {
        return this.mMediaCodec;
    }

    /* renamed from: f */
    public MediaFormat getMediaFormat() {
        return this.mMediaFormat;
    }

    /* renamed from: g */
    public BufferInfo getBufferInfo() {
        return this.mBufferInfo;
    }

    /* renamed from: h */
    public boolean getSawOutputEOS() {
        return this.mSawOutputEOS;
    }

    /* renamed from: i */
    public boolean getSawInputEOS() {
        return this.mSawInputEOS;
    }

    /* renamed from: j */
    public ByteBuffer[] getCodecInputBuffers() {
        return this.mCodecInputBuffers;
    }

    /* renamed from: k */
    public ByteBuffer[] getCodecOutputBuffers() {
        return this.mCodecOutputBuffers;
    }

    /* renamed from: m */
    public byte[] getChunk() {
        return this.mChunk;
    }

    /* renamed from: a */
    public void setSawOutputEOS(boolean sawOutputEOS) {
        this.mSawOutputEOS = sawOutputEOS;
    }

    /* renamed from: b */
    public void setSawInputEOS(boolean sawInputEOS) {
        this.mSawInputEOS = sawInputEOS;
    }

    /* renamed from: a */
    public void setCodecInputBuffers(ByteBuffer[] codecInputBuffers) {
        this.mCodecInputBuffers = codecInputBuffers;
    }

    /* renamed from: b */
    public void setCodecOutputBuffers(ByteBuffer[] codecOutputBuffers) {
        this.mCodecOutputBuffers = codecOutputBuffers;
    }

    /* renamed from: b */
    public void setSampleRate(int mSampleRate) {
        this.mSampleRate = mSampleRate;
    }

    /* renamed from: c */
    public void setChannelConfig(int mChannelConfig) {
        this.mChannelConfig = mChannelConfig;
    }

    /* renamed from: a */
    public void setChunk(byte[] mChunk) {
        this.mChunk = mChunk;
    }
}