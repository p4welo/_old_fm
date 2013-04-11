package com.fm.admin.pages;

import com.fm.admin.api.AdminApiMappings;
import com.fm.admin.cmp.breadcrumb.LeagueListBreadcrumb;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import com.fm.core.cmp.table.AjaxDataTable;
import com.fm.core.cmp.table.DataProvider;
import com.fm.domain.DataEntity;
import com.fm.domain.Position;
import com.fm.service.IPositionService;
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
public class Index extends AdminAbstractPage
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

   @Override
   protected BootstrapBreadcrumbPanel provideBreadcrumb(String id)
   {
      return new LeagueListBreadcrumb(id);
   }
}
