package com.fm.core.cmp.breadcrumb;

import com.fm.core.navigation.NavigateAction;
import org.apache.wicket.model.IModel;

/**
 * User: pawel.radomski
 * Date: 09.04.13
 * Time: 11:42
 */
public class BreadCrumbAction
{
   protected NavigateAction navigateAction;

   protected IModel labelModel;

   public BreadCrumbAction(NavigateAction navigateAction, IModel labelModel)
   {
      this.navigateAction = navigateAction;
      this.labelModel = labelModel;
   }

   public NavigateAction getNavigateAction()
   {
      return navigateAction;
   }

   public void setNavigateAction(NavigateAction navigateAction)
   {
      this.navigateAction = navigateAction;
   }

   public IModel getLabelModel()
   {
      return labelModel;
   }

   public void setLabelModel(IModel labelModel)
   {
      this.labelModel = labelModel;
   }
}
