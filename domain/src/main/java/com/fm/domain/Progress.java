package com.fm.domain;

import java.io.Serializable;

/**
 * User: pawel.radomski
 * Date: 20.05.13
 * Time: 13:08
 */
public class Progress implements Serializable
{
   private Integer value = 0;

   public Integer getValue()
   {
      return value;
   }

   public void setValue(Integer value)
   {
      this.value = value;
   }
}
