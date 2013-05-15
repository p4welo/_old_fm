package com.fm.core.cmp.masterDetail;

import com.fm.core.cmp.newTable.AjaxDataTable;
import com.fm.core.cmp.newTable.SelectionChangeCallback;
import com.fm.domain.IdentifiableEntity;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 18.04.13
 * Time: 19:45
 * To change this template use File | Settings | File Templates.
 */
public abstract class MasterDetailPanel<T extends IdentifiableEntity> extends Panel
{
   protected T selected;

   private boolean emptyPanelHidden = false;

   public MasterDetailPanel(String id)
   {
      this(id, false);
   }

   public MasterDetailPanel(String id, boolean emptyPanelHidden)
   {
      super(id);
      this.emptyPanelHidden = emptyPanelHidden;
      setOutputMarkupId(true);
   }

   @Override
   protected void onInitialize()
   {
      super.onInitialize();
      AjaxDataTable<T> dataTable = provideMasterTable("master");
      dataTable.setSelectionChangeCallback(new SelectionChangeCallback<T>()
      {
         @Override
         public void onSelectionChange(AjaxRequestTarget target, IModel<T> model)
         {
            selected = model.getObject();
            target.add(MasterDetailPanel.this);
         }
      });
      add(dataTable);
      IModel<T> model = new PropertyModel<T>(this, "selected");
      add(provideDetailsPanel("details", model));
      add(new EmptyDetailsPanel<T>("empty", model, emptyPanelHidden));
   }

   protected abstract DetailsPanel provideDetailsPanel(String id, IModel<T> model);

   protected abstract AjaxDataTable<T> provideMasterTable(String id);
}
