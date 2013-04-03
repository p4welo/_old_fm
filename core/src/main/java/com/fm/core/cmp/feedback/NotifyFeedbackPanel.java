package com.fm.core.cmp.feedback;

import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

/**
 * User: pawel.radomski
 * Date: 02.04.13
 * Time: 14:02
 */
public class NotifyFeedbackPanel extends FeedbackPanel
{
   protected NotifyOptions infoOptions = new NotifyOptions("info", getString("info.title"));

   protected NotifyOptions warningOptions = new NotifyOptions(null, getString("warning.title"));

   protected NotifyOptions debugOptions = new NotifyOptions("info");

   protected NotifyOptions fatalOptions = new NotifyOptions("error", getString("fatal.title"));

   protected NotifyOptions errorOptions = new NotifyOptions("error", getString("error.title"));

   protected NotifyOptions successOptions = new NotifyOptions("success", getString("success.title"));

   public NotifyFeedbackPanel(String id)
   {
      this(id, null);
   }

   public NotifyFeedbackPanel(String id, IFeedbackMessageFilter filter)
   {
      super(id, filter);
      setOutputMarkupId(true);
      setEscapeModelStrings(false);
   }

   @Override
   protected Component newMessageDisplayComponent(String id, FeedbackMessage message)
   {
      final NotifyFeedbackMessage notifyFeedbackMessage = new NotifyFeedbackMessage(message)
      {
         @Override
         protected NotifyOptions getInfoOptions()
         {
            return infoOptions;
         }

         @Override
         protected NotifyOptions getWarningOptions()
         {
            return warningOptions;
         }

         @Override
         protected NotifyOptions getDebugOptions()
         {
            return debugOptions;
         }

         @Override
         protected NotifyOptions getFatalOptions()
         {
            return fatalOptions;
         }

         @Override
         protected NotifyOptions getErrorOptions()
         {
            return errorOptions;
         }

         @Override
         protected NotifyOptions getSuccessOptions()
         {
            return successOptions;
         }
      };
      final String javaScript = notifyFeedbackMessage.toJavaScript();
      final Label label = new Label(id, javaScript);
      label.setEscapeModelStrings(NotifyFeedbackPanel.this.getEscapeModelStrings());
      return label;
   }

   public void setInfoOptions(NotifyOptions infoOptions)
   {
      this.infoOptions = infoOptions;
   }

   public void setWarningOptions(NotifyOptions warningOptions)
   {
      this.warningOptions = warningOptions;
   }

   public void setDebugOptions(NotifyOptions debugOptions)
   {
      this.debugOptions = debugOptions;
   }

   public void setFatalOptions(NotifyOptions fatalOptions)
   {
      this.fatalOptions = fatalOptions;
   }

   public void setErrorOptions(NotifyOptions errorOptions)
   {
      this.errorOptions = errorOptions;
   }

   public void setSuccessOptions(NotifyOptions successOptions)
   {
      this.successOptions = successOptions;
   }
}
