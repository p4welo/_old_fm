package com.fm.core.cmp.newTable;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

public interface SelectionChangeAware<T>
{
   void executeOnClick(AjaxRequestTarget target, IModel<T> model);
}
