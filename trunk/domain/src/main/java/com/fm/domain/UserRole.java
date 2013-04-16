package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:37
 */
@Entity
@Table(name = "user_role")
public class UserRole extends IdentifiableEntity
{
   public static final String FIELD_USER_ENTITY = "userEntity";

   public static final String FIELD_ROLE = "role";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinColumn(nullable = false, name = "user_id")
   @NotNull
   private UserEntity userEntity;

   @Column(nullable = false)
   @NotNull
   private String role;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public UserEntity getUserEntity()
   {
      return userEntity;
   }

   public void setUserEntity(UserEntity userEntity)
   {
      this.userEntity = userEntity;
   }

   public String getRole()
   {
      return role;
   }

   public void setRole(String role)
   {
      this.role = role;
   }
}
