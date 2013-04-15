package com.fm.core.cmp.newTable;

import com.fm.domain.IdentifiableEntity;
import com.fm.service.IAbstractService;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.model.LoadableDetachableModel;

public class DetachableModel<T extends IdentifiableEntity> extends LoadableDetachableModel<T>
{
   private static final long serialVersionUID = 7371109077016817589L;

   private final IAbstractService<T> service;

   private final String sid;

   public DetachableModel(T entity, IAbstractService<T> service)
   {
      this.service = service;
      this.sid = entity.getSid();
   }

   @Override
   public int hashCode()
   {
      return sid.hashCode();
   }

   @Override
   public boolean equals(final Object obj)
   {
      if (obj == this)
      {
         return true;
      }
      else if (obj == null)
      {
         return false;
      }
      else if (obj instanceof DetachableModel)
      {
         DetachableModel other = (DetachableModel) obj;
         return StringUtils.equals(other.getSid(), sid);
      }
      return false;
   }

   @Override
   protected T load()
   {
      return service.getBySid(sid);
   }

   public String getSid()
   {
      return sid;
   }
}
