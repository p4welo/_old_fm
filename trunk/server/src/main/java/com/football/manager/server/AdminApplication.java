package com.football.manager.server;

import com.football.manager.admin.pages.LeagueListPage;
import com.football.manager.server.pages.LoginPage;
import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.settings.IRequestCycleSettings;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.ApplicationContext;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;

/**
 * User: pawel.radomski
 * Date: 25.01.13
 * Time: 16:55
 */
public class AdminApplication extends AuthenticatedWebApplication
{
   private ApplicationContext ctx;

   @Override
   public Class<? extends Page> getHomePage()
   {
//      return SamplePage.class;
      return LeagueListPage.class;
   }

   //http://wicket.wordpress.com/2010/01/08/template-for-building-authenticated-webapplication/

   @Override
   protected void init()
   {
      super.init();
      getComponentInstantiationListeners().add(new SpringComponentInjector(this));
      new AnnotatedMountScanner().scanPackage(AdminApplication.class.getPackage().getName()).mount(this);
      getDebugSettings().setAjaxDebugModeEnabled(false);
      getRequestCycleSettings().setRenderStrategy(IRequestCycleSettings.RenderStrategy.ONE_PASS_RENDER);
   }

   public static AdminApplication get()
   {
      return (AdminApplication) AdminApplication.get();
   }

   public static AdminSession getSession()
   {
      return AdminSession.get();
   }

   @Override
   protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass()
   {
      return AdminSession.class;
   }

   @Override
   protected Class<? extends WebPage> getSignInPageClass()
   {
      return LoginPage.class;
   }
}
