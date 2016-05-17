package com.X.biz.teacher.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.RuleDO;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-17 11:45 AM
 **/
public interface IRuleManager {
    long save(RuleDO rule) throws XException;
    List<RuleDO> queryAllRules() throws XException;

}
