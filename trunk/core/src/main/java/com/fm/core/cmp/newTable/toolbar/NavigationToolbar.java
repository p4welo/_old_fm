package com.fm.core.cmp.newTable.toolbar;

import com.fm.core.cmp.newTable.SelectionChangeAware;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxNavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.Model;

public class NavigationToolbar extends AjaxNavigationToolbar
{
   private static final long serialVersionUID = 970808244846737028L;

   public NavigationToolbar(DataTable<?, ?> table)
   {
      super(table);
   }

   @Override
   protected WebComponent newNavigatorLabel(String navigatorId, DataTable<?, ?> table)
   {
      return new NavigatorLabel(navigatorId, table);
   }

   @Override
   protected PagingNavigator newPagingNavigator(String navigatorId, final DataTable<?, ?> table)
   {
      return new BootstrapPagingNavigator(navigatorId, table)
      {
         private static final long serialVersionUID = 954360980978165277L;

         @Override
         protected void onAjaxEvent(final AjaxRequestTarget target)
         {
            if (table instanceof SelectionChangeAware)
            {
               SelectionChangeAware selectionChangeAware = (SelectionChangeAware) table;
               selectionChangeAware.executeOnClick(target, new Model(null));
            }
            target.add(table);
         }
      };
   }
}
