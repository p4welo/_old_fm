package com.fm.admin.pages.managerDetailsPage;

import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.breadcrumb.ManagerDetailsBreadcrumb;
import com.fm.admin.pages.AdminAbstractPage;
import com.fm.core.cmp.authorization.UserAuthorities;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * User: pawel.radomski
 * Date: 16.04.13
 * Time: 15:52
 */
@MountPath(AdminApiMappings.MANAGER_DETAILS_PAGE)
@AuthorizeInstantiation(UserAuthorities.ADMIN)
public class ManagerDetailsPage extends AdminAbstractPage
{
   public ManagerDetailsPage()
   {
      super();
   }

   @Override
   protected BootstrapBreadcrumbPanel provideBreadcrumb(String id)
   {
      return new ManagerDetailsBreadcrumb(id);
   }
}
