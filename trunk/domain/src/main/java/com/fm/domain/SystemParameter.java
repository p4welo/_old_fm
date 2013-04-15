package com.fm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: pawel.radomski
 * Date: 15.04.13
 * Time: 10:52
 */
@Entity
@Table(name = "system_parameter")
public class SystemParameter extends IdentifiableEntity
{
   public static final String FIELD_KEY = "key";

   public static final String FIELD_VALUE = "value";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(name = "pkey", nullable = false)
   @NotNull
   private String key;

   @Column
   private String value;

   @Override
   public Long getId()
   {
      return id;
   }

   @Override
   public void setId(Long id)
   {
      this.id = id;
   }

   public String getKey()
   {
      return key;
   }

   public void setKey(String key)
   {
      this.key = key;
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
