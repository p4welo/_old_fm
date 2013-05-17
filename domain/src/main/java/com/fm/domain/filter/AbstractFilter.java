package com.fm.domain.filter;

import com.fm.domain.ObjectStateEnum;

import java.io.Serializable;

public abstract class AbstractFilter implements Serializable
{
   private static final long serialVersionUID = -3165722370611230573L;

   protected ObjectStateEnum objectState;

   public AbstractFilter()
   {
   }

   public ObjectStateEnum getObjectState()
   {
      return objectState;
   }

   public void setObjectState(ObjectStateEnum objectState)
   {
      this.objectState = objectState;
   }
}
