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
 * User: pawel.radomski
 * Date: 10.04.13
 * Time: 18:00
 */
public class LeagueDetailsBreadcrumb extends BootstrapBreadcrumbPanel
{
   public LeagueDetailsBreadcrumb(String id)
   {
      super(id);
   }

   @Override
   public List<BreadCrumbAction> provideLinkList()
   {
      return Arrays.asList(
              new BreadCrumbAction(new SimpleNavigateAction(LeagueListPage.class), new ResourceModel("home.link")),
              new BreadCrumbAction(new SimpleNavigateAction(LeagueListPage.class), new ResourceModel("league.list"))
      );
   }

   @Override
   public IModel provideActualLabelModel()
   {
      return new ResourceModel("league.details");
   }
}
