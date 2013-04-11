package com.fm.admin.cmp.window;

import com.fm.core.cmp.web.BootstrapCheckBoxPanel;
import com.fm.core.cmp.web.BootstrapTextFieldPanel;
import com.fm.core.cmp.window.AbstractWindow;
import com.fm.domain.League;
import com.fm.domain.Team;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.04.13
 * Time: 23:42
 * To change this template use File | Settings | File Templates.
 */
public class NewTeamWindow extends AbstractWindow
{
   private League league;

   private Team team;

   private Boolean generatePlayers;

   public NewTeamWindow(String id, String header, League league)
   {
      super(id, header);
      this.league = league;
      resetState();
      initView();
   }

   private void initView()
   {
      BootstrapTextFieldPanel name = new BootstrapTextFieldPanel("name",
              new PropertyModel(this, "team." + Team.FIELD_NAME), "span9");
      name.setValidation();
      form.add(name);
      BootstrapTextFieldPanel account = new BootstrapTextFieldPanel("account",
              new PropertyModel(this, "team." + Team.FIELD_ACCOUNT), "span9");
      account.setValidation();
      form.add(account);
      BootstrapCheckBoxPanel checkBox = new BootstrapCheckBoxPanel("generatePlayers",
              new PropertyModel<Boolean>(this, "generatePlayers"));
      form.add(checkBox);
   }

   public void resetState()
   {
      team = new Team();
      team.setLeague(league);
      generatePlayers = Boolean.FALSE;
   }

   @Override
   public void onSubmit(AjaxRequestTarget target, Form<?> form)
   {
   }

   @Override
   public void onError(AjaxRequestTarget target, Form<?> form)
   {
   }

   public Team getTeam()
   {
      return team;
   }

   public Boolean getGeneratePlayers()
   {
      return generatePlayers;
   }
}
