package com.fm.admin.cmp.configPage.masterDetail;

import com.fm.admin.cmp.configPage.table.NameFilterToolbar;
import com.fm.core.cmp.masterDetail.MasterDetailPanel;
import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.DataProvider;
import com.fm.domain.Name;
import com.fm.domain.filter.FmFilter;
import com.fm.domain.filter.OpenSearchDescription;
import com.fm.service.INameService;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 18.04.13
 * Time: 19:36
 * To change this template use File | Settings | File Templates.
 */
public class NameMasterDetail extends MasterDetailPanel<Name>
{
   @SpringBean
   private INameService nameService;

   public NameMasterDetail(String id)
   {
      super(id);
   }

   @Override
   protected Panel provideDetailsPanel(String id, IModel<Name> model)
   {
      return new NameDetailsPanel(id, model, nameService, NameMasterDetail.this);
   }

   @Override
   protected AjaxDataTable<Name> provideMasterTable(String id)
   {
      OpenSearchDescription<Name> osd = new OpenSearchDescription<Name>();
      FmFilter filter = new FmFilter();
      osd.setFilter(filter);
      DataProvider<Name> dataProvider = new DataProvider<Name>(nameService, osd);

      List<IColumn<Name, String>> columns = new ArrayList<IColumn<Name, String>>();
      columns.add(new PropertyColumn<Name, String>(new ResourceModel("name"), Name.FIELD_VALUE, Name.FIELD_VALUE));

      AjaxDataTable<Name> dataTable = new AjaxDataTable<Name>(id, columns, dataProvider);
      dataTable.addFilterToolbar(new NameFilterToolbar(dataTable));
      return dataTable;
   }
}
