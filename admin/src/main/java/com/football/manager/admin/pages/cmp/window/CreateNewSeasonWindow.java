package com.football.manager.admin.pages.cmp.window;

import com.football.manager.domain.League;
import com.football.manager.domain.Team;
import com.football.manager.service.ITeamService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pawel
 * Date: 03.02.13
 * Time: 22:56
 */
public class CreateNewSeasonWindow extends AbstractWindow
{
   @SpringBean
   private ITeamService teamService;

   private ArrayList<Team> selectedTeams = new ArrayList<Team>();

   private List<Team> teams;

   private League selectedLeague;

   public CreateNewSeasonWindow(String id, League selectedLeague)
   {
      super(id, "create.new.season.title");
      setOutputMarkupId(true);
      this.selectedLeague = selectedLeague;
   }

   @Override
   public void show(AjaxRequestTarget target)
   {
      teams = teamService.findTeamsFromLeague(selectedLeague);
      super.show(target);
   }

   @Override
   protected Panel getWindowPanel(String id)
   {
      return new CreateNewSeasonPanel(id);
   }

   @Override
   protected void onConfirm(AjaxRequestTarget target)
   {
   }

   @Override
   protected void onCancel(AjaxRequestTarget target)
   {
   }

   public List<Team> getSelectedTeams()
   {
      return selectedTeams;
   }

   public void setSelectedTeams(ArrayList<Team> selectedTeams)
   {
      this.selectedTeams = selectedTeams;
   }

   public List<Team> getTeams()
   {
      return teams;
   }

   public void setTeams(List<Team> teams)
   {
      this.teams = teams;
   }

   class CreateNewSeasonPanel extends Panel
   {

      public CreateNewSeasonPanel(String id)
      {
         super(id);
         initView();
      }

      private void initView()
      {
         Form form = new Form("form");
         CheckBoxMultipleChoice<Team> teams = new CheckBoxMultipleChoice<Team>("teams",
                 new Model(selectedTeams), new PropertyModel(
                 CreateNewSeasonWindow.this, "teams"), new ChoiceRenderer<Team>(Team.FIELD_NAME)
         );
         teams.setOutputMarkupId(true);

         form.add(teams);
         FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
         feedbackPanel.setOutputMarkupId(true);
         form.add(feedbackPanel);
         form.add(createSaveButton(form, feedbackPanel));
         form.add(createCancelButton(form));

         add(form);
      }
   }
}
