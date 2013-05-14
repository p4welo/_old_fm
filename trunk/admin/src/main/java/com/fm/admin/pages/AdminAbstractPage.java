package com.fm.admin.pages;

import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.menu.AdminMenuPanel;
import com.fm.admin.pages.leagueListPage.LeagueListPage;
import com.fm.core.cmp.authorization.LogoutLink;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import org.apache.wicket.markup.html.WebPage;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 28.03.13
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
public abstract class AdminAbstractPage extends WebPage implements AdminApiMappings, Serializable
{
   public AdminAbstractPage()
   {
      setOutputMarkupId(true);
      add(new AdminMenuPanel("menu"));
      add(new LogoutLink("logout", LeagueListPage.class));
      add(provideBreadcrumb("breadcrumb"));
   }

   protected abstract BootstrapBreadcrumbPanel provideBreadcrumb(String id);
}
