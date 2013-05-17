package com.fm.admin.pages.teamDetailsPage.cmp.tabPanel;

import com.fm.core.ajax.AjaxSelectBehavior;
import com.fm.core.cmp.masterDetail.EmptyDetailsPanel;
import com.fm.domain.Player;
import com.fm.domain.Position;
import com.fm.domain.Team;
import com.fm.service.IPlayerService;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 15.05.13
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */
public class PlayersTab extends Panel
{
   @SpringBean
   private IPlayerService playerService;

   private List<Player> playerList;

   private Player selected;

   public PlayersTab(String id, IModel<Team> model)
   {
      super(id, model);
      setOutputMarkupId(true);
      playerList = playerService.findTeamPlayers((Team) getDefaultModelObject());
   }

   @Override
   protected void onInitialize()
   {
      super.onInitialize();
      add(new ListView<Player>("players", playerList)
      {
         @Override
         protected void populateItem(final ListItem<Player> item)
         {
            Player player = item.getModelObject();
            item.add(new Label("name", new PropertyModel<String>(player, Player.FIELD_NAME)));
            item.add(new Label("surname", new PropertyModel<String>(player, Player.FIELD_SURNAME)));
            item.add(new Label("age", new PropertyModel<String>(player, Player.FIELD_AGE)));
            item.add(new Label("position",
                    new PropertyModel<String>(player, Player.FIELD_POSITION + "." + Position.FIELD_SHORT_NAME)));
            item.add(new AjaxSelectBehavior()
            {
               @Override
               protected void onEvent(AjaxRequestTarget target)
               {
                  selected = item.getModelObject();
                  target.add(PlayersTab.this);
               }
            });
            if (item.getModelObject().equals(selected))
            {
               item.add(AttributeModifier.append("class", "selectedElement"));
            }
         }
      });
      IModel model = new PropertyModel<Player>(this, "selected");
      add(new EmptyDetailsPanel<Player>("empty", model));
      add(new PlayersDetailsPanel("details", model, (IModel<Team>) getDefaultModel()));
   }

   @Override
   protected void onConfigure()
   {
      super.onConfigure();
      playerList = playerService.findTeamPlayers((Team) getDefaultModelObject());
   }
}
