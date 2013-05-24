package com.fm.service.impl;

import com.fm.dao.IAbstractDao;
import com.fm.dao.IUserLogHistoryDao;
import com.fm.domain.UserLogHistory;
import com.fm.service.IUserLogHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: pawel.radomski
 * Date: 24.05.13
 * Time: 11:00
 */
@Service(UserLogHistoryServiceImpl.BEAN_NAME)
public class UserLogHistoryServiceImpl extends AbstractServiceImpl<UserLogHistory> implements IUserLogHistoryService
{
   public static final String BEAN_NAME = "userLogHistoryService";

   @Resource
   private IUserLogHistoryDao userLogHistoryDao;

   @Override
   protected IAbstractDao<UserLogHistory> getDao()
   {
      return userLogHistoryDao;
   }
}
