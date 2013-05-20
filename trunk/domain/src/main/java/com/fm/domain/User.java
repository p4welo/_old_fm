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

   public static final String FIELD_MANAGER_NAME = "managerName";

   public static final String FIELD_MANAGER_SURNAME = "managerSurname";

   public static final String FIELD_TEAM_NAME = "teamName";

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

   @Column(name = "manager_name")
   private String managerName;

   @Column(name = "manager_surname")
   private String managerSurname;

   @Column(name = "team_name")
   private String teamName;

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

   public String getManagerName()
   {
      return managerName;
   }

   public void setManagerName(String managerName)
   {
      this.managerName = managerName;
   }

   public String getManagerSurname()
   {
      return managerSurname;
   }

   public void setManagerSurname(String managerSurname)
   {
      this.managerSurname = managerSurname;
   }

   public String getTeamName()
   {
      return teamName;
   }

   public void setTeamName(String teamName)
   {
      this.teamName = teamName;
   }
}
