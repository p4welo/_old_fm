package com.fm.core.cmp.newTable.column;

import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

import java.text.Format;

/**
 * User: pawel.radomski
 * Date: 26.03.13
 * Time: 15:47
 */
public class FormattedPropertyColumn<T, S> extends PropertyColumn<T, S>
{
   private final Format format;

   public FormattedPropertyColumn(IModel<String> displayModel, S sortProperty, String propertyExpression, Format format)
   {
      super(displayModel, sortProperty, propertyExpression);
      this.format = format;
   }

   public FormattedPropertyColumn(IModel<String> displayModel, String propertyExpression, Format format)
   {
      super(displayModel, propertyExpression);
      this.format = format;
   }

   @Override
   public IModel<Object> getDataModel(IModel<T> rowModel)
   {
      final IModel<?> originalModel = super.getDataModel(rowModel);
      return new AbstractReadOnlyModel<Object>()
      {
         @Override
         public String getObject()
         {
            Object value = originalModel.getObject();
            return (value != null) ? format.format(value) : null;
         }
      };
   }
}
