package com.fm.core.cmp.newTable.toolbar;

import com.fm.core.cmp.newTable.SelectionChangeAware;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.*;

import java.util.Arrays;
import java.util.List;

public class ItemsPerPageToolbar extends AbstractToolbar
{
   private static final long serialVersionUID = -4725485194591705125L;

   private static final List<Long> DEFAULT_CHOICES = Arrays.asList(5L, 10L, 25L, 50L);

   private static final IModel<String> DEFAULT_MESSAGE_MODEL = new ResourceModel("datatable.itemsPerPage");

   private Long selected;

   public ItemsPerPageToolbar(final DataTable<?, ?> table, List<Long> choices)
   {
      super(table);
      selected = table.getItemsPerPage();
      WebMarkupContainer container = new WebMarkupContainer("itemsPerPageContainer");

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

      DropDownChoice<Long> dropDownChoice = new DropDownChoice<Long>("itemsPerPageDropDown", new PropertyModel<Long>(
              this,
              "selected"), choices);

      dropDownChoice.add(new AjaxFormComponentUpdatingBehavior("change")
      {
         private static final long serialVersionUID = -3456772446686602298L;

         @Override
         protected void onUpdate(AjaxRequestTarget target)
         {
            table.setItemsPerPage(selected);
            if (table instanceof SelectionChangeAware)
            {
               SelectionChangeAware selectionChangeAware = (SelectionChangeAware) table;
               selectionChangeAware.executeOnClick(target, new Model(null));
            }
            target.add(table);
         }
      });
      container.add(dropDownChoice);
      container.add(new Label("itemsPerPageMessage", DEFAULT_MESSAGE_MODEL));
   }

   public ItemsPerPageToolbar(DataTable<?, ?> table)
   {
      this(table, DEFAULT_CHOICES);
   }

   @Override
   public boolean isVisible()
   {
      return getTable().getRowCount() > 0;
   }

   public Long getSelected()
   {
      return selected;
   }

   public void setSelected(Long selected)
   {
      this.selected = selected;
   }
}
