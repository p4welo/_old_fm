package com.fm.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 20.05.13
 * Time: 23:43
 * To change this template use File | Settings | File Templates.
 */
public class Email implements Serializable
{
   private String from;

   private String to[];

   private String[] cc = new String[]{};

   private String replyTo = new String();

   private String subject;

   private String content;

   public Email(String from, String to, String subject, String content)
   {
      this.from = from;
      this.to = new String[]{to};
      this.subject = subject;
      this.content = content;
   }

   public String getFrom()
   {
      return from;
   }

   public void setFrom(String from)
   {
      this.from = from;
   }

   public String[] getTo()
   {
      return to;
   }

   public void setTo(String[] to)
   {
      this.to = to;
   }

   public String[] getCc()
   {
      return cc;
   }

   public void setCc(String[] cc)
   {
      this.cc = cc;
   }

   public String getReplyTo()
   {
      return replyTo;
   }

   public void setReplyTo(String replyTo)
   {
      this.replyTo = replyTo;
   }

   public String getSubject()
   {
      return subject;
   }

   public void setSubject(String subject)
   {
      this.subject = subject;
   }

   public String getContent()
   {
      return content;
   }

   public void setContent(String content)
   {
      this.content = content;
   }
}
