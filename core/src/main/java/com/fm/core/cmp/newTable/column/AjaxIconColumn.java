package com.fm.core.cmp.newTable.column;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

public abstract class AjaxIconColumn<T> extends AbstractColumn<T, String>
{
   private static final long serialVersionUID = -1151190752677631537L;

   private final String icon;

   public AjaxIconColumn(IModel<String> displayModel, String icon)
   {
      super(displayModel);
      this.icon = icon;
   }

   @Override
   public void populateItem(Item cellItem, String componentId, IModel rowModel)
   {
      cellItem.add(new IconPanel(componentId, rowModel));
   }

   public abstract void onClick(AjaxRequestTarget target, T object);

   protected void updateAjaxAttributes(AjaxRequestAttributes attributes, T object)
   {
   }

   private class IconPanel extends Panel
   {
      private static final long serialVersionUID = 1L;

      public IconPanel(String id, final IModel model)
      {
         super(id);

         AjaxLink<Void> link = new AjaxLink("link", model)
         {
            private static final long serialVersionUID = -2213765425305379724L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
               AjaxIconColumn.this.onClick(target, (T) model.getObject());
            }

            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
            {
               super.updateAjaxAttributes(attributes);
               AjaxIconColumn.this.updateAjaxAttributes(attributes, (T) model.getObject());
            }
         };
         Label label = new Label("icon");
         label.add(AttributeModifier.replace("class", icon));
         link.add(label);
         add(link);
      }
   }

   @Override
   public String getCssClass()
   {
      return "wicket_orderNone icon_link_column";
   }
}
