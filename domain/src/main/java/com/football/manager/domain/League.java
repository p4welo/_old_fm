package com.football.manager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * UserEntity: pawel
 * Date: 13.12.12
 * Time: 22:59
 */
@Entity
@Table(name = League.TABLE_NAME)
public class League extends DataEntity
{
   public static final String TABLE_NAME = "league";

   public static final String FIELD_NAME = "name";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(nullable = false)
   @NotNull
   private String name;

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
