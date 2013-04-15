package com.fm.core.cmp.newTable.column;

import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

public class DateTimeColumn<T, S> extends PropertyColumn<T, S>
{
   private static final long serialVersionUID = -8921436488230674356L;

   private transient DateTimeFormatter formatter;

   public DateTimeColumn(IModel<String> displayModel, S sortProperty, String propertyExpression,
                         DateTimeFormatter formatter)
   {
      super(displayModel, sortProperty, propertyExpression);
      this.formatter = formatter;
   }

   public DateTimeColumn(IModel<String> displayModel, String propertyExpression, DateTimeFormatter formatter)
   {
      super(displayModel, propertyExpression);
      this.formatter = formatter;
   }

   /*
    *  The first character is the date style, and the second character is the time style. Specify a character of 'S' for short style, 
    *  'M' for medium, 'L' for long, and 'F' for full. A date or time may be ommitted by specifying a style character '-'. 
    */
   public DateTimeColumn(IModel<String> displayModel, String propertyExpression, String style, Locale locale)
   {
      super(displayModel, propertyExpression);
      this.formatter = DateTimeFormat.forPattern(DateTimeFormat.patternForStyle(style, locale));
   }

   @Override
   public IModel<Object> getDataModel(IModel<T> rowModel)
   {
      final IModel<Object> original = super.getDataModel(rowModel);
      return new AbstractReadOnlyModel()
      {
         private static final long serialVersionUID = -4455890114282998964L;

         @Override
         public String getObject()
         {
            DateTime value = (DateTime) original.getObject();
            return (value != null) ? formatter.print(value) : null;
         }
      };
   }
}
