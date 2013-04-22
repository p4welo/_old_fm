package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IManagerDao;
import com.fm.domain.Manager;
import com.fm.domain.Team;
import com.fm.domain.User;
import com.fm.service.IManagerService;
import com.fm.service.ITeamService;
import com.fm.service.IUserService;
import org.springframework.stereotype.Service;

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
   private IUserService userService;

   @Override
   protected IAbstractDao getDao()
   {
      return (IAbstractDao) managerDao;
   }

   @Override
   public Manager save(Manager manager)
   {
      Team team = manager.getTeam();
      manager.setTeam(teamService.save(team));
      User user = manager.getUser();
      manager.setUser(userService.save(user));
      return super.save(manager);
   }
}
