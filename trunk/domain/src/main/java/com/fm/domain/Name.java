package com.fm.domain;

import javax.persistence.*;

@Entity
@Table(name = Name.TABLE_NAME)
public class Name extends IdentifiableEntity
{
   public static final String TABLE_NAME = "name";

   public static final String FIELD_VALUE = "value";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column
   private String value;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getValue()
   {
      return value;
   }

   public void setValue(String value)
   {
      this.value = value;
   }
}
