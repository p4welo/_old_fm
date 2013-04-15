package com.fm.core.cmp.newTable.toolbar;

import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.FilterDecorator;
import com.fm.domain.IdentifiableEntity;
import com.fm.domain.filter.OpenSearchDescription;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.Model;

public abstract class FilterToolbar<T extends IdentifiableEntity> extends AbstractToolbar
{
   private static final long serialVersionUID = -2639398500580202460L;

   private WebMarkupContainer container;

   private AjaxDataTable<T> table;

   private final FilterDecorator filterDecorator;

   public FilterToolbar(final AjaxDataTable<T> table)
   {
      super(table);
      this.table = table;
      container = new WebMarkupContainer("filtersContainer");
      add(container);

      container.add(AttributeModifier.replace("colspan", new AbstractReadOnlyModel<String>()
      {
         private static final long serialVersionUID = 1L;

         @Override
         public String getObject()
         {
            return String.valueOf(table.getColumns().size());
         }
      }));

      filterDecorator = new FilterDecorator()
      {
         @Override
         protected void onUpdate(AjaxRequestTarget target)
         {
            table.executeOnClick(target, new Model<T>(null));
            target.add(table);
         }
      };
   }

   public void addFilter(final Component filter)
   {
      addFilter(filter, null);
   }

   public void addFilter(final Component filter, String placeholder)
   {
      filterDecorator.decorate(filter, placeholder);
      container.add(filter);
   }

   public void addComponent(Component component)
   {
      container.add(component);
   }

   @Override
   public boolean isVisible()
   {
      return container.size() > 0;
   }

   public abstract void registerFilters(DataTable<?, ?> table, OpenSearchDescription<T> osd);
}
