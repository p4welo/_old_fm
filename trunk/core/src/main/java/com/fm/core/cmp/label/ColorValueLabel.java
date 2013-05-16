package com.fm.core.cmp.label;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import java.util.Arrays;
import java.util.List;

/**
 * User: pawel.radomski
 * Date: 16.05.13
 * Time: 17:10
 */
public class ColorValueLabel extends Label
{

   private int MAX;

   public ColorValueLabel(String id, IModel<?> model, int MAX)
   {
      super(id, model);
      this.MAX = MAX;
   }

   @Override
   protected void onComponentTag(ComponentTag tag)
   {
      String cssClass = "badge";
      tag.getAttributes().put("class", cssClass);
      String background = "background-color: " + countColor((Integer) getDefaultModelObject());
      tag.getAttributes().put("style", background);
      super.onComponentTag(tag);
   }

   private String countColor(Integer value)
   {
      List<String> colors = Arrays.asList(
              "#990000",
              "#cc0000",
              "#ff0000",
              "#ff3300",
              "#ff6600",
              "#ff9900",
              "#ffcc00",
              "#cccc00",
              "#99cc00",
              "#66cc00",
              "#33cc00",
              "#00cc00",
              "#009900",
              "#006600");

      return colors.get(value * (colors.size() - 1) / MAX);
   }
}
