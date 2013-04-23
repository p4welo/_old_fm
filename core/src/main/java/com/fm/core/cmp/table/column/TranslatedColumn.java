package com.fm.core.cmp.table.column;

import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

/**
 * User: pawel.radomski
 * Date: 26.03.13
 * Time: 16:09
 */
public class TranslatedColumn<T, S> extends PropertyColumn<T, S>
{
   private final String prefix;

   public TranslatedColumn(IModel<String> displayModel, S sortProperty, String propertyExpression)
   {
      this(displayModel, sortProperty, propertyExpression, "");
   }

   public TranslatedColumn(IModel<String> displayModel, S sortProperty, String propertyExpression, String prefix)
   {
      super(displayModel, sortProperty, propertyExpression);
      this.prefix = prefix;
   }

   @Override
   protected IModel<?> createLabelModel(IModel<T> rowModel)
   {
      final IModel<?> originalModel = super.createLabelModel(rowModel);
      String key = originalModel.getObject().toString();
      return new ResourceModel(prefix + key);
   }
}
