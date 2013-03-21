package com.football.manager.admin.cmp.table;

import com.football.manager.domain.DataEntity;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * User: pawel
 * Date: 26.01.13
 * Time: 12:59
 */
public class AjaxDataTable<T extends DataEntity> extends AjaxFallbackDefaultDataTable<T, String>
{
   public AjaxDataTable(String id, List<? extends IColumn<T, String>> iColumns,
                        ISortableDataProvider<T, String> dataProvider, int rowsPerPage)
   {
      super(id, iColumns, dataProvider, rowsPerPage);
   }

   @Override
   protected Item<T> newRowItem(String id, int index, final IModel<T> model)
   {
      final Item<T> item = super.newRowItem(id, index, model);

      item.add(new AjaxEventBehavior("onclick")
      {
         protected void onEvent(AjaxRequestTarget target)
         {
            executeOnClick(target, item.getModel());
         }
      });

      return item;
   }

   protected void executeOnClick(AjaxRequestTarget target, IModel<T> model)
   {
   }
}
