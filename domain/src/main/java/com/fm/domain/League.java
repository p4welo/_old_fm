package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * UserEntity: pawel
 * Date: 13.12.12
 * Time: 22:59
 */
@Entity
@Table(name = "league")
public class League extends IdentifiableEntity
{
   public static final String FIELD_NAME = "name";

   public static final String FIELD_KEY = "key";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(nullable = false)
   @NotNull
   private String name;

   @Column(name = "lkey", nullable = false)
   @NotNull
   private String key;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }
}
