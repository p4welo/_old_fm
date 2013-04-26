package com.fm.admin.cmp.leagueSeasonsPage.tabbedPanel;

import com.fm.domain.*;
import com.fm.service.IMatchGameService;
import com.fm.service.IMatchGameTeamRelationService;
import com.fm.service.ISeasonService;
import com.fm.service.ITeamRecordService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * User: pawel.radomski
 * Date: 26.04.13
 * Time: 16:14
 */
public class SeasonMatchesTab extends Panel
{
   @SpringBean
   private ISeasonService seasonService;

   @SpringBean
   private ITeamRecordService teamRecordService;

   @SpringBean
   private IMatchGameService matchGameService;

   @SpringBean
   private IMatchGameTeamRelationService matchGameTeamRelationService;

   private League league;

   private Season season;

   private List<Integer> roundList;

   private Integer round;

   private List<MatchGame> matchGames;

   public SeasonMatchesTab(String id, IModel<League> model)
   {
      super(id, model);

      league = model.getObject();
      season = seasonService.getActiveSeason(league);
      if (season != null)
      {
         roundList = teamRecordService.getPlayedRoundListBySeason(season);
         if (!CollectionUtils.isEmpty(roundList))
         {
            round = roundList.get(roundList.size() - 1);
            matchGames = matchGameService.getByRoundInSeason(season, round);
         }
      }

      initView();
   }

   private void initView()
   {
      add(new ListView<MatchGame>("matches", matchGames)
      {
         @Override
         protected void populateItem(ListItem<MatchGame> item)
         {
            MatchGame game = item.getModelObject();
            List<MatchGameTeamRelation> relations = matchGameTeamRelationService.getByGame(game);
            Team hostTeam = new Team();
            Team guestTeam = new Team();
            for (MatchGameTeamRelation relation : relations)
            {
               if (relation.getHostTeam())
               {
                  hostTeam = relation.getTeam();
               }
               else
               {
                  guestTeam = relation.getTeam();
               }
            }

            item.add(new Label("host", new PropertyModel(hostTeam, Team.FIELD_NAME)));
            item.add(new Label("guest", new PropertyModel(guestTeam, Team.FIELD_NAME)));
            item.add(new Label("hostScore", new PropertyModel(game, MatchGame.FIELD_HOST_SCORES)));
            item.add(new Label("guestScore", new PropertyModel(game, MatchGame.FIELD_GUEST_SCORES)));
         }
      });
   }
}