package com.baidu.platform.comapi.search;

import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class PoiBKGResult
  implements ResultBase
{
  public ArrayList<PoiBKGBlock> mBlockList = new ArrayList();
  public int mCount = 0;
  public int mError = 0;
  public String mKeyWord = null;
  public int mResultType = -1;
  private int requestId;
  
  public int getRequestId()
  {
    return this.requestId;
  }
  
  public void setRequestId(int paramInt)
  {
    this.requestId = paramInt;
  }
  
  public class PoiBKGBlock
  {
    public int mIndexX = 0;
    public int mIndexY = 0;
    public ArrayList<PoiBKGItem> mItemList = new ArrayList();
    public int mLevel = 0;
    
    public PoiBKGBlock() {}
    
    public class PoiBKGItem
    {
      public String indoor_pano = null;
      public String mAddr = null;
      public Point mLocation = null;
      public String mName = null;
      public String mTel = null;
      public String mUid = null;
      public int pano = 0;
      public HashMap<String, Object> placeParam = new HashMap();
      
      public PoiBKGItem() {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/PoiBKGResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */