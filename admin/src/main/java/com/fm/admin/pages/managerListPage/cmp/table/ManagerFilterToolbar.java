package com.fm.admin.pages.managerListPage.cmp.table;

import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.toolbar.FilterToolbar;
import com.fm.domain.Manager;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.filter.OpenSearchDescription;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import java.util.Arrays;
import java.util.List;

/**
 * User: pawel.radomski
 * Date: 23.04.13
 * Time: 13:19
 */
public class ManagerFilterToolbar extends FilterToolbar<Manager>
{
   private List<ObjectStateEnum> objectStates = Arrays.asList(ObjectStateEnum.ACTIVE, ObjectStateEnum.INACTIVE);

   public ManagerFilterToolbar(final AjaxDataTable<Manager> table)
   {
      super(table);
   }

   @Override
   public void registerFilters(DataTable<?, ?> table, OpenSearchDescription<Manager> osd)
   {
      addFilter(new TextField<String>("name", new PropertyModel<String>(osd, "filter.name")));
      addFilter(new TextField<String>("surname", new PropertyModel<String>(osd, "filter.surname")));
      addFilter(new DropDownChoice<ObjectStateEnum>("objectState",
              new PropertyModel<ObjectStateEnum>(osd, "filter.objectState"), objectStates), "sdadas");
   }
}
