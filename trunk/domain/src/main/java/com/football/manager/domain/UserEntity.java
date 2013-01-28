package com.football.manager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:16
 */
@Entity
@Table(name = UserEntity.TABLE_NAME)
public class UserEntity extends DataEntity
{
   public static final String TABLE_NAME = "user";

   public static final String FIELD_LOGIN = "login";

   public static final String FIELD_PASSWORD = "password";

   public static final String FIELD_EMAIL = "email";

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
