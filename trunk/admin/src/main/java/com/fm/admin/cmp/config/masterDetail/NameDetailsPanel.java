package com.fm.admin.cmp.config.masterDetail;

import com.fm.core.cmp.masterDetail.DetailsPanel;
import com.fm.core.cmp.web.BootstrapTextFieldPanel;
import com.fm.domain.Name;
import com.fm.service.INameService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * User: pawel.radomski
 * Date: 17.04.13
 * Time: 16:56
 */
public class NameDetailsPanel extends DetailsPanel<Name>
{
   private final INameService nameService;

   private NameMasterDetail masterDetail;

   public NameDetailsPanel(String id, IModel<Name> model, INameService nameService, NameMasterDetail masterDetail)
   {
      super(id, model);
      this.nameService = nameService;
      this.masterDetail = masterDetail;
      initView();
   }

   private void initView()
   {
      Form form = new Form("form");
      form.add(new BootstrapTextFieldPanel<String>("value",
              new PropertyModel<String>(this, "selected." + Name.FIELD_VALUE), "span8"));
      form.add(new AjaxSubmitLink("submit")
      {
         @Override
         protected void onSubmit(AjaxRequestTarget target, Form<?> form)
         {
            nameService.update(getSelected());
            success(getString("name.successfully.saved"));
            target.add(masterDetail);
         }
      });
      add(form);
   }
}
