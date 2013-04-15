package com.fm.core.converter;

import com.fm.service.util.TimeUtils;
import org.apache.wicket.Session;
import org.apache.wicket.core.request.ClientInfo;
import org.apache.wicket.protocol.http.request.WebClientInfo;
import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.converter.AbstractConverter;
import org.apache.wicket.util.string.Strings;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;
import java.util.TimeZone;

public class DateTimeConverter extends AbstractConverter<DateTime>
{
   private static final long serialVersionUID = 5195535587385387778L;

   private final String dateStyle;

   private final boolean endOfDay;

   private final boolean applyTimeZoneDifference = true;

   public DateTimeConverter(boolean endOfDay)
   {
      this("S-", endOfDay);
   }

   public DateTimeConverter(String dateStyle, boolean endOfDay)
   {
      this.endOfDay = endOfDay;
      if (dateStyle == null)
      {
         throw new IllegalArgumentException("dateStyle must be not null");
      }
      this.dateStyle = dateStyle;
   }

   @Override
   public DateTime convertToObject(String value, Locale locale)
   {
      if (Strings.isEmpty(value))
      {
         return null;
      }

      DateTimeFormatter format = getFormat(locale);
      if (format == null)
      {
         throw new IllegalStateException("format must be not null");
      }

      if (applyTimeZoneDifference)
      {
         TimeZone zone = getClientTimeZone();
         DateTime dateTime;

         // set time zone for client
         format = format.withZone(getTimeZone());

         try
         {
            // parse date retaining the time of the submission
            dateTime = format.parseDateTime(value);
         }
         catch (RuntimeException e)
         {
            throw newConversionException(e, locale);
         }
         // apply the server time zone to the parsed value
         if (zone != null)
         {
            dateTime = dateTime.withZoneRetainFields(DateTimeZone.forTimeZone(zone));
         }

         return endOfDay ? TimeUtils.endOfDay(dateTime) : dateTime;
      }
      else
      {
         try
         {
            DateTime date = format.parseDateTime(value);
            return date;
         }
         catch (RuntimeException e)
         {
            throw newConversionException(e, locale);
         }
      }
   }

   private ConversionException newConversionException(RuntimeException cause, Locale locale)
   {
      return new ConversionException(cause).setVariable("format", getDatePattern(locale));
   }

   protected DateTimeZone getTimeZone()
   {
      return DateTimeZone.getDefault();
   }

   protected TimeZone getClientTimeZone()
   {
      ClientInfo info = Session.get().getClientInfo();
      if (info instanceof WebClientInfo)
      {
         return ((WebClientInfo) info).getProperties().getTimeZone();
      }
      return null;
   }

   @Override
   protected Class<DateTime> getTargetType()
   {
      return DateTime.class;
   }

   public final String getDatePattern(Locale locale)
   {
      return DateTimeFormat.patternForStyle(dateStyle, locale);
   }

   public DateTimeFormatter getFormat(Locale locale)
   {
      return DateTimeFormat.forPattern(getDatePattern(locale)).withLocale(locale).withPivotYear(2000);
   }

   @Override
   public String convertToString(DateTime value, Locale locale)
   {
      DateTimeFormatter format = getFormat(locale);
      if (format == null)
      {
         throw new IllegalStateException("format must be not null");
      }

      return value != null ? format.print(value) : null;
   }
}
