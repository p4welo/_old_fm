package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:16
 */
@Entity
@Table(name = "user")
public class User extends IdentifiableEntity
{
   public static final String FIELD_LOGIN = "login";

   public static final String FIELD_PASSWORD = "password";

   public static final String FIELD_EMAIL = "email";

//   public static final String FIELD_OBJECT_STATE = "objectState";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(nullable = false)
   @NotNull
   private String login;

   @Column(nullable = false)
   @NotNull
   private String password;

   @Column
   private String email;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getLogin()
   {
      return login;
   }

   public void setLogin(String login)
   {
      this.login = login;
   }

   public String getPassword()
   {
      return password;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }
}
