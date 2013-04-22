package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IManagerDao;
import com.fm.domain.Manager;
import com.fm.domain.Team;
import com.fm.domain.User;
import com.fm.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * User: pawel
 * Date: 01.12.12
 * Time: 00:24
 */
@Service
public class ManagerServiceImpl extends AbstractServiceImpl<Manager> implements IManagerService
{
   @Resource
   private IManagerDao managerDao;

   @Resource
   private ITeamService teamService;

   @Resource
   private IAuthorityService authorityService;

   @Resource
   private IUserService userService;

   @Resource
   private ITeamGenerationStrategy teamGenerationStrategy;

   @Override
   protected IAbstractDao getDao()
   {
      return (IAbstractDao) managerDao;
   }

   @Override
   @Transactional
   public Manager createNewManager(Manager manager)
   {
      Team team = manager.getTeam();
      if (team != null)
      {
         team = teamGenerationStrategy.generateHumanTeam(team);
         manager.setTeam(teamService.save(team));
      }
      User user = manager.getUser();
      if (user != null)
      {
         manager.setUser(userService.save(user));
         authorityService.addUserAuthority(user, "ROLE_USER");
      }
      return save(manager);
   }
}
