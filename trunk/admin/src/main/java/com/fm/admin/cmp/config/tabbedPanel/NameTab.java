package com.fm.admin.cmp.config.tabbedPanel;

import com.fm.admin.cmp.config.table.NameFilterToolbar;
import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.DataProvider;
import com.fm.core.cmp.newTable.SelectionChangeCallback;
import com.fm.domain.Name;
import com.fm.domain.filter.FmFilter;
import com.fm.domain.filter.OpenSearchDescription;
import com.fm.service.INameService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 13.04.13
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class NameTab extends Panel
{
   @SpringBean
   private INameService nameService;

   private WebMarkupContainer main;

   private Name selected;

   public NameTab(String id)
   {
      super(id);
      initView();
   }

   private void initView()
   {
      main = new WebMarkupContainer("main");
      main.setOutputMarkupId(true);
      add(main);

      OpenSearchDescription<Name> osd = new OpenSearchDescription<Name>();
      FmFilter filter = new FmFilter();
      osd.setFilter(filter);
      DataProvider<Name> dataProvider = new DataProvider<Name>(nameService, osd);
      List<IColumn<Name, String>> columns = new ArrayList<IColumn<Name, String>>();
      columns.add(new PropertyColumn<Name, String>(new ResourceModel("name"), Name.FIELD_VALUE, Name.FIELD_VALUE));
      AjaxDataTable<Name> dataTable = new AjaxDataTable<Name>("table", columns, dataProvider);
      dataTable.addFilterToolbar(new NameFilterToolbar(dataTable));
      dataTable.setSelectionChangeCallback(new SelectionChangeCallback<Name>()
      {
         @Override
         public void onSelectionChange(AjaxRequestTarget target, IModel<Name> model)
         {
            selected = model.getObject();
            target.add(main);
         }
      });
      main.add(dataTable);
      main.add(new NameDetailsPanel("details", new PropertyModel<Name>(this, "selected"), nameService, main));
   }
}
