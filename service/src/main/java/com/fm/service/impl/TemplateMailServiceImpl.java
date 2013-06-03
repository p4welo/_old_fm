package com.fm.service.impl;

import com.fm.context.ServerEndpointHolder;
import com.fm.domain.Email;
import com.fm.domain.User;
import com.fm.service.IMailService;
import com.fm.service.ITemplateMailService;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 20.05.13
 * Time: 23:40
 * To change this template use File | Settings | File Templates.
 */
public class TemplateMailServiceImpl implements ITemplateMailService
{
   public static final String BEAN_NAME = "templateMailService";

   @Resource
   private IMailService mailService;

   private String sender;

   private String serverAbsolutePath;

   @Override
   public void sendAccountActivationMail(User user)
   {
      String subject = "[FM] Aktywacja konta";
      String endpoint = ServerEndpointHolder.getEndpoint();
      String activationLink = endpoint + "/user/" + user.getSid() + "/activation";

      StringBuilder body = new StringBuilder();
      body.append("Witaj,");
      body.append("<br/><br/>");
      body.append("dziękujemy za zarejestrowanie się w grze Football Manager!");
      body.append("<br/><br/>");
      body.append("Kliknij w poniższy link w celu aktywacji konta:");
      body.append("<br/>");
      body.append("<a href='");
      body.append(activationLink);
      body.append("'>");
      body.append(activationLink);
      body.append("</a>");
      body.append("<br/><br/>");
      body.append("Login: ");
      body.append(user.getLogin());
      body.append("<br/>");
      body.append("Manager: ");
      body.append(user.getManagerName());
      body.append(" ");
      body.append(user.getManagerSurname());
      body.append("<br/>");
      body.append("Klub: ");
      body.append(user.getTeamName());
      body.append("<br/><br/>");
      body.append("Jeżeli nie zarejestrowałeś się do naszej gry, zignoruj niniejszą wiadomość.");

      Email email = new Email(
              sender,
              user.getEmail(),
              subject,
              body.toString());
      try
      {
         mailService.sendEmail(email);
      }
      catch (MessagingException e)
      {

      }
   }

   public void setSender(String sender)
   {
      this.sender = sender;
   }

   public void setServerAbsolutePath(String serverAbsolutePath)
   {
      this.serverAbsolutePath = serverAbsolutePath;
   }
}
