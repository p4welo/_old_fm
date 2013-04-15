package com.fm.service.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class TimeUtils
{
   public static final PeriodFormatter periodFormatter = new PeriodFormatterBuilder()
           .appendYears()
           .appendSuffix(" years, ")
           .appendMonths()
           .appendSuffix(" months, ")
           .appendWeeks()
           .appendSuffix(" weeks, ")
           .appendDays()
           .appendSuffix(" days, ")
           .appendHours()
           .appendSuffix(" hours, ")
           .appendMinutes()
           .appendSuffix(" minutes, ")
           .appendSeconds()
           .appendSuffix(" seconds, ")
           .appendMillis()
           .appendSuffix(" milis")
           .printZeroNever()
           .toFormatter();

   public static final DateTimeFormatter defaultFormatter = DateTimeFormat.forPattern("dd.MM.yyyy'T'HH:mm:ssZ");

   public static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss");

   public static final String timeSpanToString(long duration)
   {
      Period period = new Period(duration);
      return periodFormatter.print(period);
   }

   public static final String print(DateTime dateTime)
   {
      return dateTime != null ? defaultFormatter.print(dateTime) : null;
   }

   public static final DateTime parse(String str)
   {
      try
      {
         if (!StringUtils.isBlank(str))
         {
            return defaultFormatter.parseDateTime(str);
         }
      }
      catch (IllegalArgumentException e)
      {
         // noop
      }
      return null;
   }

   public static final DateTime endOfHour(DateTime dateTime)
   {
      return dateTime.withMillisOfSecond(999).withSecondOfMinute(59).withMinuteOfHour(59);
   }

   public static final DateTime endOfDay(DateTime dateTime)
   {
      return endOfHour(dateTime).withHourOfDay(23);
   }
}
