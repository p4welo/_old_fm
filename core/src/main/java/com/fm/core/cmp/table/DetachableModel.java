package com.fm.core.cmp.table;

import com.fm.domain.IdentifiableEntity;
import com.fm.service.IAbstractService;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 * User: pawel
 * Date: 26.01.13
 * Time: 13:14
 */
public class DetachableModel<T extends IdentifiableEntity> extends LoadableDetachableModel<T>
{
   private final String sid;

   private IAbstractService<T> service;

   public DetachableModel(String sid, IAbstractService<T> service)
   {
      if (StringUtils.isBlank(sid) || service == null)
      {
         throw new IllegalArgumentException();
      }
      this.sid = sid;
      this.service = service;
   }

   @Override

   protected T load()
   {
      return service.getBySid(sid);
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
         return StringUtils.equals(other.sid, sid);
      }
      return false;
   }
}
