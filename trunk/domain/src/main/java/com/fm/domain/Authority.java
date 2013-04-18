package com.fm.domain;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:37
 */
@Entity
@Table(name = "authority")
public class Authority extends IdentifiableEntity
{
   public static final String FIELD_USER_ENTITY = "user";

   public static final String FIELD_ROLE = "role";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinColumn(nullable = false, name = "user_id")
   @NotNull
   private User user;

   @Column(nullable = false)
   @NotNull
   private String authority;

   public boolean equals(String role)
   {
      return StringUtils.equals(authority, role);
   }

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public User getUser()
   {
      return user;
   }

   public void setUser(User user)
   {
      this.user = user;
   }

   public String getAuthority()
   {
      return authority;
   }

   public void setAuthority(String authority)
   {
      this.authority = authority;
   }
}
