package com.fm.user.pages.userActivationPage;

import com.fm.domain.User;
import com.fm.service.IUserService;
import com.fm.user.api.UserApiMappings;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 02.06.13
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
@MountPath(UserApiMappings.USER_ACTIVATION_PAGE)
public class UserActivationPage extends WebPage implements Serializable, UserApiMappings
{
   @SpringBean
   private IUserService userService;

   public UserActivationPage(PageParameters parameters)
   {
      super(parameters);
//      RequestCycle.get().getRequest().getOriginalUrl();
      User user = getUser(parameters);
   }

   private User getUser(PageParameters parameters)
   {
      String sid = parameters.get(USER_SID_KEY).toString();
      if (StringUtils.isNotBlank(sid))
      {
         User user = userService.getBySid(sid);
         return user;
      }
      return null;
   }
}
