package com.baidu.baidunavis.model;

public class NavGeoPoint
{
  public static final int INVALID_VALUE = Integer.MIN_VALUE;
  private int mLatitudeE6;
  private int mLongitudeE6;
  
  public NavGeoPoint()
  {
    this.mLongitudeE6 = Integer.MIN_VALUE;
    this.mLatitudeE6 = Integer.MIN_VALUE;
  }
  
  public NavGeoPoint(int paramInt1, int paramInt2)
  {
    this.mLongitudeE6 = paramInt1;
    this.mLatitudeE6 = paramInt2;
  }
  
  public NavGeoPoint(NavGeoPoint paramNavGeoPoint)
  {
    this.mLongitudeE6 = paramNavGeoPoint.mLongitudeE6;
    this.mLatitudeE6 = paramNavGeoPoint.mLatitudeE6;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (paramObject.getClass() != getClass()) {
      return false;
    }
    if ((this.mLatitudeE6 == ((NavGeoPoint)paramObject).mLatitudeE6) && (this.mLongitudeE6 == ((NavGeoPoint)paramObject).mLongitudeE6)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int getLatitudeE6()
  {
    return this.mLatitudeE6;
  }
  
  public int getLongitudeE6()
  {
    return this.mLongitudeE6;
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public boolean isValid()
  {
    return (this.mLongitudeE6 != Integer.MIN_VALUE) && (this.mLatitudeE6 != Integer.MIN_VALUE);
  }
  
  public void setLatitudeE6(int paramInt)
  {
    this.mLatitudeE6 = paramInt;
  }
  
  public void setLongitudeE6(int paramInt)
  {
    this.mLongitudeE6 = paramInt;
  }
  
  public String toString()
  {
    return "GeoPoint(" + this.mLongitudeE6 + "," + this.mLatitudeE6 + ") ";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/model/NavGeoPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */