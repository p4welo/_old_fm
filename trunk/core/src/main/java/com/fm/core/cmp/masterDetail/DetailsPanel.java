package com.fm.core.cmp.masterDetail;

import com.fm.domain.IdentifiableEntity;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 18.04.13
 * Time: 20:03
 * To change this template use File | Settings | File Templates.
 */
public abstract class DetailsPanel<T extends IdentifiableEntity> extends Panel
{
   private IModel<T> model;

   private T selected;

   public DetailsPanel(String id, IModel<T> model)
   {
      super(id, model);
      setOutputMarkupId(true);
      this.model = model;
   }

   @Override
   protected void onConfigure()
   {
      setVisible(model.getObject() != null);
   }

   @Override
   protected void onBeforeRender()
   {
      selected = model.getObject();
      super.onBeforeRender();
   }

   public T getSelected()
   {
      return selected;
   }

   public void setSelected(T selected)
   {
      this.selected = selected;
   }
}
