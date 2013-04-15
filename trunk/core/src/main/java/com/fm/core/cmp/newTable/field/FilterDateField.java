package com.fm.core.cmp.newTable.field;

import com.fm.core.converter.DateTimeConverter;
import org.apache.wicket.model.PropertyModel;
import org.joda.time.DateTime;

public class FilterDateField extends DateTimeTextField
{
   private static final long serialVersionUID = 1728786463561214868L;

   public FilterDateField(final String id, PropertyModel<DateTime> model)
   {
      this(id, model, false);
   }

   public FilterDateField(final String id, PropertyModel<DateTime> model, boolean endOfDay)
   {
      super(id, model, new DateTimeConverter(endOfDay));
   }
}
