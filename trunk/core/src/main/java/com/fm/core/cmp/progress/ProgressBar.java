package com.fm.core.cmp.progress;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.time.Duration;

/**
 * User: pawel.radomski
 * Date: 20.05.13
 * Time: 15:38
 */
public class ProgressBar extends WebComponent
{
   private AjaxSelfUpdatingTimerBehavior updatingBehavior;

   public ProgressBar(String id, IModel<?> model)
   {
      super(id, model);
      add(updatingBehavior = new AjaxSelfUpdatingTimerBehavior(Duration.seconds(1)));
   }

   @Override
   protected void onComponentTag(ComponentTag tag)
   {
      Integer value = (Integer) getDefaultModelObject();
//      if (value >= 100)
//      {
//         updatingBehavior.stop(RC);
//      }
      tag.getAttributes().put("style", "width: " + value + "%");
      super.onComponentTag(tag);
   }
}
