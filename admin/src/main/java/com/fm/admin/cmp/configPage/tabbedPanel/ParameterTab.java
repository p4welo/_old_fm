package com.fm.admin.cmp.configPage.tabbedPanel;

import com.fm.core.cmp.notify.Notification;
import com.fm.domain.SystemParameter;
import com.fm.service.ISystemParameterService;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 13.04.13
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class ParameterTab extends Panel
{
   @SpringBean
   private ISystemParameterService systemParameterService;

   private List<SystemParameter> systemParameters;

   private List<SystemParameter> originalParameters;

   public ParameterTab(String id)
   {
      super(id);
      setOutputMarkupId(true);

      systemParameters = systemParameterService.findAll();
      initView();
   }

   private void initView()
   {
      Form form = new Form<SystemParameter>("form");
      final ListView listView = new ListView<SystemParameter>("list", systemParameters)
      {
         @Override
         protected void onBeforeRender()
         {
            originalParameters = systemParameterService.findAll();
            super.onBeforeRender();
         }

         @Override
         protected void populateItem(final ListItem<SystemParameter> item)
         {
            final SystemParameter parameter = item.getModelObject();

            item.add(new Label("key", new PropertyModel<String>(parameter, SystemParameter.FIELD_KEY)));
            final Label state = new Label("state");
            state.add(AttributeModifier.replace("class", "icon-ok-sign"));
            state.setOutputMarkupId(true);

            final WebMarkupContainer stateLabel = new WebMarkupContainer("stateLabel");
            stateLabel.add(AttributeModifier.replace("class", "badge badge-success"));
            stateLabel.setOutputMarkupId(true);
            stateLabel.add(state);
            item.add(stateLabel);

            TextField valueField = new TextField("value", new PropertyModel(parameter, SystemParameter.FIELD_VALUE));
            valueField.add(new AjaxEventBehavior("onchange")
            {
               @Override
               protected void onEvent(AjaxRequestTarget target)
               {
                  stateLabel.add(AttributeModifier.replace("class", "badge badge-warning"));
                  state.add(AttributeModifier.replace("class", "icon-warning-sign"));
                  target.add(state);
                  target.add(stateLabel);
               }
            });
            valueField.setOutputMarkupId(true);
            item.add(valueField);
         }
      };
      listView.setOutputMarkupId(true);
      form.add(listView);
      form.add(new AjaxSubmitLink("submit")
      {
         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            for (SystemParameter parameter : systemParameters)
            {
               systemParameterService.update(parameter);
            }
            Notification.success(getString("parameters.successfully.updated"), target);
            target.add(ParameterTab.this);
         }
      });
      form.setOutputMarkupId(true);
      add(form);

   }
}
