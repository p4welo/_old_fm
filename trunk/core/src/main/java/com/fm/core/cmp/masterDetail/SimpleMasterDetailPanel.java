package com.fm.core.cmp.masterDetail;

import com.fm.domain.IdentifiableEntity;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 15.05.13
 * Time: 21:15
 * To change this template use File | Settings | File Templates.
 */
public abstract class SimpleMasterDetailPanel<T extends IdentifiableEntity> extends Panel
{
   protected T selected;

   public SimpleMasterDetailPanel(String id)
   {
      super(id);
   }

   @Override
   protected void onInitialize()
   {
      super.onInitialize();
      IModel<T> model = new PropertyModel<T>(this, "selected");
      add(provideMasterPanel("master", model));
      add(provideDetailsPanel("details", model));
      add(new EmptyDetailsPanel<T>("empty", model));
   }

   protected abstract Panel provideMasterPanel(String id, IModel<T> model);

   protected abstract DetailsPanel<T> provideDetailsPanel(String id, IModel<T> model);
}
