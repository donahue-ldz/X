package com.X.aop;

import com.X.aop.logger.Bean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dezhao.ldz on 4/14/16.
 * Email : dezhao.ldz@alibaba-inc.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class loggerAOPTest {
    @Autowired
    private Bean bean;

    @Test
    public void testLog() {
        bean.setName("donahue");
        bean.getName();
    }
}
