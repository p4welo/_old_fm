package com.football.manager.server.cmp.table;

import com.football.manager.domain.DataEntity;
import com.football.manager.service.IAbstractService;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 * User: pawel
 * Date: 26.01.13
 * Time: 13:14
 */
public class DetachableModel<T extends DataEntity> extends LoadableDetachableModel<T>
{
   private final long id;

   private IAbstractService<T> service;

   public DetachableModel(long id, IAbstractService<T> service)
   {
      if (id == 0 || service == null)
      {
         throw new IllegalArgumentException();
      }
      this.id = id;
      this.service = service;
   }

   @Override

   protected T load()
   {
      return service.getById(id);
   }

   @Override
   public int hashCode()
   {
      return Long.valueOf(id).hashCode();
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
         return other.id == id;
      }
      return false;
   }
}