package com.fm.dao.impl;

import com.fm.dao.IPositionDao;
import com.fm.domain.Position;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:05
 */
@Repository
public class PositionDaoImpl extends AbstractDaoImpl<Position> implements IPositionDao
{
   @Override
   public Position getByShortName(String shortName)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(Position.FIELD_SHORT_NAME, shortName));
      criteria.setMaxResults(1);
      return (Position) criteria.uniqueResult();
   }
}
