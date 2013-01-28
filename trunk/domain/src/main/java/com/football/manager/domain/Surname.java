package com.football.manager.domain;

import javax.persistence.*;

@Entity
@Table(name = Surname.TABLE_NAME)
public class Surname extends DataEntity
{

   public static final String TABLE_NAME = "surname";

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
}
