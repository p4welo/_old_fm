package com.fm.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * User: pawel.radomski
 * Date: 24.05.13
 * Time: 09:32
 */
@Entity
@Table(name = "user_log_history")
public class UserLogHistory extends IdentifiableEntity
{
   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(name = "user_sid", length = 32)
   @Length(max = 32)
   private String userSid;

   @Column(nullable = false, length = 15)
   @NotNull
   @Length(max = 15)
   private String login;

   @Column(nullable = false)
   @NotNull
   private Date date;

   @Column(length = 15)
   @Length(max = 15)
   private String ip;

   @Column(nullable = false)
   @NotNull
   private Boolean success;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getUserSid()
   {
      return userSid;
   }

   public void setUserSid(String userSid)
   {
      this.userSid = userSid;
   }

   public String getLogin()
   {
      return login;
   }

   public void setLogin(String login)
   {
      this.login = login;
   }

   public Date getDate()
   {
      return date;
   }

   public void setDate(Date date)
   {
      this.date = date;
   }

   public String getIp()
   {
      return ip;
   }

   public void setIp(String ip)
   {
      this.ip = ip;
   }

   public Boolean getSuccess()
   {
      return success;
   }

   public void setSuccess(Boolean success)
   {
      this.success = success;
   }
}
