package com.fm.admin.pages.configPage.cmp.tabbedPanel;

import com.fm.domain.SystemParameter;
import com.fm.service.ISystemParameterService;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

/**
 * User: pawel.radomski
 * Date: 17.04.13
 * Time: 10:26
 */
public class ParameterForm extends Form
{
   @SpringBean
   private ISystemParameterService systemParameterService;

   private List<SystemParameter> systemParameters;

   public ParameterForm(String id, IModel model)
   {
      super(id, model);
   }
}
