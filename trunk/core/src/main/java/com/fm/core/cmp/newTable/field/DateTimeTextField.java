package com.fm.core.cmp.newTable.field;

import com.fm.core.converter.DateTimeConverter;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.AbstractTextComponent.ITextFormatProvider;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.lang.Args;
import org.joda.time.DateTime;

public class DateTimeTextField extends TextField<DateTime> implements ITextFormatProvider
{
   private static final long serialVersionUID = 8220938927283216227L;

   private final DateTimeConverter converter;

   public DateTimeTextField(String id, IModel<DateTime> model, DateTimeConverter converter)
   {
      super(id, model, DateTime.class);

      Args.notNull(converter, "converter");
      this.converter = converter;

//      DatePicker datePicker = new BootstrapDatePicker();
//      datePicker.setShowOnFieldClick(true);
//      datePicker.setAutoHide(true);
//      add(datePicker);
   }

   public DateTimeTextField(String id, DateTimeConverter converter)
   {
      this(id, null, converter);
   }

   @SuppressWarnings("unchecked")
   @Override
   public <C> IConverter<C> getConverter(Class<C> clazz)
   {
      if (DateTime.class.isAssignableFrom(clazz))
      {
         return (IConverter<C>) converter;
      }
      else
      {
         return super.getConverter(clazz);
      }
   }

   @Override
   public final String getTextFormat()
   {
      return converter.getDatePattern(getLocale());
   }

   public void addPlaceholder(String message)
   {
      add(new AttributeModifier("placeholder", message));
   }
}
