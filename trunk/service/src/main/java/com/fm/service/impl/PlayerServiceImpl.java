package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IPlayerDao;
import com.fm.domain.Player;
import com.fm.domain.Team;
import com.fm.service.INameService;
import com.fm.service.IPlayerService;
import com.fm.service.IPositionService;
import com.fm.service.ISurnameService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:24
 */
@Service(PlayerServiceImpl.BEAN_NAME)
public class PlayerServiceImpl extends AbstractServiceImpl<Player> implements IPlayerService
{
   public static final String BEAN_NAME = "playerService";

   @Resource
   private IPlayerDao playerDao;

   @Resource
   private INameService nameService;

   @Resource
   private ISurnameService surnameService;

   @Resource
   private IPositionService positionService;

   @Override
   protected IAbstractDao<Player> getDao()
   {
      return (IAbstractDao<Player>) playerDao;
   }

   @Transactional
   public Player generatePlayer()
   {
      Player player = new Player();

      player.setName(nameService.getRandom().getValue());
      player.setSurname(surnameService.getRandom().getValue());
      player.setPosition(positionService.getRandom());

      return player;
   }

   @Override
   @Transactional
   public List<Player> findTeamPlayers(Team team)
   {
      return playerDao.findTeamPlayers(team);
   }

   @Override
   @Transactional
   public Player getRandom(Team team)
   {
      return playerDao.getRandom(team);
   }
}
