package com.fm.service.impl;

import com.fm.domain.IdentifiableEntity;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 11.05.13
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations =
        {
                "classpath:spring/test-service-context.xml"
        })
public class AbstractServiceTest<T extends IdentifiableEntity> //extends AbstractDaoTest
{
}
