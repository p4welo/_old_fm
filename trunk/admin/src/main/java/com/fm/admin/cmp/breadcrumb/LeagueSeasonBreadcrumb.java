package com.fm.admin.cmp.breadcrumb;

import com.fm.admin.navigation.SimpleNavigateAction;
import com.fm.admin.pages.LeagueListPage;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.core.cmp.breadcrumb.BreadCrumbAction;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 28.04.13
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
public class LeagueSeasonBreadcrumb extends BootstrapBreadcrumbPanel
{
   public LeagueSeasonBreadcrumb(String id)
   {
      super(id);
   }

   @Override
   public List<BreadCrumbAction> provideLinkList()
   {
      return Arrays.asList(
              new BreadCrumbAction(new SimpleNavigateAction(LeagueListPage.class), new ResourceModel("home.link")),
              new BreadCrumbAction(new SimpleNavigateAction(LeagueListPage.class), new ResourceModel("league.list")),
              new BreadCrumbAction(new SimpleNavigateAction(LeagueListPage.class), new ResourceModel("league.details"))
      );
   }

   @Override
   public IModel provideActualLabelModel()
   {
      return new ResourceModel("league.season");
   }
}
