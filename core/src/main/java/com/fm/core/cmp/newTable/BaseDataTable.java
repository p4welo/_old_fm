package com.fm.core.cmp.newTable;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.OddEvenItem;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;

import java.util.List;

public class BaseDataTable<T> extends DataTable<T, String> implements SelectionChangeAware<T>
{
   private static final long serialVersionUID = -5679324343287470525L;

   public static final int DEFAULT_ITEMS_PER_PAGE = 10;

   protected SelectionChangeCallback<T> selectionChangeCallback;

   protected T selected;

   protected IDataProvider<T> dataProvider;

   public BaseDataTable(String id, List<? extends IColumn<T, String>> columns, IDataProvider<T> dataProvider,
                        int rowsPerPage)
   {
      super(id, columns, dataProvider, rowsPerPage);
      setOutputMarkupId(true);
      setVersioned(false);
      this.dataProvider = dataProvider;
   }

   public BaseDataTable(String id, List<? extends IColumn<T, String>> columns, IDataProvider<T> dataProvider)
   {
      this(id, columns, dataProvider, DEFAULT_ITEMS_PER_PAGE);
   }

   @Override
   protected Item<T> newRowItem(final String id, final int index, final IModel<T> model)
   {
      final Item<T> item = new OddEvenItem<T>(id, index, model);
      item.add(new AjaxEventBehavior("onclick")
      {
         private static final long serialVersionUID = 7672021482216074145L;

         @Override
         protected void onEvent(AjaxRequestTarget target)
         {
            executeOnClick(target, item.getModel());
         }

         @Override
         protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
         {
            super.updateAjaxAttributes(attributes);
            attributes.setAllowDefault(true);
         }
      });

      if (model.getObject().equals(selected))
      {
         item.add(AttributeModifier.append("class", "selectedElement"));
      }
      return item;
   }

   @Override
   public void executeOnClick(AjaxRequestTarget target, IModel<T> model)
   {
      selected = model.getObject();
      if (selectionChangeCallback != null)
      {
         selectionChangeCallback.onSelectionChange(target, model);
      }
   }

   public SelectionChangeCallback<T> getSelectionChangeCallback()
   {
      return selectionChangeCallback;
   }

   public void setSelectionChangeCallback(SelectionChangeCallback<T> selectionChangeCallback)
   {
      this.selectionChangeCallback = selectionChangeCallback;
   }

   public T getSelected()
   {
      return selected;
   }

   public void setSelected(T selected)
   {
      this.selected = selected;
   }
}
