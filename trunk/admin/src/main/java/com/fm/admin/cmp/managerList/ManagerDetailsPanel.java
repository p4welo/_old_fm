package com.fm.admin.cmp.managerList;

import com.fm.domain.Manager;
import com.fm.domain.Team;
import com.fm.domain.User;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * User: pawel.radomski
 * Date: 17.04.13
 * Time: 12:30
 */
public class ManagerDetailsPanel extends Panel
{
   private final IModel<Manager> model;

   private WebMarkupContainer main;

   private Manager selected;

   public ManagerDetailsPanel(String id, IModel<Manager> model)
   {
      super(id, model);
      this.model = model;

      initView();
   }

   private void initView()
   {
      main = new WebMarkupContainer("main")
      {
         @Override
         protected void onConfigure()
         {
            setVisible(selected != null);
         }
      };
      main.setOutputMarkupId(true);
      main.add(new Label("name", new PropertyModel(this, "selected." + Manager.FIELD_NAME)));
      main.add(new Label("surname", new PropertyModel(this, "selected." + Manager.FIELD_SURNAME)));
      main.add(new Label("team", new PropertyModel(this, "selected." + Manager.FIELD_TEAM + "." + Team.FIELD_NAME)));
      main.add(new Label("email",
              new PropertyModel(this, "selected." + Manager.FIELD_USER + "." + User.FIELD_EMAIL)));
      add(main);
   }

   @Override
   protected void onBeforeRender()
   {
      selected = model.getObject();
      super.onBeforeRender();
   }
}
