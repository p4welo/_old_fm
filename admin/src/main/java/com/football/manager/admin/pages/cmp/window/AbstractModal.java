package com.football.manager.admin.pages.cmp.window;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * User: pawel.radomski
 * Date: 06.02.13
 * Time: 17:39
 */
public abstract class AbstractModal extends Panel
{
   public AbstractModal(String id)
   {
      super(id);

   }

   protected abstract void onConfirm(AjaxRequestTarget target);
}