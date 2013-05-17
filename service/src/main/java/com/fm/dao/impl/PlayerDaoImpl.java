package com.fm.dao.impl;

import com.fm.dao.IPlayerDao;
import com.fm.domain.ObjectStateEnum;
import com.fm.domain.Player;
import com.fm.domain.Team;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: pawel
 * Date: 30.11.12
 * Time: 23:59
 */
@Repository
public class PlayerDaoImpl extends AbstractDaoImpl<Player> implements IPlayerDao
{
   @Override
   public List<Player> findTeamPlayers(Team team)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(Player.FIELD_TEAM_SID, team.getSid()));
      criteria.add(Restrictions.eq(Player.FIELD_OBJECT_STATE, ObjectStateEnum.ACTIVE));
      criteria.addOrder(Order.asc(Player.FIELD_POSITION));
      return criteria.list();
   }

   @Override
   public Player getRandom(Team team)
   {
      Criteria criteria = createCriteria();
      criteria.add(Restrictions.eq(Player.FIELD_TEAM_SID, team.getSid()));
      criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
      criteria.setMaxResults(1);
      return (Player) criteria.uniqueResult();
   }
}
