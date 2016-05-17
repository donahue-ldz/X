package com.X.dal.mapper;

import com.X.dal.domain.RuleDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-17 11:41 AM
 **/
@Repository
public interface RuleMapper {
    long save(RuleDO rule);
    List<RuleDO> queryAllRules();
}
