package com.fm.admin.navigation;

import com.fm.admin.api.AdminApiKeys;
import com.fm.admin.pages.managerDetailsPage.ManagerDetailsPage;
import com.fm.core.navigation.NavigateAction;
import com.fm.domain.Manager;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * User: pawel.radomski
 * Date: 16.04.13
 * Time: 15:51
 */
public class NavigateToManagerDetailsPage extends NavigateAction
{
   private Manager manager;

   public NavigateToManagerDetailsPage(Manager manager)
   {
      super(ManagerDetailsPage.class);
      this.manager = manager;
   }

   @Override
   public PageParameters getPageParameters()
   {
      PageParameters pageParameters = new PageParameters();
      pageParameters.add(AdminApiKeys.SELECTED_MANAGER_SID_KEY, manager.getSid());
      return pageParameters;
   }
}
