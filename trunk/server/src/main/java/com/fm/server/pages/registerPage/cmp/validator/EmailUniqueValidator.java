package com.fm.server.pages.registerPage.cmp.validator;

import com.fm.core.validator.AbstractValidator;
import com.fm.domain.User;
import com.fm.service.IUserService;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.IValidatable;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 02.06.13
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 */
public class EmailUniqueValidator extends AbstractValidator<String>
{
   @SpringBean
   private IUserService userService;

   public EmailUniqueValidator()
   {
      super();
   }

   @Override
   public void validate(IValidatable<String> validatable)
   {
      String email = validatable.getValue();
      if (email != null)
      {
         User user = userService.getByEmail(email);
         if (user != null)
         {
            error(validatable, "email.non.unique");
         }
      }
   }
}
