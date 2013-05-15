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
   private T selected;

   public DetailsPanel(String id, IModel<T> model)
   {
      super(id, model);
      setOutputMarkupId(true);
   }

   @Override
   protected void onConfigure()
   {
      selected = (T) getDefaultModelObject();
      setVisible(selected != null);
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
