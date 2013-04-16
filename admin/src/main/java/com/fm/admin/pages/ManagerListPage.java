package com.fm.admin.pages;

import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.breadcrumb.ManagerListBreadcrumb;
import com.fm.admin.navigation.NavigateToManagerDetailsPage;
import com.fm.core.cmp.authorization.UserRoles;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.DataProvider;
import com.fm.domain.Manager;
import com.fm.domain.UserEntity;
import com.fm.domain.filter.FmFilter;
import com.fm.domain.filter.OpenSearchDescription;
import com.fm.service.IManagerService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pawel.radomski
 * Date: 16.04.13
 * Time: 15:12
 */
@MountPath(AdminApiMappings.MANAGER_LIST_PAGE)
@AuthorizeInstantiation(UserRoles.ADMIN)
public class ManagerListPage extends AdminAbstractPage
{
   @SpringBean
   private IManagerService managerService;

   private WebMarkupContainer main;

   public ManagerListPage()
   {
      super();
      main = new WebMarkupContainer("main");
      main.setOutputMarkupId(true);

      initView();
   }

   private void initView()
   {
      createUserTable();
      add(main);
   }

   private void createUserTable()
   {
      List<IColumn<Manager, String>> columns = new ArrayList<IColumn<Manager, String>>();

      columns.add(new PropertyColumn<Manager, String>(
              new ResourceModel("manager.name"),
              Manager.FIELD_NAME,
              Manager.FIELD_NAME
      ));
      columns.add(new PropertyColumn<Manager, String>(
              new ResourceModel("manager.surname"),
              Manager.FIELD_SURNAME,
              Manager.FIELD_SURNAME
      ));
      columns.add(new PropertyColumn<Manager, String>(
              new ResourceModel("user.login"),
              Manager.FIELD_USER + "." + UserEntity.FIELD_LOGIN
      ));
      columns.add(new PropertyColumn<Manager, String>(
              new ResourceModel("user.email"),
              Manager.FIELD_USER + "." + UserEntity.FIELD_EMAIL
      ));
      OpenSearchDescription<Manager> osd = new OpenSearchDescription<Manager>();
      FmFilter filter = new FmFilter();
      osd.setFilter(filter);
      DataProvider dataProvider = new DataProvider(managerService, osd);

      main.add(new AjaxDataTable<Manager>("table", columns, dataProvider)
      {
         @Override
         public void executeOnClick(AjaxRequestTarget target, IModel<Manager> model)
         {
            new NavigateToManagerDetailsPage(model.getObject()).navigate();
         }
      });
   }

   @Override
   protected BootstrapBreadcrumbPanel provideBreadcrumb(String id)
   {
      return new ManagerListBreadcrumb(id);
   }
}
