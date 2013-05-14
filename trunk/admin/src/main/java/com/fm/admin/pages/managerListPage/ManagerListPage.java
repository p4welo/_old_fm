package com.fm.admin.pages.managerListPage;

import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.breadcrumb.ManagerListBreadcrumb;
import com.fm.admin.pages.AdminAbstractPage;
import com.fm.admin.pages.managerListPage.cmp.ManagerMasterDetail;
import com.fm.core.cmp.authorization.UserAuthorities;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.domain.Manager;
import com.fm.service.IManagerService;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * User: pawel.radomski
 * Date: 16.04.13
 * Time: 15:12
 */
@MountPath(AdminApiMappings.MANAGER_LIST_PAGE)
@AuthorizeInstantiation(UserAuthorities.ADMIN)
public class ManagerListPage extends AdminAbstractPage
{
   @SpringBean
   private IManagerService managerService;

   private WebMarkupContainer main;

   private Manager selected;

   public ManagerListPage()
   {
      super();
      initView();
   }

   private void initView()
   {
      add(new ManagerMasterDetail("masterDetail"));
   }

   @Override
   protected BootstrapBreadcrumbPanel provideBreadcrumb(String id)
   {
      return new ManagerListBreadcrumb(id);
   }
}
