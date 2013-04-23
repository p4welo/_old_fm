package com.fm.admin.cmp.managerListPage.table;

import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.toolbar.FilterToolbar;
import com.fm.domain.Manager;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.filter.OpenSearchDescription;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.html.form.DropDownChoice;
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
   private List<ObjectStateEnum> objectStates = Arrays.asList(ObjectStateEnum.values());

   public ManagerFilterToolbar(final AjaxDataTable<Manager> table)
   {
      super(table);
   }

   @Override
   public void registerFilters(DataTable<?, ?> table, OpenSearchDescription<Manager> osd)
   {
      addFilter(new DropDownChoice<ObjectStateEnum>("objectState",
              new PropertyModel<ObjectStateEnum>(osd, "filter.objectState"), objectStates));
   }
}
