package com.football.manager.admin.cmp.window;

import com.football.manager.admin.cmp.feedback.CssFeedbackPanel;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;

public abstract class AbstractWindow extends ModalWindow
{
   private static final long serialVersionUID = 6168840118321883617L;

   private boolean canceled = false;

   public AbstractWindow(String id, String titleKey)
   {
      super(id);
      setTitle(new ResourceModel(titleKey));
      setCookieName(id);
      setResizable(false);
      setWidthUnit("px");
      setHeightUnit("px");
      setContent(getWindowPanel(this.getContentId()));

      setCloseButtonCallback(new CloseButtonCallback()
      {
         private static final long serialVersionUID = 2664501261248462314L;

         @Override
         public boolean onCloseButtonClicked(AjaxRequestTarget target)
         {
            canceled = true;
            return true;
         }
      });

      setWindowClosedCallback(new WindowClosedCallback()
      {
         private static final long serialVersionUID = 1L;

         @Override
         public void onClose(AjaxRequestTarget target)
         {
            if (canceled)
            {
               canceled = false;
               onCancel(target);
            }
            else
            {
               onConfirm(target);
            }
         }
      });
   }

   public AjaxButton createCancelButton(final Form form)
   {
      AjaxButton cancelButton = new AjaxButton("cancelButton", form)
      {
         private static final long serialVersionUID = -319164303414414574L;

      };
      cancelButton.add(new AjaxEventBehavior("onclick")
      {
         private static final long serialVersionUID = 7834499405735995493L;

         @Override
         protected void onEvent(AjaxRequestTarget target)
         {
            canceled = true;
            close(target);
         }
      });
      return cancelButton;
   }

   public AjaxButton createSaveButton(final Form form)
   {
      return createSaveButton(form, null);
   }

   public AjaxButton createSaveButton(final Form form, final CssFeedbackPanel feedbackPanel)
   {
      AjaxButton saveButton = new AjaxButton("saveButton", form)
      {
         private static final long serialVersionUID = 3456059450224562205L;

         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            close(target);
         }

         @Override
         protected void onError(AjaxRequestTarget target, Form<?> form)
         {
            if (feedbackPanel != null)
            {
               target.add(feedbackPanel);
            }
         }
      };
      return saveButton;
   }

   protected abstract Panel getWindowPanel(String id);

   protected abstract void onConfirm(AjaxRequestTarget target);

   protected abstract void onCancel(AjaxRequestTarget target);
}
