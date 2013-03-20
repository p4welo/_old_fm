package com.football.manager.server.cmp.window;

import com.football.manager.domain.League;
import com.football.manager.server.navigation.NavigateToLeagueDetailsPage;
import com.football.manager.service.ILeagueService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * User: pawel
 * Date: 06.02.13
 * Time: 22:25
 */
public class CreateNewLeagueModal extends AbstractModal
{
   @SpringBean
   private ILeagueService leagueService;

   private String leagueName;

   private boolean generateTeams;

   public CreateNewLeagueModal(String id)
   {
      super(id);
   }

   public void onConfirm(AjaxRequestTarget target)
   {
      League newLeague = new League();
      newLeague.setName(getLeagueName());
      newLeague = leagueService.save(newLeague, generateTeams);
      new NavigateToLeagueDetailsPage(newLeague).navigate();
   }

   protected void initView()
   {
      TextField nameField = new TextField<String>("nameField", new PropertyModel(
              this, "leagueName"));
      nameField.setRequired(true);
      form.add(nameField);
      CheckBox generateTeamsField = new CheckBox("generateTeamsField",
              new PropertyModel<Boolean>(this, "generateTeams"));
      form.add(generateTeamsField);
   }

   public String getLeagueName()
   {
      return leagueName;
   }

   public void setLeagueName(String leagueName)
   {
      this.leagueName = leagueName;
   }

   public boolean isGenerateTeams()
   {
      return generateTeams;
   }

   public void setGenerateTeams(boolean generateTeams)
   {
      this.generateTeams = generateTeams;
   }
}
