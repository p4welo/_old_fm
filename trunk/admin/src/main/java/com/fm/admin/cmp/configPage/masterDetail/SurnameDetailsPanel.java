package com.fm.admin.cmp.configPage.masterDetail;

import com.fm.core.cmp.masterDetail.DetailsPanel;
import com.fm.core.cmp.web.BootstrapTextFieldPanel;
import com.fm.domain.Surname;
import com.fm.service.ISurnameService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * User: pawel.radomski
 * Date: 17.04.13
 * Time: 17:17
 */
public class SurnameDetailsPanel extends DetailsPanel<Surname>
{
   private final ISurnameService surnameService;

   private SurnameMasterDetail masterDetail;

   public SurnameDetailsPanel(String id, IModel<Surname> model, ISurnameService surnameService,
                              SurnameMasterDetail masterDetail)
   {
      super(id, model);
      this.surnameService = surnameService;
      this.masterDetail = masterDetail;
      initView();
   }

   private void initView()
   {
      Form form = new Form("form");
      form.add(new BootstrapTextFieldPanel<String>("value",
              new PropertyModel<String>(this, "selected." + Surname.FIELD_VALUE), "span8"));
      form.add(new AjaxSubmitLink("submit")
      {
         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            surnameService.update(getSelected());
            success(getString("surname.successfully.saved"));
            target.add(masterDetail);
         }
      });
      add(form);
   }
}
