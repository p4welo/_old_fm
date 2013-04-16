package com.fm.admin.cmp.config.table;

import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.toolbar.FilterToolbar;
import com.fm.domain.Name;
import com.fm.domain.filter.OpenSearchDescription;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

/**
 * User: pawel.radomski
 * Date: 16.04.13
 * Time: 10:50
 */
public class NameFilterToolbar extends FilterToolbar<Name>
{
   public NameFilterToolbar(final AjaxDataTable<Name> table)
   {
      super(table);
   }

   @Override
   public void registerFilters(DataTable<?, ?> table, OpenSearchDescription<Name> osd)
   {
      addFilter(new TextField<String>("name", new PropertyModel<String>(osd, "filter.name")), getString("name"));
   }
}
