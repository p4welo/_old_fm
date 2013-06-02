package com.fm.core.validator;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 02.06.13
 * Time: 17:10
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractValidator<T> implements IValidator<T>
{
   protected AbstractValidator()
   {
      Injector.get().inject(this);
   }

   protected void error(IValidatable<String> validatable, String errorKey)
   {
      ValidationError error = new ValidationError();
      error.addKey(getClass().getSimpleName() + "." + errorKey);
      validatable.error(error);
   }

}
