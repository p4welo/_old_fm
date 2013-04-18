package com.fm.dao.impl;

import com.fm.dao.ITeamRecordDao;
import com.fm.domain.Season;
import com.fm.domain.TeamRecord;
import org.hibernate.Criteria;
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
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(TeamRecord.FIELD_SEASON, season));
      return criteria.list();
   }
}
