package com.football.manager.admin.pages.cmp.window;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

/**
 * User: pawel
 * Date: 27.01.13
 * Time: 21:01
 */
public class CreateNewLeagueWindow extends AbstractWindow
{
   private String leagueName;

   private boolean generateTeams;

   public CreateNewLeagueWindow(String id)
   {
      super(id, "create.new.league.title");
      setUseInitialHeight(true);
      setInitialHeight(300);
      setInitialWidth(300);
//      setCssClassName(getCssClassName() + " create_league_window");
   }

   @Override
   public String getCssClassName()
   {
      return super.getCssClassName() + " create_league_window";
   }

   @Override
   protected Panel getWindowPanel(String id)
   {
      return new CreateNewLeaguePanel(id);
   }

   @Override
   protected void onConfirm(AjaxRequestTarget target)
   {
   }

   @Override
   protected void onCancel(AjaxRequestTarget target)
   {
   }

   public boolean getGenerateTeams()
   {
      return generateTeams;
   }

   public void setGenerateTeams(boolean generateTeams)
   {
      this.generateTeams = generateTeams;
   }

   public String getLeagueName()
   {
      return leagueName;
   }

   public void setLeagueName(String leagueName)
   {
      this.leagueName = leagueName;
   }

   class CreateNewLeaguePanel extends Panel
   {

      public CreateNewLeaguePanel(String id)
      {
         super(id);
         initView();
      }

      private void initView()
      {
         Form form = new Form("form");
         TextField nameField = new TextField<String>("nameField", new PropertyModel(
                 CreateNewLeagueWindow.this, "leagueName"));
         nameField.setRequired(true);
         form.add(nameField);
         CheckBox generateTeamsField = new CheckBox("generateTeamsField",
                 new PropertyModel<Boolean>(CreateNewLeagueWindow.this, "generateTeams"));
         form.add(generateTeamsField);
         FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
         feedbackPanel.setOutputMarkupId(true);
         form.add(feedbackPanel);
         form.add(createSaveButton(form, feedbackPanel));
         form.add(createCancelButton(form));
         add(form);
      }

   }
}
