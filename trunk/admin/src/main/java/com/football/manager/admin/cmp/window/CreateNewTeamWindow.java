package com.football.manager.admin.cmp.window;

import com.football.manager.admin.cmp.feedback.CssFeedbackPanel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

/**
 * User: pawel
 * Date: 27.01.13
 * Time: 23:35
 */
public class CreateNewTeamWindow extends AbstractWindow
{
   private String teamName;

   private Integer teamAccount;

   public CreateNewTeamWindow(String id)
   {
      super(id, "create.new.team.title");
   }

   @Override
   protected Panel getWindowPanel(String id)
   {
      return new CreateNewTeamPanel(id);
   }

   @Override
   protected void onConfirm(AjaxRequestTarget target)
   {
   }

   @Override
   protected void onCancel(AjaxRequestTarget target)
   {
   }

   public String getTeamName()
   {
      return teamName;
   }

   public void setTeamName(String teamName)
   {
      this.teamName = teamName;
   }

   public Integer getTeamAccount()
   {
      return teamAccount;
   }

   public void setTeamAccount(Integer teamAccount)
   {
      this.teamAccount = teamAccount;
   }

   class CreateNewTeamPanel extends Panel
   {
      public CreateNewTeamPanel(String id)
      {
         super(id);
         initView();
      }

      private void initView()
      {
         Form form = new Form("form")
         {
            @Override
            protected void onComponentTag(ComponentTag tag)
            {
               tag.put("class", "create_new_team_form");
               super.onComponentTag(tag);
            }
         };
         TextField nameField = new TextField<String>("nameField", new PropertyModel(
                 CreateNewTeamWindow.this, "teamName"));
         nameField.setRequired(true);
         form.add(nameField);
         TextField accountField = new TextField<String>("accountField", new PropertyModel(
                 CreateNewTeamWindow.this, "teamAccount"));
         accountField.setRequired(true);
         form.add(accountField);
         CssFeedbackPanel feedbackPanel = new CssFeedbackPanel("feedback");
         feedbackPanel.setOutputMarkupId(true);
         form.add(feedbackPanel);
         form.add(createSaveButton(form, feedbackPanel));
         form.add(createCancelButton(form));
         add(form);
      }
   }
}
