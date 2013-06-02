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
 * Time: 16:45
 * To change this template use File | Settings | File Templates.
 */
public class LoginUniqueValidator extends AbstractValidator<String>
{
   @SpringBean
   private IUserService userService;

   public LoginUniqueValidator()
   {
      super();
   }

   @Override
   public void validate(IValidatable<String> validatable)
   {
      String login = validatable.getValue();
      if (login != null)
      {
         User user = userService.getByLogin(login);
         if (user != null)
         {
            error(validatable, "login.non.unique");
         }
      }
   }
}
