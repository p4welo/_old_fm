package com.fm.admin.cmp.config.table;

import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.toolbar.FilterToolbar;
import com.fm.domain.Surname;
import com.fm.domain.filter.OpenSearchDescription;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

/**
 * User: pawel.radomski
 * Date: 16.04.13
 * Time: 11:12
 */
public class SurnameFilterToolbar extends FilterToolbar<Surname>
{
   public SurnameFilterToolbar(final AjaxDataTable<Surname> table)
   {
      super(table);
   }

   @Override
   public void registerFilters(DataTable<?, ?> table, OpenSearchDescription<Surname> osd)
   {
      addFilter(new TextField<String>("surname", new PropertyModel<String>(osd, "filter.surname")),
              getString("surname"));
   }
}
