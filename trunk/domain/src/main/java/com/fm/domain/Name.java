package com.fm.domain;

import javax.persistence.*;

@Entity
@Table(name = "name")
public class Name extends IdentifiableEntity
{
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

   @Override
   public String toString()
   {
      return this.value;
   }
}
