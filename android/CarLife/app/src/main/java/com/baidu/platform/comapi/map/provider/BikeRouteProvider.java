package com.baidu.platform.comapi.map.provider;

import com.baidu.entity.pb.WalkPlan;
import com.baidu.entity.pb.WalkPlan.Option;
import com.baidu.entity.pb.WalkPlan.Option.End;
import com.baidu.entity.pb.WalkPlan.Option.Start;
import com.baidu.entity.pb.WalkPlan.Routes;
import com.baidu.entity.pb.WalkPlan.Routes.Legs;
import com.baidu.entity.pb.WalkPlan.Routes.Legs.Steps;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.search.convert.PBConvertUtil;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.f;
import com.baidu.platform.comjni.tools.AppTools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class BikeRouteProvider
  implements RenderProvider
{
  public static final int ARR_MAXL = 22;
  public static final int ARR_MINL = 13;
  public static final int BD09MC = 1;
  public static final int END_NODE_STYLE = 357;
  public static final int FOOT_LINE_ARR_FOCUS_STYLE = 175;
  public static final int FOOT_LINE_ARR_NORMAL_STYLE = 171;
  public static final int FOOT_LINE_FOCUS_STYLE = 175;
  public static final int FOOT_LINE_NORMAL_STYLE = 171;
  public static final int GCJ02 = 0;
  public static final int MAXL = 12;
  public static final int MINL = 3;
  public static final int START_NODE_STYLE = 356;
  public static final int STEP_OFFSET = 8;
  public static final int STEP_STYLE = 37;
  private static final String TAG = BikeRouteProvider.class.getSimpleName();
  List<Integer> curMc = null;
  private JsonBuilder mJsonBuilder;
  private int mNodeCount;
  private int mSpathType = 0;
  private WalkPlan mWalkRoute;
  List<Integer> preMc = null;
  
  public BikeRouteProvider(WalkPlan paramWalkPlan)
  {
    this.mWalkRoute = paramWalkPlan;
    if ((paramWalkPlan != null) && (paramWalkPlan.hasOption()) && (paramWalkPlan.getOption().hasSpathType()))
    {
      this.mSpathType = paramWalkPlan.getOption().getSpathType();
      return;
    }
    this.mSpathType = 0;
  }
  
  private void addEndDashRoutes()
  {
    f.e("tag", "addEndDashRoutes");
    Object localObject = getWalkPlanEndPoint(this.mWalkRoute);
    int i;
    int j;
    if (localObject != null)
    {
      i = ((Point)localObject).getIntX();
      j = ((Point)localObject).getIntY();
      if ((i != 0) && (j != 0)) {
        break label39;
      }
    }
    label39:
    do
    {
      do
      {
        return;
        localObject = ComplexPt.createComplexPt(this.preMc);
      } while ((localObject == null) || (((ComplexPt)localObject).isEmpty()));
      localObject = (ArrayList)((ComplexPt)localObject).mGeoPt.get(((ComplexPt)localObject).mGeoPt.size() - 1);
    } while (AppTools.getDistanceByMc((Point)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1), new Point(i, j)) < 2.0D);
    localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(i));
    ((List)localObject).add(Integer.valueOf(j));
    ((List)localObject).add(Integer.valueOf(i));
    ((List)localObject).add(Integer.valueOf(j));
    ((List)localObject).add(Integer.valueOf(2));
    ((List)localObject).add(Integer.valueOf(i));
    ((List)localObject).add(Integer.valueOf(j));
    this.curMc = ((List)localObject);
    this.mJsonBuilder.object();
    this.mJsonBuilder.key("ty").value(2);
    this.mJsonBuilder.key("in").value(this.mNodeCount);
    this.mJsonBuilder.key("nst").value(208);
    this.mJsonBuilder.key("fst").value(208);
    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(ProviderUtils.connectPath(this.preMc, this.curMc)));
    this.mJsonBuilder.endObject();
  }
  
  private void addLineArrowStyle(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JsonBuilder localJsonBuilder = new JsonBuilder();
      localJsonBuilder.arrayValue();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("maxl", 22);
      localJSONObject.put("minl", 13);
      localJSONObject.put("fst", paramInt4);
      localJSONObject.put("nst", paramInt3);
      localJsonBuilder.objectValue(localJSONObject.toString());
      localJSONObject = new JSONObject();
      localJSONObject.put("maxl", 12);
      localJSONObject.put("minl", 3);
      localJSONObject.put("fst", paramInt2);
      localJSONObject.put("nst", paramInt1);
      localJsonBuilder.objectValue(localJSONObject.toString());
      localJsonBuilder.endArrayValue();
      this.mJsonBuilder.key("difflevel").objectValue(localJsonBuilder.getJson());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void addRouteEndNode()
  {
    if (this.mWalkRoute.getOption().getEndCount() < 1) {
      return;
    }
    WalkPlan.Option.End localEnd = this.mWalkRoute.getOption().getEnd(this.mWalkRoute.getOption().getEndCount() - 1);
    this.mJsonBuilder.object();
    JsonBuilder localJsonBuilder = this.mJsonBuilder.key("ud");
    if (localEnd.hasUid())
    {
      str = localEnd.getUid();
      localJsonBuilder.value(str);
      this.mJsonBuilder.key("ty").value(2);
      this.mJsonBuilder.key("nst").value(357);
      this.mJsonBuilder.key("fst").value(357);
      localJsonBuilder = this.mJsonBuilder.key("tx");
      if (!localEnd.hasWd()) {
        break label216;
      }
    }
    label216:
    for (String str = localEnd.getWd();; str = "终点")
    {
      localJsonBuilder.value(str);
      this.mJsonBuilder.key("in").value(getCurrentIndex());
      this.mJsonBuilder.key("align").value(2);
      this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(localEnd.getSptList()));
      this.mJsonBuilder.endObject();
      return;
      str = "";
      break;
    }
  }
  
  private void addRouteLegData(WalkPlan.Routes.Legs paramLegs)
  {
    if (this.mWalkRoute.getOption().getEndCount() < 1) {
      return;
    }
    this.mJsonBuilder.key("labelset").arrayValue();
    int i = 0;
    while (i < paramLegs.getStepsCount())
    {
      this.mJsonBuilder.object();
      List localList = paramLegs.getSteps(i).getSpathList();
      this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(localList));
      this.mJsonBuilder.key("tx").value(paramLegs.getSteps(i).getName());
      this.mJsonBuilder.endObject();
      i += 1;
    }
    this.mJsonBuilder.endArrayValue();
  }
  
  private void addRoutePaths(WalkPlan.Routes.Legs paramLegs)
  {
    addStartDashRoutes();
    int i = 0;
    if (i < paramLegs.getStepsCount())
    {
      List localList = ((WalkPlan.Routes.Legs.Steps)paramLegs.getStepsList().get(i)).getSpathList();
      ComplexPt localComplexPt;
      if (localList != null)
      {
        localComplexPt = null;
        if (this.mSpathType != 0) {
          break label168;
        }
        localComplexPt = ComplexPt.createComplexPt(localList).toComplexPtGCJ2MC();
      }
      for (;;)
      {
        this.curMc = localComplexPt.toIntArray();
        this.mJsonBuilder.object();
        this.mJsonBuilder.key("ty").value(2);
        this.mJsonBuilder.key("in").value(getCurrentIndex());
        addLineArrowStyle(171, 175, 171, 175);
        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(ProviderUtils.connectPath(this.preMc, this.curMc)));
        this.mJsonBuilder.endObject();
        this.preMc = this.curMc;
        i += 1;
        break;
        label168:
        if (this.mSpathType == 1) {
          localComplexPt = ComplexPt.createComplexPt(localList);
        }
      }
    }
    addEndDashRoutes();
  }
  
  private void addRouteStartNode()
  {
    WalkPlan.Option.Start localStart = this.mWalkRoute.getOption().getStart();
    this.mJsonBuilder.object();
    JsonBuilder localJsonBuilder = this.mJsonBuilder.key("ud");
    if (localStart.hasUid())
    {
      str = localStart.getUid();
      localJsonBuilder.value(str);
      this.mJsonBuilder.key("ty").value(1);
      this.mJsonBuilder.key("nst").value(356);
      this.mJsonBuilder.key("fst").value(356);
      localJsonBuilder = this.mJsonBuilder.key("tx");
      if (!localStart.hasWd()) {
        break label189;
      }
    }
    label189:
    for (String str = localStart.getWd();; str = "起点")
    {
      localJsonBuilder.value(str);
      this.mJsonBuilder.key("in").value(getCurrentIndex());
      this.mJsonBuilder.key("align").value(2);
      this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(localStart.getSptList()));
      this.mJsonBuilder.endObject();
      return;
      str = "";
      break;
    }
  }
  
  private void addStartDashRoutes()
  {
    Point localPoint = getWalkPlanStartPoint(this.mWalkRoute);
    int i;
    int j;
    if (localPoint != null)
    {
      i = localPoint.getIntX();
      j = localPoint.getIntY();
      if ((i != 0) && (j != 0)) {
        break label36;
      }
    }
    label36:
    do
    {
      return;
      localPoint = getFirstRouteLoc();
    } while ((localPoint == null) || (AppTools.getDistanceByMc(new Point(i, j), localPoint) < 2.0D));
    ArrayList localArrayList = new ArrayList();
    int k = localPoint.getIntX();
    int m = localPoint.getIntY();
    localArrayList.add(Integer.valueOf(i));
    localArrayList.add(Integer.valueOf(j));
    localArrayList.add(Integer.valueOf(i));
    localArrayList.add(Integer.valueOf(j));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(i));
    localArrayList.add(Integer.valueOf(j));
    localArrayList.add(Integer.valueOf(k - i));
    localArrayList.add(Integer.valueOf(m - j));
    this.mJsonBuilder.object();
    this.mJsonBuilder.key("ty").value(2);
    this.mJsonBuilder.key("in").value(this.mNodeCount);
    this.mJsonBuilder.key("nst").value(208);
    this.mJsonBuilder.key("fst").value(208);
    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(localArrayList));
    this.mJsonBuilder.endObject();
  }
  
  private int getCurrentIndex()
  {
    int i = this.mNodeCount;
    this.mNodeCount = (i + 1);
    return i;
  }
  
  private Point getFirstRouteLoc()
  {
    if ((this.mWalkRoute != null) && (this.mWalkRoute.getRoutesCount() > 0) && (this.mWalkRoute.getRoutes(0).getLegsCount() > 0) && (this.mWalkRoute.getRoutes(0).getLegs(0).getStepsCount() > 0))
    {
      WalkPlan.Routes.Legs.Steps localSteps = this.mWalkRoute.getRoutes(0).getLegs(0).getSteps(0);
      return new Point(((Integer)localSteps.getSpathList().get(5)).intValue(), ((Integer)localSteps.getSpathList().get(6)).intValue());
    }
    return null;
  }
  
  private WalkPlan.Routes.Legs mergeLegs()
  {
    WalkPlan.Routes.Legs localLegs = new WalkPlan.Routes.Legs();
    if (this.mWalkRoute.getRoutesCount() > 0)
    {
      Iterator localIterator = this.mWalkRoute.getRoutes(0).getLegsList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((WalkPlan.Routes.Legs)localIterator.next()).getStepsList();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localLegs.addSteps((WalkPlan.Routes.Legs.Steps)((Iterator)localObject).next());
          }
        }
      }
    }
    return localLegs;
  }
  
  private void resetTemporaryField()
  {
    this.mJsonBuilder = new JsonBuilder();
    this.mNodeCount = 0;
  }
  
  public String getProjectionPaths()
  {
    JsonBuilder localJsonBuilder = new JsonBuilder();
    if (this.mWalkRoute.getRoutesCount() <= 0) {}
    WalkPlan.Routes localRoutes;
    do
    {
      return null;
      localRoutes = this.mWalkRoute.getRoutes(0);
    } while (localRoutes == null);
    int i = 0;
    while (i < localRoutes.getLegsCount())
    {
      int j = 0;
      while (j < localRoutes.getLegs(i).getStepsCount())
      {
        localJsonBuilder.object();
        List localList = localRoutes.getLegs(i).getSteps(j).getSpathList();
        localJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(localList));
        localJsonBuilder.endObject();
        j += 1;
      }
      i += 1;
    }
    return localJsonBuilder.getJson();
  }
  
  public String getRenderData()
  {
    resetTemporaryField();
    try
    {
      WalkPlan.Routes.Legs localLegs = mergeLegs();
      this.mJsonBuilder.object().key("dataset").arrayValue();
      addRoutePaths(localLegs);
      addRouteStartNode();
      addRouteEndNode();
      this.mJsonBuilder.endArrayValue();
      addRouteLegData(localLegs);
      this.mJsonBuilder.endObject();
      f.e(TAG, "walk render json:" + this.mJsonBuilder.getJson());
      return this.mJsonBuilder.getJson();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public Point getWalkPlanEndPoint(WalkPlan paramWalkPlan)
  {
    Point localPoint2 = new Point(0.0D, 0.0D);
    Point localPoint1 = localPoint2;
    if (paramWalkPlan != null)
    {
      localPoint1 = localPoint2;
      if (paramWalkPlan.hasOption())
      {
        localPoint1 = localPoint2;
        if (paramWalkPlan.getOption().getEndCount() > 0)
        {
          localPoint1 = localPoint2;
          if (paramWalkPlan.getOption().getEnd(paramWalkPlan.getOption().getEndCount() - 1) != null) {
            localPoint1 = PBConvertUtil.decryptPointFromArray(paramWalkPlan.getOption().getEnd(paramWalkPlan.getOption().getEndCount() - 1).getSptList());
          }
        }
      }
    }
    return localPoint1;
  }
  
  public Point getWalkPlanStartPoint(WalkPlan paramWalkPlan)
  {
    Point localPoint2 = new Point(0.0D, 0.0D);
    Point localPoint1 = localPoint2;
    if (paramWalkPlan != null)
    {
      localPoint1 = localPoint2;
      if (paramWalkPlan.hasOption())
      {
        localPoint1 = localPoint2;
        if (paramWalkPlan.getOption().hasStart()) {
          localPoint1 = PBConvertUtil.decryptPointFromArray(paramWalkPlan.getOption().getStart().getSptList());
        }
      }
    }
    return localPoint1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/BikeRouteProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */