package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = Position.TABLE_NAME)
public class Position extends IdentifiableEntity
{

   public static final String TABLE_NAME = "position";

   public static final String FIELD_SHORT_NAME = "shortName";

   public static final String FIELD_FULL_NAME = "fullName";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(name = "short_name", nullable = false)
   @NotNull
   private String shortName;

   @Column(name = "full_name", nullable = false)
   @NotNull
   private String fullName;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getShortName()
   {
      return shortName;
   }

   public void setShortName(String shortName)
   {
      this.shortName = shortName;
   }

   public String getFullName()
   {
      return fullName;
   }

   public void setFullName(String fullName)
   {
      this.fullName = fullName;
   }
}
