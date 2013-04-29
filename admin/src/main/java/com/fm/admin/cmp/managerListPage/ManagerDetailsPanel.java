package com.fm.admin.cmp.managerListPage;

import com.fm.admin.cmp.managerListPage.tabbedPanel.AccountTab;
import com.fm.admin.cmp.managerListPage.tabbedPanel.AuthorityTab;
import com.fm.admin.cmp.managerListPage.tabbedPanel.TeamTab;
import com.fm.core.cmp.masterDetail.DetailsPanel;
import com.fm.core.cmp.tabbedPanel.BootstrapTabbedPanel;
import com.fm.domain.Manager;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;

import java.util.ArrayList;
import java.util.List;

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
      List<ITab> tabs = new ArrayList<ITab>();
      tabs.add(new AbstractTab(new ResourceModel("account.tab"))
      {
         @Override
         public WebMarkupContainer getPanel(String panelId)
         {
            return new AccountTab(panelId, new PropertyModel<Manager>(this, "selected"));
         }
      });
      tabs.add(new AbstractTab(new ResourceModel("team.tab"))
      {
         @Override
         public WebMarkupContainer getPanel(String panelId)
         {
            return new TeamTab(panelId, new PropertyModel<Manager>(this, "selected"));
         }
      });
      tabs.add(new AbstractTab(new ResourceModel("authorities.tab"))
      {
         @Override
         public WebMarkupContainer getPanel(String panelId)
         {
            return new AuthorityTab(panelId, new PropertyModel<Manager>(this, "selected"));
         }
      });
      add(new BootstrapTabbedPanel("tab", tabs));

//      add(new Label("name", new PropertyModel(this, "selected." + Manager.FIELD_NAME)));
//      add(new Label("surname", new PropertyModel(this, "selected." + Manager.FIELD_SURNAME)));
//      add(new Label("team", new PropertyModel(this, "selected." + Manager.FIELD_TEAM + "." + Team.FIELD_NAME)));
//      add(new Label("email",
//              new PropertyModel(this, "selected." + Manager.FIELD_USER + "." + User.FIELD_EMAIL)));
//
//      add(new AjaxLink<Void>("accountActivation")
//      {
//         @Override
//         public void onClick(AjaxRequestTarget target)
//         {
//
//            Notification.success(getString("account.activated"));
//            target.add(ManagerDetailsPanel.this);
//         }
//      });
   }
}
