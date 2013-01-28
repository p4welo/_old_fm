package com.football.manager.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * UserEntity: pawel
 * Date: 23.07.12
 * Time: 21:14
 * To change this template use File | Settings | File Templates.
 */
public abstract class DataEntity implements IDataBean, Serializable
{
   public static final String FIELD_ID = "id";

   public abstract Long getId();
}
