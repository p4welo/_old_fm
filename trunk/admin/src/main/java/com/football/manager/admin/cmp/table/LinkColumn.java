package com.football.manager.admin.cmp.table;

import com.football.manager.domain.DataEntity;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * User: pawel
 * Date: 26.01.13
 * Time: 23:58
 */
public abstract class LinkColumn<T extends DataEntity, S> extends PropertyColumn<T, S>
{
   private String linkLabel = null;

   public LinkColumn(IModel<String> displayModel, S sortProperty, String propertyExpression)
   {
      super(displayModel, sortProperty, propertyExpression);
   }

   public LinkColumn(IModel<String> displayModel, S sortProperty, String propertyExpression, String linkLabel)
   {
      this(displayModel, sortProperty, propertyExpression);
      this.linkLabel = linkLabel;
   }

   public abstract void actionOnClick(AjaxRequestTarget target, T object);

   public void actionUpdateAjaxAttributes(AjaxRequestAttributes attributes, T object)
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
            @Override
            public void onClick(AjaxRequestTarget target)
            {
               actionOnClick(target, (T) model.getObject());
            }

            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
            {
               super.updateAjaxAttributes(attributes);
               actionUpdateAjaxAttributes(attributes, (T) model.getObject());
            }
         };
         if (linkLabel != null)
         {
            creatorLink.add(new Label("columnLabel", linkLabel));
         }
         else
         {
            creatorLink.add(new Label("columnLabel", getDataModel(model)));
         }
         add(creatorLink);
      }
   }
}
