package com.fm.core.cmp.image;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.cycle.RequestCycle;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 19.05.13
 * Time: 13:25
 * To change this template use File | Settings | File Templates.
 */
public class StaticImage extends WebComponent
{
   public StaticImage(String id, IModel model)
   {
      super(id, model);
   }

   protected void onComponentTag(ComponentTag tag)
   {
      super.onComponentTag(tag);
      String path = RequestCycle.get().getRequest().getContextPath();
      checkComponentTag(tag, "img");
      tag.put("src", path + getDefaultModelObjectAsString());
   }
}
