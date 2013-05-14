package com.fm.admin.pages.configPage.cmp.masterDetail;

import com.fm.core.cmp.masterDetail.MasterDetailPanel;
import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.DataProvider;
import com.fm.domain.Position;
import com.fm.domain.filter.FmFilter;
import com.fm.domain.filter.OpenSearchDescription;
import com.fm.service.IPositionService;
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
 * Time: 10:29
 */
public class PositionMasterDetail extends MasterDetailPanel<Position>
{
   @SpringBean
   private IPositionService positionService;

   private List<Position> positions;

   public PositionMasterDetail(String id)
   {
      super(id);
   }

   @Override
   protected Panel provideDetailsPanel(String id, IModel<Position> model)
   {
      return new PositionDetailsPanel(id, model, this);
   }

   @Override
   protected AjaxDataTable<Position> provideMasterTable(String id)
   {
      OpenSearchDescription<Position> osd = new OpenSearchDescription<Position>();
      FmFilter filter = new FmFilter();
      osd.setFilter(filter);
      DataProvider<Position> dataProvider = new DataProvider<Position>(positionService, osd);

      List<IColumn<Position, String>> columns = new ArrayList<IColumn<Position, String>>();
      columns.add(new PropertyColumn<Position, String>(new ResourceModel("name"), Position.FIELD_FULL_NAME));
      columns.add(new PropertyColumn<Position, String>(new ResourceModel("shortName"), Position.FIELD_SHORT_NAME));

      AjaxDataTable<Position> dataTable = new AjaxDataTable<Position>(id, columns, dataProvider, 25);
      return dataTable;
   }
}
