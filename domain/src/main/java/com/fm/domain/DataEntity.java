package com.fm.domain;

import com.sun.javafx.beans.annotations.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * UserEntity: pawel
 * Date: 23.07.12
 * Time: 21:14
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class DataEntity implements IDataBean, Serializable
{
   public static final String FIELD_ID = "id";

   public static final String FIELD_SID = "sid";

   public abstract Long getId();

   public abstract void setId(Long id);

   @Column(nullable = false, length = 32)
   @Length(max = 32)
   @NonNull
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
