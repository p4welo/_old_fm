package com.fm.core.ajax;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 15.05.13
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
public abstract class AjaxSelectBehavior extends AjaxEventBehavior
{
   public AjaxSelectBehavior()
   {
      super("onclick");
   }

   @Override
   protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
   {
      super.updateAjaxAttributes(attributes);
      attributes.setAllowDefault(true);
   }
}
