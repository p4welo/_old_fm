package com.fm.core.cmp.newTable.column;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

public abstract class IconColumn<T> extends AbstractColumn<T, String>
{
   private static final long serialVersionUID = 7016193003496251310L;

   private final String icon;

   public IconColumn(IModel<String> displayModel, String icon)
   {
      super(displayModel);
      this.icon = icon;
   }

   @Override
   public void populateItem(Item cellItem, String componentId, IModel rowModel)
   {
      cellItem.add(new IconPanel(componentId, rowModel));
   }

   public abstract void onClick(T object);

   private class IconPanel extends Panel
   {
      private static final long serialVersionUID = 1L;

      public IconPanel(String id, final IModel model)
      {
         super(id);

         Link<Void> link = new Link("link", model)
         {
            private static final long serialVersionUID = -8077304318154652238L;

            @Override
            public void onClick()
            {
               IconColumn.this.onClick((T) model.getObject());
            }
         };
         Label label = new Label("icon");
         label.add(AttributeModifier.replace("class", icon));
         link.add(label);
         add(link);
      }
   }
}
