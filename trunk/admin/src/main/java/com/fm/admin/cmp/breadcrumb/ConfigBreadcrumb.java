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
 * Date: 13.04.13
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
public class ConfigBreadcrumb extends BootstrapBreadcrumbPanel
{
   public ConfigBreadcrumb(String id)
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
      return new ResourceModel("config");
   }
}
