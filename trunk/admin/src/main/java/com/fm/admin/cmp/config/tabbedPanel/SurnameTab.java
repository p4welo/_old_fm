package com.fm.admin.cmp.config.tabbedPanel;

import com.fm.admin.cmp.config.table.SurnameFilterToolbar;
import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.DataProvider;
import com.fm.domain.Surname;
import com.fm.domain.filter.FmFilter;
import com.fm.domain.filter.OpenSearchDescription;
import com.fm.service.ISurnameService;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 15.04.13
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
public class SurnameTab extends Panel
{
   @SpringBean
   private ISurnameService surnameService;

   public SurnameTab(String id)
   {
      super(id);
      initView();
   }

   private void initView()
   {
      OpenSearchDescription<Surname> osd = new OpenSearchDescription<Surname>();
      FmFilter filter = new FmFilter();
      osd.setFilter(filter);
      DataProvider<Surname> dataProvider = new DataProvider<Surname>(surnameService, osd);
      List<IColumn<Surname, String>> columns = new ArrayList<IColumn<Surname, String>>();
      columns.add(new PropertyColumn<Surname, String>(new ResourceModel("surname"), Surname.FIELD_VALUE,
              Surname.FIELD_VALUE));
      AjaxDataTable<Surname> dataTable = new AjaxDataTable<Surname>("table", columns, dataProvider);
      dataTable.addFilterToolbar(new SurnameFilterToolbar(dataTable));
      add(dataTable);
   }
}
