package com.fm.admin.cmp.config.tabbedPanel;

import com.fm.core.cmp.feedback.NotifyFeedbackPanel;
import com.fm.core.cmp.web.BootstrapTextFieldPanel;
import com.fm.domain.Name;
import com.fm.service.INameService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * User: pawel.radomski
 * Date: 17.04.13
 * Time: 16:56
 */
public class NameDetailsPanel extends Panel
{
   private final IModel<Name> model;

   private final INameService nameService;

   private final WebMarkupContainer parent;

   private WebMarkupContainer main;

   private Name selected;

   public NameDetailsPanel(String id, IModel<Name> model, INameService nameService, WebMarkupContainer parent)
   {
      super(id, model);
      this.model = model;
      this.nameService = nameService;
      this.parent = parent;

      initView();
   }

   private void initView()
   {
      main = new WebMarkupContainer("main")
      {
         @Override
         protected void onConfigure()
         {
            setVisible(selected != null);
         }
      };
      main.setOutputMarkupId(true);
      main.add(new NotifyFeedbackPanel("feedback"));
      Form form = new Form("form");
      form.add(new BootstrapTextFieldPanel<String>("value",
              new PropertyModel<String>(this, "selected." + Name.FIELD_VALUE), "span8"));
      form.add(new AjaxSubmitLink("submit")
      {
         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            nameService.update(selected);
            success(getString("name.successfully.saved"));
            target.add(parent);
         }
      });
      main.add(form);
      add(main);
   }

   @Override
   protected void onBeforeRender()
   {
      selected = model.getObject();
      super.onBeforeRender();
   }
}
