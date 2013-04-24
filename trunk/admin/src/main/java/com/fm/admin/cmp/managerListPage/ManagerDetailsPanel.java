package com.fm.admin.cmp.managerListPage;

import com.fm.core.cmp.masterDetail.DetailsPanel;
import com.fm.core.cmp.notify.Notification;
import com.fm.domain.Manager;
import com.fm.domain.Team;
import com.fm.domain.User;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * User: pawel.radomski
 * Date: 17.04.13
 * Time: 12:30
 */
public class ManagerDetailsPanel extends DetailsPanel<Manager>
{
   public ManagerDetailsPanel(String id, IModel<Manager> model)
   {
      super(id, model);
      initView();
   }

   private void initView()
   {
      add(new Label("name", new PropertyModel(this, "selected." + Manager.FIELD_NAME)));
      add(new Label("surname", new PropertyModel(this, "selected." + Manager.FIELD_SURNAME)));
      add(new Label("team", new PropertyModel(this, "selected." + Manager.FIELD_TEAM + "." + Team.FIELD_NAME)));
      add(new Label("email",
              new PropertyModel(this, "selected." + Manager.FIELD_USER + "." + User.FIELD_EMAIL)));

      add(new AjaxLink<Void>("accountActivation")
      {
         @Override
         public void onClick(AjaxRequestTarget target)
         {

            Notification.success(getString("account.activated"), target);
            target.add(ManagerDetailsPanel.this);
         }
      });
   }
}
