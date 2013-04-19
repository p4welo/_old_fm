package com.fm.admin.cmp.config.masterDetail;

import com.fm.admin.cmp.config.table.SurnameFilterToolbar;
import com.fm.core.cmp.masterDetail.MasterDetailPanel;
import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.DataProvider;
import com.fm.domain.Surname;
import com.fm.domain.filter.FmFilter;
import com.fm.domain.filter.OpenSearchDescription;
import com.fm.service.ISurnameService;
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
 * Date: 19.04.13
 * Time: 10:40
 */
public class SurnameMasterDetail extends MasterDetailPanel<Surname>
{
   @SpringBean
   private ISurnameService surnameService;

   public SurnameMasterDetail(String id)
   {
      super(id);
   }

   @Override
   protected Panel provideDetailsPanel(String id, IModel<Surname> model)
   {
      return new SurnameDetailsPanel(id, model, surnameService, SurnameMasterDetail.this);
   }

   @Override
   protected AjaxDataTable<Surname> provideMasterTable(String id)
   {
      OpenSearchDescription<Surname> osd = new OpenSearchDescription<Surname>();
      FmFilter filter = new FmFilter();
      osd.setFilter(filter);
      DataProvider<Surname> dataProvider = new DataProvider<Surname>(surnameService, osd);

      List<IColumn<Surname, String>> columns = new ArrayList<IColumn<Surname, String>>();
      columns.add(new PropertyColumn<Surname, String>(new ResourceModel("surname"), Surname.FIELD_VALUE,
              Surname.FIELD_VALUE));

      AjaxDataTable<Surname> dataTable = new AjaxDataTable<Surname>(id, columns, dataProvider);
      dataTable.addFilterToolbar(new SurnameFilterToolbar(dataTable));
      return dataTable;
   }
}
