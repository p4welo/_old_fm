package com.fm.core.cmp.newTable;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

import java.io.Serializable;

public interface SelectionChangeCallback<T> extends Serializable
{
   void onSelectionChange(AjaxRequestTarget target, IModel<T> model);
}
