package com.fm.admin.pages.leagueDetailsPage.cmp.tabbedPanel;

import com.fm.domain.League;
import com.fm.domain.MatchGame;
import com.fm.domain.Season;
import com.fm.service.IMatchGameService;
import com.fm.service.ISeasonService;
import com.fm.service.ITeamRecordService;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
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
public class MatchesTab extends Panel
{
   @SpringBean
   private ISeasonService seasonService;

   @SpringBean
   private ITeamRecordService teamRecordService;

   @SpringBean
   private IMatchGameService matchGameService;

   private League league;

   private Season season;

   private List<Integer> roundList;

   private Integer round;

   private List<MatchGame> matchGames;

   private MatchGame selected;

   public MatchesTab(String id, IModel<League> model)
   {
      super(id, model);
      setOutputMarkupId(true);
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
   }

   @Override
   protected void onInitialize()
   {
      super.onInitialize();
      DropDownChoice dropDownChoice = new DropDownChoice<Integer>("round", new PropertyModel<Integer>(this, "round"),
              roundList);
      dropDownChoice.add(new OnChangeAjaxBehavior()
      {
         @Override
         protected void onUpdate(AjaxRequestTarget target)
         {
            target.add(MatchesTab.this);
         }
      });
      add(dropDownChoice);

      final MatchDetailsPanel matchDetailsPanel = new MatchDetailsPanel("details",
              new PropertyModel<MatchGame>(this, "selected"));
      add(matchDetailsPanel);
      add(new ListView<MatchGame>("matches", new PropertyModel<List<MatchGame>>(this, "matchGames"))
      {
         @Override
         protected void onConfigure()
         {
            super.onConfigure();
            matchGames = matchGameService.getByRoundInSeason(season, round);
         }

         @Override
         protected void populateItem(final ListItem<MatchGame> item)
         {
            MatchGame game = item.getModelObject();

            item.add(new Label("host", new PropertyModel(game, MatchGame.FIELD_HOST_NAME)));
            item.add(new Label("guest", new PropertyModel(game, MatchGame.FIELD_GUEST_NAME)));
            item.add(new Label("hostScore", new PropertyModel(game, MatchGame.FIELD_HOST_SCORES)));
            item.add(new Label("guestScore", new PropertyModel(game, MatchGame.FIELD_GUEST_SCORES)));

            item.add(new AjaxEventBehavior("onclick")
            {
               private static final long serialVersionUID = 7672021482216074145L;

               @Override
               protected void onEvent(AjaxRequestTarget target)
               {
                  selected = item.getModelObject();
                  target.add(matchDetailsPanel);
               }

               @Override
               protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
               {
                  super.updateAjaxAttributes(attributes);
                  attributes.setAllowDefault(true);
               }
            });
            if (item.getModelObject().equals(selected))
            {
               item.add(AttributeModifier.append("class", "selectedElement"));
            }
         }
      });
   }
}