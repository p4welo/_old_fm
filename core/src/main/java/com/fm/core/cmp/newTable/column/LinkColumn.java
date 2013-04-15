package com.fm.core.cmp.newTable.column;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

public abstract class LinkColumn<T, S> extends PropertyColumn<T, S>
{
   private static final long serialVersionUID = -2650301336136563227L;

   public LinkColumn(IModel<String> displayModel, String propertyExpression)
   {
      super(displayModel, propertyExpression);
   }

   public LinkColumn(IModel<String> displayModel, S sortProperty, String propertyExpression)
   {
      super(displayModel, sortProperty, propertyExpression);
   }

   public abstract void onClick(AjaxRequestTarget target, T object);

   protected void updateAjaxAttributes(AjaxRequestAttributes attributes, T object)
   {
   }

   @Override
   public void populateItem(Item cellItem, String componentId, IModel model)
   {
      cellItem.add(new LinkPanel(componentId, model));
   }

   private class LinkPanel extends Panel
   {
      private static final long serialVersionUID = 1L;

      public LinkPanel(String id, final IModel model)
      {
         super(id);

         AjaxLink<Void> creatorLink = new AjaxLink("columnLink", model)
         {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
               LinkColumn.this.onClick(target, (T) model.getObject());
            }

            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
            {
               super.updateAjaxAttributes(attributes);
               LinkColumn.this.updateAjaxAttributes(attributes, (T) model.getObject());
            }
         };
         creatorLink.add(new Label("columnLabel", getDataModel(model)));
         add(creatorLink);
      }
   }
}
