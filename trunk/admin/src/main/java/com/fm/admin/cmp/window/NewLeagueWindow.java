package com.fm.admin.cmp.window;

import com.fm.core.cmp.web.BootstrapCheckBoxPanel;
import com.fm.core.cmp.web.BootstrapTextFieldPanel;
import com.fm.core.cmp.window.AbstractWindow;
import com.fm.domain.League;
import com.fm.service.ILeagueService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 06.04.13
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 */
public class NewLeagueWindow extends AbstractWindow
{
   @SpringBean
   private ILeagueService leagueService;

   private League league;

   private Boolean generateTeams;

   public NewLeagueWindow(String id, String header)
   {
      super(id, header);
      resetState();
      initView();
   }

   private void initView()
   {
      BootstrapTextFieldPanel name = new BootstrapTextFieldPanel("name",
              new PropertyModel(this, "league." + League.FIELD_NAME), "span10");
      name.setValidation();
      form.add(name);
      BootstrapCheckBoxPanel checkBox = new BootstrapCheckBoxPanel("generateTeams",
              new PropertyModel<Boolean>(this, "generateTeams"));
      form.add(checkBox);
   }

   public void resetState()
   {
      setLeague(new League());
      setGenerateTeams(Boolean.FALSE);
   }

   @Override
   public void onSubmit(AjaxRequestTarget target, Form<?> form)
   {
   }

   @Override
   public void onError(AjaxRequestTarget target, Form<?> form)
   {
   }

   public League getLeague()
   {
      return league;
   }

   public void setLeague(League league)
   {
      this.league = league;
   }

   public Boolean getGenerateTeams()
   {
      return generateTeams;
   }

   public void setGenerateTeams(Boolean generateTeams)
   {
      this.generateTeams = generateTeams;
   }
}
