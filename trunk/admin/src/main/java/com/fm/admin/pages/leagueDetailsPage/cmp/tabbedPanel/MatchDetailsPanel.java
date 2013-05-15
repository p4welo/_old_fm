package com.fm.admin.pages.leagueDetailsPage.cmp.tabbedPanel;

import com.fm.admin.navigation.NavigateToTeamDetailsPage;
import com.fm.domain.MatchGame;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * User: pawel.radomski
 * Date: 15.05.13
 * Time: 17:41
 */
public class MatchDetailsPanel extends Panel
{
   private MatchGame selected;

   public MatchDetailsPanel(String id, IModel<MatchGame> model)
   {
      super(id, model);
      setOutputMarkupId(true);
   }

   @Override
   protected void onConfigure()
   {
      selected = (MatchGame) getDefaultModelObject();
      super.onConfigure();
   }

   @Override
   protected void onInitialize()
   {
      super.onInitialize();
      AjaxLink host = new AjaxLink("hostLink")
      {
         @Override
         public void onClick(AjaxRequestTarget target)
         {
            if (selected != null)
            {
               new NavigateToTeamDetailsPage(selected.getHostSid()).navigate();
            }
         }
      };
      host.add(new Label("host", new PropertyModel<String>(this, "selected." + MatchGame.FIELD_HOST_NAME)));
      add(host);
      add(new Label("hostGoals", new PropertyModel<String>(this, "selected." + MatchGame.FIELD_HOST_SCORES)));

      AjaxLink guest = new AjaxLink("guestLink")
      {
         @Override
         public void onClick(AjaxRequestTarget target)
         {
            if (selected != null)
            {
               new NavigateToTeamDetailsPage(selected.getHostSid()).navigate();
            }
         }
      };
      guest.add(new Label("guest", new PropertyModel<String>(this, "selected." + MatchGame.FIELD_GUEST_NAME)));
      add(guest);
      add(new Label("guestGoals", new PropertyModel<String>(this, "selected." + MatchGame.FIELD_GUEST_SCORES)));
   }
}
