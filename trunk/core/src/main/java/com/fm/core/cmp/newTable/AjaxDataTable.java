package com.fm.core.cmp.newTable;

import com.fm.core.cmp.newTable.toolbar.FilterToolbar;
import com.fm.core.cmp.newTable.toolbar.ItemsPerPageToolbar;
import com.fm.core.cmp.newTable.toolbar.NavigationToolbar;
import com.fm.domain.IdentifiableEntity;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackHeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NoRecordsToolbar;

import java.util.ArrayList;
import java.util.List;

public class AjaxDataTable<T extends IdentifiableEntity> extends BaseDataTable<T>
{
   private static final long serialVersionUID = 6819434433719132878L;

   protected final DataProvider<T> dataProvider;

   private final List<FilterToolbar<T>> filterToolbars = new ArrayList<FilterToolbar<T>>();

   public AjaxDataTable(String id, List<? extends IColumn<T, String>> columns, DataProvider<T> dataProvider,
                        int rowsPerPage)
   {
      super(id, columns, dataProvider, rowsPerPage);
      this.dataProvider = dataProvider;
   }

   public AjaxDataTable(String id, List<? extends IColumn<T, String>> columns, DataProvider<T> dataProvider)
   {
      this(id, columns, dataProvider, DEFAULT_ITEMS_PER_PAGE);
   }

   @Override
   protected void onInitialize()
   {
      addToolbars();
      super.onInitialize();
   }

   public void addToolbars()
   {
      for (FilterToolbar<T> filterToolbar : filterToolbars)
      {
         filterToolbar.registerFilters(this, dataProvider.getFilterState());
         addTopToolbar(filterToolbar);
      }
      addTopToolbar(new AjaxFallbackHeadersToolbar(this, dataProvider));
      addBottomToolbar(new NoRecordsToolbar(this));
      addBottomToolbar(new NavigationToolbar(this));
      addBottomToolbar(new ItemsPerPageToolbar(this));
   }

   public void addFilterToolbar(FilterToolbar<T> filterToolbar)
   {
      filterToolbars.add(filterToolbar);
   }
}
