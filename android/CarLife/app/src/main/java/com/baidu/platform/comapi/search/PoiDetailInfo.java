package com.baidu.platform.comapi.search;

import android.text.TextUtils;
import com.baidu.platform.comapi.basestruct.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PoiDetailInfo
  implements Serializable
{
  public String addr;
  public String buildingId;
  public CaterQueueInfo caterQueueInfo;
  public int cityId;
  private DeepDetail detailInfo;
  public long distance;
  public String floorId;
  public String fromSource = "";
  public Point geo;
  public HeadIcon headIcon;
  public HeatMap heatMap;
  public int iconId;
  public int indoorOverLooking;
  public String indoor_pano;
  public String isScopeRouteCommand;
  public int ismodified;
  public String ldata;
  private ArrayList<BusLine> mArrayOtherStations;
  private ArrayList<BusLine> mArraybusLines;
  public String mPhotoList = "";
  public int mResultType;
  public String name;
  public String nearby;
  public String newCatelogId;
  public int offline;
  public int pano;
  public String poi_type_text;
  public String regionType;
  public int rtbusNu;
  public int rtbusUpdateTime;
  public String serviceTag;
  public String stationNum;
  public String stdTag = "";
  public String streetId;
  public String tel;
  public int type;
  public String uid;
  public int viewType;
  public String zip;
  
  public ArrayList<BusLine> getAllBusLines()
  {
    if ((this.mArraybusLines != null) && (this.mArraybusLines.size() > 0)) {
      return this.mArraybusLines;
    }
    return null;
  }
  
  public ArrayList<BusLine> getArrayOtherStations()
  {
    if ((this.mArrayOtherStations != null) && (this.mArrayOtherStations.size() > 0)) {
      return this.mArrayOtherStations;
    }
    return null;
  }
  
  public DeepDetail getDeepDetail()
  {
    if (this.detailInfo != null) {
      return this.detailInfo;
    }
    return null;
  }
  
  public void setArrayBuslines(ArrayList<BusLine> paramArrayList)
  {
    this.mArraybusLines = paramArrayList;
  }
  
  public void setArrayOtherStations(ArrayList<BusLine> paramArrayList)
  {
    this.mArrayOtherStations = paramArrayList;
  }
  
  public void setDeepDetail(DeepDetail paramDeepDetail)
  {
    this.detailInfo = paramDeepDetail;
  }
  
  public class ArroundInfos
    implements Serializable
  {
    public String bsInfo;
    public String exitName;
    public String exitRound;
    
    public ArroundInfos() {}
  }
  
  public class BusLine
    implements Serializable
  {
    public String addr;
    public int iconId;
    public String name;
    public String nextstation;
    public String otherStationAddr = null;
    public int otherStationIconid;
    public String otherStationUid = null;
    public int pairIconId;
    public String pairName;
    public String pairNextstation;
    public String pairUid;
    public String rtbusInfo = null;
    public String rtbusPairInfo = null;
    public String sonUid;
    public String uid;
    
    public BusLine() {}
    
    public boolean hasPairValidRealTimeInfo()
    {
      return !TextUtils.isEmpty(this.rtbusPairInfo);
    }
    
    public boolean hasValidRealTimeInfo()
    {
      return !TextUtils.isEmpty(this.rtbusInfo);
    }
  }
  
  public class CaterQueueInfo
  {
    public boolean isOk;
    public String thirdFrom;
    public String thirdId;
    
    public CaterQueueInfo() {}
  }
  
  public class DeepDetail
    implements Serializable
  {
    public ArrayList<PoiDetailInfo.ArroundInfos> arroundInfos;
    public ArrayList<PoiDetailInfo.DetailInfo> detailInfos;
    public ArrayList<PoiDetailInfo.DetailInfo> housearos;
    public ArrayList<PoiDetailInfo.Lines> lines;
    public String[] picLinks;
    public HashMap<String, Object> placeParam = new HashMap();
    public String price;
    public ArrayList<PoiDetailInfo.DetailInfo> titleLinks;
    public int type;
    
    public DeepDetail() {}
  }
  
  public class DetailInfo
    implements Serializable
  {
    public String title;
    public String value;
    
    public DetailInfo() {}
  }
  
  public static class HeadIcon
  {
    public static final int TYPE_BRAND = 1;
    public static final int TYPE_COMMON = 3;
    public static final int TYPE_IMAGE = 4;
    public static final int TYPE_INDUSTRY = 2;
    public static final int TYPE_INTER = 5;
    public static final int TYPE_STREET = 6;
    public String links;
    public String pid;
    public int type;
    public String url;
  }
  
  public class HeatMap
    implements Serializable
  {
    public ArrayList<Integer> pointDiffs;
    public String rankStr;
    public int type;
    
    public HeatMap() {}
  }
  
  public class Lines
    implements Serializable
  {
    public String abb;
    public String clr;
    public String firstTime;
    public String lastTime;
    public String name;
    public String terminal;
    public String uid;
    
    public Lines() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/PoiDetailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */