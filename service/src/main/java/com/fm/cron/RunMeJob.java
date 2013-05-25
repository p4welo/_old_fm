package com.fm.cron;

import com.fm.service.impl.RunMeTask;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 25.05.13
 * Time: 11:35
 * To change this template use File | Settings | File Templates.
 */
public class RunMeJob extends QuartzJobBean
{
   private RunMeTask runMeTask;

   public void setRunMeTask(RunMeTask runMeTask)
   {
      this.runMeTask = runMeTask;
   }

   @Override
   protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException
   {
      runMeTask.printMe();
   }
}
