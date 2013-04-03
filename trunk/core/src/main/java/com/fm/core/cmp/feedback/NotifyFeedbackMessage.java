package com.fm.core.cmp.feedback;

import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.util.io.IClusterable;

/**
 * User: pawel.radomski
 * Date: 02.04.13
 * Time: 14:04
 */
public class NotifyFeedbackMessage implements IClusterable
{
   private final String message;

   private final NotifyOptions options;

   public NotifyFeedbackMessage(final FeedbackMessage feedbackMessage)
   {
      message = feedbackMessage.getMessage().toString();

      switch (feedbackMessage.getLevel())
      {
         case FeedbackMessage.ERROR:
            options = getErrorOptions();
            break;

         case FeedbackMessage.FATAL:
            options = getFatalOptions();
            break;

         case FeedbackMessage.DEBUG:
            options = getDebugOptions();
            break;

         case FeedbackMessage.WARNING:
            options = getWarningOptions();
            break;

         case FeedbackMessage.INFO:
            options = getInfoOptions();
            break;

         case FeedbackMessage.SUCCESS:
            options = getSuccessOptions();
            break;

         default:
            options = new NotifyOptions();
      }
   }

   protected NotifyOptions getSuccessOptions()
   {
      return new NotifyOptions();
   }

   protected NotifyOptions getInfoOptions()
   {
      return new NotifyOptions();
   }

   protected NotifyOptions getWarningOptions()
   {
      return new NotifyOptions();
   }

   protected NotifyOptions getDebugOptions()
   {
      return new NotifyOptions();
   }

   protected NotifyOptions getFatalOptions()
   {
      return new NotifyOptions();
   }

   protected NotifyOptions getErrorOptions()
   {
      return new NotifyOptions();
   }

   public String toJavaScript()
   {

      final StringBuilder javaScript = new StringBuilder();
      javaScript.append("$.pnotify({text: '");
      javaScript.append(message);
      javaScript.append("'");
      if (options != null)
      {
         javaScript.append(", ");
         javaScript.append(options.toString());
      }
      javaScript.append("});");

      return javaScript.toString();
   }
}
