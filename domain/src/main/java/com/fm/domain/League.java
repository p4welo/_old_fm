package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: pawel
 * Date: 13.12.12
 * Time: 22:59
 */
@Entity
@Table(name = "league")
public class League extends IdentifiableEntity
{
   public static final String FIELD_NAME = "name";

   public static final String FIELD_LEVEL = "level";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(nullable = false)
   @NotNull
   private String name;

   @Column(nullable = false)
   @NotNull
   private Integer level;

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

   public Integer getLevel()
   {
      return level;
   }

   public void setLevel(Integer level)
   {
      this.level = level;
   }
}
