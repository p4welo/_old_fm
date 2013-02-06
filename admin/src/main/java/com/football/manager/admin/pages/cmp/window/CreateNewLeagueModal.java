package com.football.manager.admin.pages.cmp.window;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

/**
 * User: pawel
 * Date: 06.02.13
 * Time: 22:25
 */
public class CreateNewLeagueModal extends Panel
{
   private String leagueName;

   private boolean generateTeams;

   public CreateNewLeagueModal(String id)
   {
      super(id);
      initView();
      createOkButton();
   }

   private void createOkButton()
   {
      add(new AjaxLink<Void>("saveButton")
      {
         @Override
         public void onClick(AjaxRequestTarget ajaxRequestTarget)
         {
            int i = 4;
         }
      });
   }

   private void initView()
   {
      Form form = new Form("form");
      TextField nameField = new TextField<String>("nameField", new PropertyModel(
              this, "leagueName"));
      nameField.setRequired(true);
      form.add(nameField);
      CheckBox generateTeamsField = new CheckBox("generateTeamsField",
              new PropertyModel<Boolean>(this, "generateTeams"));
      form.add(generateTeamsField);
      FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
      feedbackPanel.setOutputMarkupId(true);
      form.add(feedbackPanel);
      add(form);
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
