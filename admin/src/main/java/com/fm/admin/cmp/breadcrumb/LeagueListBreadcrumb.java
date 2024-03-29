package com.fm.admin.cmp.breadcrumb;

import com.fm.admin.navigation.SimpleNavigateAction;
import com.fm.admin.pages.leagueListPage.LeagueListPage;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.core.cmp.breadcrumb.BreadCrumbAction;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 03.04.13
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 */
public class LeagueListBreadcrumb extends BootstrapBreadcrumbPanel
{
   public LeagueListBreadcrumb(String id)
   {
      super(id);
   }

   @Override
   public List<BreadCrumbAction> provideLinkList()
   {
      return Arrays.asList(
              new BreadCrumbAction(new SimpleNavigateAction(LeagueListPage.class), new ResourceModel("home.link"))
      );
   }

   @Override
   public IModel provideActualLabelModel()
   {
      return new ResourceModel("league.list");
   }
}
