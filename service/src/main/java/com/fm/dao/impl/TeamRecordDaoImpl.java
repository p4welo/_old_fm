package com.fm.dao.impl;

import com.fm.dao.ITeamRecordDao;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.Season;
import com.fm.domain.TeamRecord;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
   public List<TeamRecord> findTeamRecordsBySeason(Season season, boolean orderByPlace)
   {
      Criteria criteria = createCriteria(ObjectStateEnum.ACTIVE);
      criteria.add(Restrictions.eq(TeamRecord.FIELD_SEASON, season));
      if (orderByPlace)
      {
         criteria.addOrder(Order.asc(TeamRecord.FIELD_PLACE));
      }
      else
      {
         criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
      }
      return criteria.list();
   }

   @Override
   public List<TeamRecord> findAllTeamRecordsFromSeason(String teamSid, Season season)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.ne(TeamRecord.FIELD_ROUND_NUMBER, 0));
      criteria.add(Restrictions.eq(TeamRecord.FIELD_SEASON, season));
      criteria.add(Restrictions.eq(TeamRecord.FIELD_TEAM_SID, teamSid));
      criteria.addOrder(Order.asc(TeamRecord.FIELD_ROUND_NUMBER));
      return criteria.list();
   }

   @Override
   public List<Integer> getPlayedRoundListBySeason(Season season)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(TeamRecord.FIELD_SEASON, season));
      criteria.add(Restrictions.ne(TeamRecord.FIELD_ROUND_NUMBER, 0));
      criteria.setProjection(Projections.distinct(Projections.property(TeamRecord.FIELD_ROUND_NUMBER)));
      return criteria.list();
   }
}
