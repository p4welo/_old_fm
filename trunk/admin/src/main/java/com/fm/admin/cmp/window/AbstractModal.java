package com.fm.admin.cmp.window;

import com.fm.admin.cmp.feedback.CssFeedbackPanel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 22.02.13
 * Time: 20:52
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractModal extends Panel
{

   protected Form form;

   protected CssFeedbackPanel feedbackPanel;

   public AbstractModal(String id)
   {
      super(id);

      abstractView();
      initView();
      createOkButton();
   }

   private void abstractView()
   {
      form = new Form<Void>("form");
      form.setOutputMarkupId(true);
      feedbackPanel = new CssFeedbackPanel("feedback");
      feedbackPanel.setOutputMarkupId(true);
      form.add(feedbackPanel);
      add(form);
   }

   protected void createOkButton()
   {
      add(new AjaxButton("saveButton", form)
      {
         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            onConfirm(target);
         }

         @Override
         protected void onError(AjaxRequestTarget target, Form<?> form)
         {
            target.add(form);
         }
      });
   }

   public abstract void onConfirm(AjaxRequestTarget target);

   protected abstract void initView();
}
