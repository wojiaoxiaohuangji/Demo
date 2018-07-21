package com.baidu.navisdk.logic.task;

import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandCenter.CommandCenterListener;
import com.baidu.navisdk.logic.CommandDispatcher;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import java.util.concurrent.Callable;

public class GeneralFuncTask
{
  public static CommandResult doTask(ReqData paramReqData, String paramString)
    throws Exception
  {
    CommandResult localCommandResult = new CommandResult();
    paramString = CommandDispatcher.getCommandParser(paramString);
    if (paramString != null) {
      return paramString.execute(paramReqData);
    }
    localCommandResult.set(55537);
    return localCommandResult;
  }
  
  public static Callable<CommandResult> newTask(ReqData paramReqData)
  {
    new Callable()
    {
      public CommandResult call()
        throws Exception
      {
        CommandResult localCommandResult = GeneralFuncTask.doTask(this.val$reqdata, this.val$reqdata.mCmd);
        this.val$reqdata.mRequestListener.onRequestFinish(this.val$reqdata, localCommandResult);
        return localCommandResult;
      }
    };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/task/GeneralFuncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */