package com.fm.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * User: pawel
 * Date: 12.04.13
 * Time: 23:16
 */
@MappedSuperclass
public abstract class IdentifiableEntity extends DataEntity
{
   public static final String FIELD_SID = "sid";

   @Column(nullable = false, length = 32)
   @Length(max = 32)
   @NotNull
   protected String sid;

   public String getSid()
   {
      return sid;
   }

   public void setSid(String sid)
   {
      this.sid = sid;
   }
}
