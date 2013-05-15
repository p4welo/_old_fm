package com.fm.core.cmp.masterDetail;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 15.05.13
 * Time: 20:50
 * To change this template use File | Settings | File Templates.
 */
public class EmptyDetailsPanel<T> extends Panel
{
   private boolean alwaysHidden;

   public EmptyDetailsPanel(String id, IModel<T> model)
   {
      this(id, model, false);
   }

   public EmptyDetailsPanel(String id, IModel<T> model, boolean alwaysHidden)
   {
      super(id, model);
      this.alwaysHidden = alwaysHidden;
   }

   @Override
   protected void onConfigure()
   {
      super.onConfigure();
      setVisible(!alwaysHidden && getDefaultModelObject() == null);
   }
}
