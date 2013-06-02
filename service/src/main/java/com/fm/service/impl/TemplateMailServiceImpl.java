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
      Email email = new Email(
              sender,
              user.getEmail(),
              "aktywacja",
              ServerEndpointHolder.getEndpoint());
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
