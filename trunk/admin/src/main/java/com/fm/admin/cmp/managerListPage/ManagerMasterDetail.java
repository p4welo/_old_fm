package com.fm.admin.cmp.managerListPage;

import com.fm.admin.cmp.managerListPage.table.ManagerFilterToolbar;
import com.fm.core.cmp.masterDetail.MasterDetailPanel;
import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.DataProvider;
import com.fm.core.cmp.table.column.TranslatedColumn;
import com.fm.domain.Manager;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.User;
import com.fm.domain.filter.FmFilter;
import com.fm.domain.filter.OpenSearchDescription;
import com.fm.service.IManagerService;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pawel.radomski
 * Date: 23.04.13
 * Time: 17:12
 */
public class ManagerMasterDetail extends MasterDetailPanel<Manager>
{
   @SpringBean
   private IManagerService managerService;

   public ManagerMasterDetail(String id)
   {
      super(id);
   }

   @Override
   protected Panel provideDetailsPanel(String id, IModel<Manager> model)
   {
      return new ManagerDetailsPanel(id, model);
   }

   @Override
   protected AjaxDataTable<Manager> provideMasterTable(String id)
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
              Manager.FIELD_USER + "." + User.FIELD_LOGIN
      ));
//      columns.add(new PropertyColumn<Manager, String>(
//              new ResourceModel("user.email"),
//              Manager.FIELD_USER + "." + User.FIELD_EMAIL
//      ));
      columns.add(new TranslatedColumn<Manager, String>(
              new ResourceModel("object.state"),
              null,
              Manager.FIELD_USER + "." + User.FIELD_OBJECT_STATE,
              ObjectStateEnum.class.getSimpleName()
      ));
      OpenSearchDescription<Manager> osd = new OpenSearchDescription<Manager>();
      FmFilter filter = new FmFilter();
      osd.setFilter(filter);
      DataProvider dataProvider = new DataProvider(managerService, osd);

      AjaxDataTable<Manager> table = new AjaxDataTable<Manager>(id, columns, dataProvider);
      table.addFilterToolbar(new ManagerFilterToolbar(table));
      return table;
   }
}
