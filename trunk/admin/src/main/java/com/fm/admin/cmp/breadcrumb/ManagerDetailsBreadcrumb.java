package com.fm.admin.cmp.breadcrumb;

import com.fm.admin.navigation.SimpleNavigateAction;
import com.fm.admin.pages.leagueListPage.LeagueListPage;
import com.fm.admin.pages.managerListPage.ManagerListPage;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.core.cmp.breadcrumb.BreadCrumbAction;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

import java.util.Arrays;
import java.util.List;

/**
 * User: pawel.radomski
 * Date: 16.04.13
 * Time: 15:55
 */
public class ManagerDetailsBreadcrumb extends BootstrapBreadcrumbPanel
{
   public ManagerDetailsBreadcrumb(String id)
   {
      super(id);
   }

   @Override
   public List<BreadCrumbAction> provideLinkList()
   {
      return Arrays.asList(
              new BreadCrumbAction(new SimpleNavigateAction(LeagueListPage.class), new ResourceModel("home.link")),
              new BreadCrumbAction(new SimpleNavigateAction(ManagerListPage.class), new ResourceModel("manager.list"))
      );
   }

   @Override
   public IModel provideActualLabelModel()
   {
      return new ResourceModel("manager.details");
   }
}
