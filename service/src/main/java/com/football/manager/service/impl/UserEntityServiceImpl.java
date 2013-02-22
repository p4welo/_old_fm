package com.football.manager.service.impl;

import com.football.manager.dao.IAbstractDao;
import com.football.manager.dao.IUserEntityDao;
import com.football.manager.domain.UserEntity;
import com.football.manager.service.IUserEntityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * UserEntity: pawel
 * Date: 17.12.12
 * Time: 19:30
 */
@Service(UserEntityServiceImpl.BEAN_NAME)
public class UserEntityServiceImpl extends AbstractServiceImpl<UserEntity> implements IUserEntityService {
    public static final String BEAN_NAME = "userEntityService";

    @Resource
    private IUserEntityDao userEntityDao;

    @Override
    protected IAbstractDao<UserEntity> getDao() {
        return (IAbstractDao<UserEntity>) userEntityDao;
    }

    public UserEntity findByLogin(String login) {
        return userEntityDao.findByLogin(login);
    }

    @Override
    @Transactional
    public boolean authenticate(String login, String password) {
        byte[] bytesOfMessage = password.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(bytesOfMessage);
            String pas = String.valueOf(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        UserEntity entity = userEntityDao.findByLogin(login);
        if (entity != null) {
            StringUtils.equals(password, entity.getPassword());
        }
             return true;
    }
}
