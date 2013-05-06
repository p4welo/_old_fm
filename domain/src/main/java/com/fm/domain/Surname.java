package com.fm.domain;

import javax.persistence.*;

@Entity
@Table(name = "surname")
public class Surname extends IdentifiableEntity
{
   public static final String FIELD_VALUE = "value";

   /* Constructors */
   public Surname()
   {
      this.value = "";
   }

   /* Fields */
   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column
   private String value;

   /* Getters & Setters */
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
