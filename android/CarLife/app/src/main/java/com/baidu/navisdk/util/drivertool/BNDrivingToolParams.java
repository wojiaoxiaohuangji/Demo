package com.baidu.navisdk.util.drivertool;

import com.baidu.navisdk.util.http.HttpURLManager;
import java.text.SimpleDateFormat;

public class BNDrivingToolParams
{
  public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  public static final String DEFAULT_SPINNER_DATA = "-  -  -  -  -  -  -  -  -  -  -  -  -  -  -";
  public static final String DRIVING_TOOL_DIR = "DrivingTool";
  public static final String DRIVING_TOOL_INFO = "driving_tool_info";
  public static final String EMPTY_INDEX_VALUE = "null";
  public static final int HIGH_DEFINITION = 0;
  public static final String INDEX_FILE_SUFFIX = ".index";
  public static final String[] ISSUE_STATUS = { "-  -  -  -  -  -  -  -  -  -  -  -  -  -  -", "发现问题", "解决中", "延期", "非问题", "暂时无法解决", "已解决" };
  public static final String ISSUE_STORE_SUCCESS_MSG = "问题保存成功";
  public static final String[] ISSUE_TYPES;
  public static final String LOCAL_ISSUE_STORE = "issue-store.dat";
  public static final String LOCAL_RELIABLE_STORE = "pm.dat";
  public static final int LOW_DEFINITION = 1;
  public static final int MIN_TIME_INTERVAL = 1500;
  public static final int MSG_NOT_SHOW_NOT_ROOT = 260;
  public static final int MSG_NOT_SHOW_ROOT = 259;
  public static final int MSG_SHOW_NOT_ROOT = 258;
  public static final int MSG_SHOW_ROOT = 257;
  public static final String NO_DT_INDEX_PREFIX = "LP";
  public static final String NO_DT_INDEX_SUFFIX = ".lpdex";
  public static final String OPEN_DRIVING_TOOL = "open_driving_tool";
  public static final String OPEN_FAIL_IN_NAVI = "请在导航前设置";
  public static final String OPEN_FAIL_NO_LOGIN = "请登录后再试";
  public static final String OPEN_FAIL_NO_NETWORK = "请开启网络后再试";
  public static final String PM_SPLITER = ",";
  public static final String PULL_ISSUE_URL = "http://10.99.23.21:8088/naviServerAdmin/getdtproblemid";
  public static final String PULL_ISSUE_URL_ONLINE;
  public static final String PULL_ROAD_ID_URL = "http://10.99.23.21:8088/naviServerAdmin/getdtrouteid";
  public static final String PULL_ROAD_ID_URL_ONLINE;
  public static final String PULL_TASKLIST_URL = "http://10.99.23.21:8088/naviServerAdmin/getdttasklist";
  public static final String PULL_TASKLIST_URL_ONLINE = HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/naviServerAdmin/getdttasklist";
  public static final String PULL_TASK_SET_URL = "http://10.99.23.21:8088/naviServerAdmin/getdttaskdetailconfig";
  public static final String PULL_TASK_SET_URL_ONLINE;
  public static final String PUSH_ISSUE_URL = "http://10.99.23.21:8088/naviServerAdmin/submitdtrouteproblem";
  public static final String PUSH_ISSUE_URL_ONLINE;
  public static final String RESOURCE_PICTURE_SUFFIX = ".png";
  public static final String RESOURCE_VIDEO_SUFFIX = ".mp4";
  public static final String ROOT_USER_PERMISSION = "screenshot_root_user_permission";
  public static final int SCREEN_STATE_COLLADA = 1;
  public static final int SCREEN_STATE_ENLARGE = 3;
  public static final int SCREEN_STATE_NAVING = 2;
  public static final int SCREEN_STATE_OTHER = 0;
  public static final String SHOW_DRIVING_TOOL = "showing_driving_tool";
  public static final String SINGLE_TEST_ROUTE = "0";
  public static final int TYPE_NO_DT = 4;
  public static final int TYPE_SCREEN_SHOT = 3;
  public static final int TYPE_SCREEN_SHOT_BASE_MAP = 261;
  public static final int TYPE_SCREEN_SHOT_RENDER_MSG = 256;
  public static final int TYPE_TAKE_PHOTO = 2;
  public static final int TYPE_VIDEO_RECORD = 1;
  public static final String UPLOAD_FAIL_NO_WIFI = "请开启wifi后再试";
  public static final int VIDEO_COUNT_ON = 0;
  public static final int VIDEO_COUNT_STOP = 1;
  public static final String VIDEO_HIGH_DEFINITION = "video_high_definition";
  
  static
  {
    PULL_ROAD_ID_URL_ONLINE = HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/naviServerAdmin/getdtrouteid";
    PULL_ISSUE_URL_ONLINE = HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/naviServerAdmin/getdtproblemid";
    PULL_TASK_SET_URL_ONLINE = HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/naviServerAdmin/getdttaskdetailconfig";
    PUSH_ISSUE_URL_ONLINE = HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/naviServerAdmin/submitdtrouteproblem";
    ISSUE_TYPES = new String[] { "-  -  -  -  -  -  -  -  -  -  -  -  -  -  -", "客户端", "路线", "路况", "图像", "数据", "定位", "诱导" };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drivertool/BNDrivingToolParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */