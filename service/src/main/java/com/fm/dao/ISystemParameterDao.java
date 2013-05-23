package com.fm.dao;

import com.fm.domain.SystemParameter;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 15.04.13
 * Time: 18:06
 * To change this template use File | Settings | File Templates.
 */
public interface ISystemParameterDao extends IAbstractDao<SystemParameter>
{
   String getByKey(String key);
}
