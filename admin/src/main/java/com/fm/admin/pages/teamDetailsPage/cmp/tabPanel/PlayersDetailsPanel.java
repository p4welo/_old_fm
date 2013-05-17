package com.fm.admin.pages.teamDetailsPage.cmp.tabPanel;

import com.fm.core.cmp.label.ColorValueLabel;
import com.fm.domain.Player;
import com.fm.domain.PlayerStatTypeEnum;
import com.fm.domain.Position;
import com.fm.domain.Team;
import com.fm.domain.filter.StatsFilter;
import com.fm.service.IPlayerStatsService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 15.05.13
 * Time: 22:16
 * To change this template use File | Settings | File Templates.
 */
public class PlayersDetailsPanel extends Panel
{
   @SpringBean
   private IPlayerStatsService playerStatsService;

   private Player player;

   private long goalCount;

   private long yellowCardsCount;

   private long redCardsCount;

   private IModel<Team> teamModel;

   public PlayersDetailsPanel(String id, IModel<Player> model, IModel<Team> teamModel)
   {
      super(id, model);
      this.teamModel = teamModel;
   }

   @Override
   protected void onInitialize()
   {
      super.onInitialize();
      add(new Label("name", PropertyModel.of(this, "player." + Player.FIELD_NAME)));
      add(new Label("surname", PropertyModel.of(this, "player." + Player.FIELD_SURNAME)));
      add(new Label("age", PropertyModel.of(this, "player." + Player.FIELD_AGE)));
      add(new Label("potential", PropertyModel.of(this, "player." + Player.FIELD_POTENTIAL)));
      add(new Label("position",
              PropertyModel.of(this, "player." + Player.FIELD_POSITION + "." + Position.FIELD_FULL_NAME)));

      add(new ColorValueLabel("speed", PropertyModel.of(this, "player." + Player.FIELD_SPEED), 20));
      add(new ColorValueLabel("stamina", PropertyModel.of(this, "player." + Player.FIELD_STAMINA), 20));
      add(new ColorValueLabel("crossing", PropertyModel.of(this, "player." + Player.FIELD_CROSSING), 20));
      add(new ColorValueLabel("passing", PropertyModel.of(this, "player." + Player.FIELD_PASSING), 20));
      add(new ColorValueLabel("heading", PropertyModel.of(this, "player." + Player.FIELD_HEADING), 20));
      add(new ColorValueLabel("marking", PropertyModel.of(this, "player." + Player.FIELD_MARKING), 20));
      add(new ColorValueLabel("shots", PropertyModel.of(this, "player." + Player.FIELD_SHOTS), 20));
      add(new ColorValueLabel("tackling", PropertyModel.of(this, "player." + Player.FIELD_TACKLING), 20));
      add(new ColorValueLabel("dribbling", PropertyModel.of(this, "player." + Player.FIELD_DRIBBLING), 20));
      add(new ColorValueLabel("goalkeeping", PropertyModel.of(this, "player." + Player.FIELD_GOALKEEPING), 20));

      add(new Label("goalCount", PropertyModel.of(this, "goalCount")));
      add(new Label("yellowCardsCount", PropertyModel.of(this, "yellowCardsCount")));
      add(new Label("redCardsCount", PropertyModel.of(this, "redCardsCount")));
   }

   @Override
   protected void onConfigure()
   {
      super.onConfigure();
      player = (Player) getDefaultModelObject();
      if (player != null)
      {
         StatsFilter filter = new StatsFilter();
         filter.setPlayerSid(player.getSid());
         filter.setType(PlayerStatTypeEnum.GOAL);
         goalCount = playerStatsService.countBySearchParams(filter);
         filter.setType(PlayerStatTypeEnum.YELLOW_CARD);
         yellowCardsCount = playerStatsService.countBySearchParams(filter);
         filter.setType(PlayerStatTypeEnum.RED_CARD);
         redCardsCount = playerStatsService.countBySearchParams(filter);
      }
      setVisible(player != null);
   }
}
