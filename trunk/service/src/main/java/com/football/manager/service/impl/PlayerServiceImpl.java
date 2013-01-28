package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.IPlayerDao;
import com.football.manager.domain.Player;
import com.football.manager.service.INameService;
import com.football.manager.service.IPlayerService;
import com.football.manager.service.IPositionService;
import com.football.manager.service.ISurnameService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * UserEntity: pawel
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
}
