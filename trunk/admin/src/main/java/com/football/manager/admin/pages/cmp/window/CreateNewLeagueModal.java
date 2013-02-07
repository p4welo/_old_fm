package com.football.manager.admin.pages.cmp.window;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
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

   private Form form;

   public CreateNewLeagueModal(String id)
   {
      super(id);
      form = new Form("form");
      initView();
      createOkButton();
   }

   private void createOkButton()
   {
      add(new AjaxButton("saveButton", form)
      {
         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            onConfirm(target);
         }
      });
   }

   public void onConfirm(AjaxRequestTarget target)
   {
   }

   private void initView()
   {

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
