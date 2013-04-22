package com.fm.dao.impl;

import com.fm.dao.IPositionAreaDao;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.Position;
import com.fm.domain.PositionArea;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 14.04.13
 * Time: 18:02
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PositionAreaDaoImpl extends AbstractDaoImpl<PositionArea> implements IPositionAreaDao
{
   @Override
   public List<PositionArea> findByPosition(Position position)
   {
      Criteria criteria = createCriteria(ObjectStateEnum.ACTIVE);
      criteria.add(Restrictions.eq(PositionArea.FIELD_POSITION, position));
      return criteria.list();
   }
}
