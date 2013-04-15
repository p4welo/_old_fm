package com.fm.admin.cmp.config.tabbedPanel;

import com.fm.core.cmp.feedback.NotifyFeedbackPanel;
import com.fm.domain.SystemParameter;
import com.fm.service.ISystemParameterService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
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

   public ParameterTab(String id)
   {
      super(id);
      setOutputMarkupId(true);

      systemParameters = systemParameterService.findAll();
      initView();
   }

   private void initView()
   {
      add(new NotifyFeedbackPanel("feedback"));
      add(new ListView<SystemParameter>("list", systemParameters)
      {
         @Override
         protected void onBeforeRender()
         {
            systemParameters = systemParameterService.findAll();
            super.onBeforeRender();
         }

         @Override
         protected void populateItem(final ListItem<SystemParameter> item)
         {
            SystemParameter parameter = item.getModelObject();
            item.setOutputMarkupId(true);
            item.add(new Label("key", new PropertyModel<String>(parameter, SystemParameter.FIELD_KEY)));
//            final Label state = new Label("state", msg);
//            state.setOutputMarkupId(true);
//            item.add(state);
            final TextField valueField = new TextField("value", new Model<String>()
            {
               @Override
               public String getObject()
               {
                  return item.getModel().getObject().getValue();
               }

               @Override
               public void setObject(String object)
               {
                  item.getModel().getObject().setValue(object);
               }
            });
//            valueField.add(new AjaxEventBehavior("onchange")
//            {
//               @Override
//               protected void onEvent(AjaxRequestTarget target)
//               {
//
//                  state.add(AttributeModifier.replace("class", "label label-important"));
//                  target.add(state);
//               }
//            });
            item.add(valueField);
//            item.add(new AjaxLink<Void>("submit")
//            {
//               @Override
//               public void onClick(AjaxRequestTarget target)
//               {
//                  int i = 5;
//                  target.add(item);
//               }
//            });
         }
      });
   }
}
