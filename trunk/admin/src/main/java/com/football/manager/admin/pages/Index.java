package com.football.manager.admin.pages;

import com.football.manager.admin.api.AdminApiMappings;
import com.football.manager.admin.cmp.table.AjaxDataTable;
import com.football.manager.admin.cmp.table.DataProvider;
import com.football.manager.domain.DataEntity;
import com.football.manager.domain.Position;
import com.football.manager.service.IPositionService;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pawel
 * Date: 12.01.13
 * Time: 13:02
 */
@MountPath(AdminApiMappings.INDEX_PAGE)
public class Index extends AbstractPage
{
   @SpringBean
   private IPositionService positionService;

   public Index()
   {
      super();
      List<Position> positionList = positionService.findAll();

      List<IColumn<Position, String>> columns = new ArrayList<IColumn<Position, String>>();

      columns.add(new PropertyColumn<Position, String>(new Model<String>("ID"), DataEntity.FIELD_ID));
      columns.add(new PropertyColumn<Position, String>(new Model<String>("Short Name"), Position.FIELD_SHORT_NAME,
              Position.FIELD_SHORT_NAME));
      columns.add(new PropertyColumn<Position, String>(new Model<String>("Full Name"), Position.FIELD_FULL_NAME,
              Position.FIELD_FULL_NAME));

      add(new AjaxDataTable<Position>("table", columns,
              new DataProvider<Position>(positionService), 8));
   }
}