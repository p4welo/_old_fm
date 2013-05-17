package com.fm.admin.pages.leagueDetailsPage.cmp.tabbedPanel;

import com.fm.admin.navigation.NavigateToTeamDetailsPage;
import com.fm.domain.MatchGame;
import com.fm.domain.PlayerStatTypeEnum;
import com.fm.domain.PlayerStats;
import com.fm.domain.filter.SortFilterChain;
import com.fm.domain.filter.StatsFilter;
import com.fm.service.IPlayerStatsService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pawel.radomski
 * Date: 15.05.13
 * Time: 17:41
 */
public class MatchDetailsPanel extends Panel
{
   @SpringBean
   private IPlayerStatsService playerStatsService;

   private MatchGame selected;

   private List<PlayerStats> hostStrikers = new ArrayList<PlayerStats>();

   private List<PlayerStats> hostYellowCards = new ArrayList<PlayerStats>();

   private List<PlayerStats> hostRedCards = new ArrayList<PlayerStats>();

   private List<PlayerStats> guestStrikers = new ArrayList<PlayerStats>();

   private List<PlayerStats> guestYellowCards = new ArrayList<PlayerStats>();

   private List<PlayerStats> guestRedCards = new ArrayList<PlayerStats>();

   private StatsFilter filter = new StatsFilter();

   public MatchDetailsPanel(String id, IModel<MatchGame> model)
   {
      super(id, model);
      setOutputMarkupId(true);
   }

   @Override
   protected void onConfigure()
   {
      selected = (MatchGame) getDefaultModelObject();
      setVisible(selected != null);

      if (selected != null)
      {
         filter = new StatsFilter();
         filter.setMatchSid(selected.getSid());

         filter.setType(PlayerStatTypeEnum.GOAL);
         filter.setTeamSid(selected.getHostSid());
         hostStrikers = playerStatsService.findBySearchParams(filter, new SortFilterChain(), 0, 20);

         filter.setType(PlayerStatTypeEnum.YELLOW_CARD);
         hostYellowCards = playerStatsService.findBySearchParams(filter, new SortFilterChain(), 0, 20);

         filter.setType(PlayerStatTypeEnum.RED_CARD);
         hostRedCards = playerStatsService.findBySearchParams(filter, new SortFilterChain(), 0, 20);

         filter.setType(PlayerStatTypeEnum.GOAL);
         filter.setTeamSid(selected.getGuestSid());
         guestStrikers = playerStatsService.findBySearchParams(filter, new SortFilterChain(), 0, 20);

         filter.setType(PlayerStatTypeEnum.YELLOW_CARD);
         guestYellowCards = playerStatsService.findBySearchParams(filter, new SortFilterChain(), 0, 20);

         filter.setType(PlayerStatTypeEnum.RED_CARD);
         guestRedCards = playerStatsService.findBySearchParams(filter, new SortFilterChain(), 0, 20);
      }

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
               new NavigateToTeamDetailsPage(selected.getGuestSid()).navigate();
            }
         }
      };
      guest.add(new Label("guest", new PropertyModel<String>(this, "selected." + MatchGame.FIELD_GUEST_NAME)));
      add(guest);
      add(new Label("guestGoals", new PropertyModel<String>(this, "selected." + MatchGame.FIELD_GUEST_SCORES)));

      add(new ListView<PlayerStats>("hostStrikers", new PropertyModel<List<PlayerStats>>(this, "hostStrikers"))
      {
         @Override
         protected void populateItem(ListItem<PlayerStats> item)
         {
            PlayerStats stats = item.getModelObject();
            item.add(new Label("name", PropertyModel.of(stats, PlayerStats.FIELD_PLAYER_NAME)));
            item.add(new Label("surname", PropertyModel.of(stats, PlayerStats.FIELD_PLAYER_SURNAME)));
         }
      });

      add(new ListView<PlayerStats>("hostYellowCards", new PropertyModel<List<PlayerStats>>(this, "hostYellowCards"))
      {
         @Override
         protected void populateItem(ListItem<PlayerStats> item)
         {
            PlayerStats stats = item.getModelObject();
            item.add(new Label("name", PropertyModel.of(stats, PlayerStats.FIELD_PLAYER_NAME)));
            item.add(new Label("surname", PropertyModel.of(stats, PlayerStats.FIELD_PLAYER_SURNAME)));
         }
      });

      add(new ListView<PlayerStats>("hostRedCards", new PropertyModel<List<PlayerStats>>(this, "hostRedCards"))
      {
         @Override
         protected void populateItem(ListItem<PlayerStats> item)
         {
            PlayerStats stats = item.getModelObject();
            item.add(new Label("name", PropertyModel.of(stats, PlayerStats.FIELD_PLAYER_NAME)));
            item.add(new Label("surname", PropertyModel.of(stats, PlayerStats.FIELD_PLAYER_SURNAME)));
         }
      });

      add(new ListView<PlayerStats>("guestStrikers", new PropertyModel<List<PlayerStats>>(this, "guestStrikers"))
      {
         @Override
         protected void populateItem(ListItem<PlayerStats> item)
         {
            PlayerStats stats = item.getModelObject();
            item.add(new Label("name", PropertyModel.of(stats, PlayerStats.FIELD_PLAYER_NAME)));
            item.add(new Label("surname", PropertyModel.of(stats, PlayerStats.FIELD_PLAYER_SURNAME)));
         }
      });

      add(new ListView<PlayerStats>("guestYellowCards", new PropertyModel<List<PlayerStats>>(this, "guestYellowCards"))
      {
         @Override
         protected void populateItem(ListItem<PlayerStats> item)
         {
            PlayerStats stats = item.getModelObject();
            item.add(new Label("name", PropertyModel.of(stats, PlayerStats.FIELD_PLAYER_NAME)));
            item.add(new Label("surname", PropertyModel.of(stats, PlayerStats.FIELD_PLAYER_SURNAME)));
         }
      });

      add(new ListView<PlayerStats>("guestRedCards", new PropertyModel<List<PlayerStats>>(this, "guestRedCards"))
      {
         @Override
         protected void populateItem(ListItem<PlayerStats> item)
         {
            PlayerStats stats = item.getModelObject();
            item.add(new Label("name", PropertyModel.of(stats, PlayerStats.FIELD_PLAYER_NAME)));
            item.add(new Label("surname", PropertyModel.of(stats, PlayerStats.FIELD_PLAYER_SURNAME)));
         }
      });
   }
}
