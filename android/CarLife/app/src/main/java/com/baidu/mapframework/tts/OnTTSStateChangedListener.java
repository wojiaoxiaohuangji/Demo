package com.baidu.mapframework.tts;

public abstract interface OnTTSStateChangedListener
{
  public abstract void onPlayEnd();
  
  public abstract void onPlayError(int paramInt, String paramString);
  
  public abstract void onPlayStart();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/tts/OnTTSStateChangedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */