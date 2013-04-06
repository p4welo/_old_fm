package com.fm.core.cmp.window;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

public abstract class AbstractWindow extends Panel
{
   private static final long serialVersionUID = 8955482927887494778L;

   protected Form form;

   protected String header;

   public AbstractWindow(String id, String header)
   {
      super(id);
      setOutputMarkupId(true);
      this.header = header != null ? header : "";
      WebMarkupContainer container = new WebMarkupContainer("container");
      container.add(new AttributeModifier("id", id));
      add(container);

      form = new Form<Void>("form");
      AjaxSubmitLink submitLink = getSubmitLink(form);
      if (submitLink != null)
      {
         form.add(submitLink);
         form.setDefaultButton(submitLink);
      }
      form.add(getCancelLink());
      container.add(form);
      container.add(new Label("header", new PropertyModel<String>(this, "header")));
   }

   protected AjaxLink getCancelLink()
   {
      AjaxLink link = new AjaxLink("cancel")
      {
         @Override
         public void onClick(AjaxRequestTarget target)
         {
            AbstractWindow.this.onCancel(target);
         }
      };
      return link;
   }

   protected AjaxSubmitLink getSubmitLink(Form<Void> form)
   {
      AjaxSubmitLink ajaxLink = new AjaxSubmitLink("ajaxLink", form)
      {
         private static final long serialVersionUID = -703188740715674542L;

         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            AbstractWindow.this.onSubmit(target, form);
            beforeClose(target);
         }

         @Override
         protected void onError(AjaxRequestTarget target, Form<?> form)
         {
            target.add(form);
            AbstractWindow.this.onError(target, form);
         }
      };
      return ajaxLink;
   }

   public void show(AjaxRequestTarget target)
   {
      target.add(AbstractWindow.this);
      target.appendJavaScript("$('#" + getId() + "').modal('show');");
   }

   protected void beforeClose(AjaxRequestTarget target)
   {
      target.appendJavaScript("$('#" + getId() + "').modal('hide');");
      target.appendJavaScript("$('.modal-backdrop').remove();");
   }

   public abstract void onSubmit(AjaxRequestTarget target, Form<?> form);

   public abstract void onError(AjaxRequestTarget target, Form<?> form);

   public void onCancel(AjaxRequestTarget target)
   {
      beforeClose(target);
   }

   public String getHeader()
   {
      return header;
   }

   public void setHeader(String header)
   {
      this.header = header;
   }
}
