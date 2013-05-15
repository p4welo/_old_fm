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

   public MasterDetailPanel(String id)
   {
      super(id);
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
      add(provideDetailsPanel("details", new PropertyModel<T>(this, "selected")));
   }

   protected abstract DetailsPanel provideDetailsPanel(String id, IModel<T> model);

   protected abstract AjaxDataTable<T> provideMasterTable(String id);
}
