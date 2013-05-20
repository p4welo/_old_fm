package com.fm.admin.pages;

import com.fm.admin.cmp.breadcrumb.LeagueListBreadcrumb;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.core.cmp.progress.ProgressBar;
import com.fm.domain.Progress;
import org.apache.wicket.model.PropertyModel;

/**
 * User: pawel.radomski
 * Date: 17.05.13
 * Time: 15:51
 */
public class TestPage extends AdminAbstractPage
{
   private final Progress progress = new Progress();

   public TestPage()
   {
      super();
   }

   @Override
   protected void onInitialize()
   {
      super.onInitialize();
      ProgressBar progressBar = new ProgressBar("progress", PropertyModel.of(this, "progress." + Progress.FIELD_VALUE));
      add(progressBar);
      new Thread(new TestThread(progress)).start();
   }

   @Override
   protected BootstrapBreadcrumbPanel provideBreadcrumb(String id)
   {
      return new LeagueListBreadcrumb(id);
   }

   public static class TestThread implements Runnable
   {

      private Progress progress;

      public TestThread(Progress progress)
      {
         this.progress = progress;
      }

      @Override
      public void run()
      {
//         do
//         {
//            System.out.println("sdf");
//            try
//            {
//               Thread.sleep(1000);
//               progress.setValue(progress.getValue() + 10);
//            }
//            catch (InterruptedException e)
//            {
//            }
//         }
//         while (progress.getValue() < 100);
      }
   }
}
