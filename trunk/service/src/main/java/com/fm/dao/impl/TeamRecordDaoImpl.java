package com.fm.dao.impl;

import com.fm.dao.ITeamRecordDao;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.Season;
import com.fm.domain.TeamRecord;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: pawel
 * Date: 14.12.12
 * Time: 00:17
 */
@Repository
public class TeamRecordDaoImpl extends AbstractDaoImpl<TeamRecord> implements ITeamRecordDao
{
   @Override
   public List<TeamRecord> findTeamRecordsBySeason(Season season)
   {
      Criteria criteria = createCriteria(ObjectStateEnum.ACTIVE);
      criteria.add(Restrictions.eq(TeamRecord.FIELD_SEASON, season));
      criteria.addOrder(Order.desc(TeamRecord.FIELD_POINTS_COUNT));
      return criteria.list();
   }
}