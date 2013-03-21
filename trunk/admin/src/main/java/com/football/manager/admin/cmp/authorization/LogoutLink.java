package com.football.manager.admin.cmp.authorization;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 21.03.13
 * Time: 22:27
 * To change this template use File | Settings | File Templates.
 */
public class LogoutLink extends Link
{
   private final Class page;

   public LogoutLink(String id, Class<? extends WebPage> page)
   {
      super(id);
      this.page = page;
   }

   @Override
   public void onClick()
   {
      AuthenticatedWebSession session = AuthenticatedWebSession.get();
      session.invalidateNow();
      setResponsePage(page);
   }
}
