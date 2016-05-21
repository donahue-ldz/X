package com.X.biz.admin.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.admin.manager.IRuleManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.RuleDO;
import com.X.dal.mapper.RuleMapper;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Callable;

import static com.X.common.utils.Tool.safeList;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-17 11:45 AM
 **/
@Service("ruleManager")
public class RuleManager implements IRuleManager {
    @Autowired
    private RuleMapper ruleMapper;

    @Override
    public long save(final RuleDO rule) throws XException {

        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                List<RuleDO> ruleDOs = safeList(queryAllRules());
                Optional optional = Iterables.tryFind(ruleDOs, new Predicate<RuleDO>() {
                    @Override
                    public boolean apply(@Nullable RuleDO ruleDO) {
                        return ruleDO.getRuleName().equals(rule.getRuleName());
                    }
                });
                if (!optional.isPresent()) {
                    ruleMapper.save(rule);
                    return rule.getId();
                } else throw new XException("规则存在");

            }
        }, rule);
    }

    @Override
    public List<RuleDO> queryAllRules() throws XException {
        return RunWrapper.run(new Callable<List<RuleDO>>() {
            @Override
            public List<RuleDO> call() throws Exception {
                return ruleMapper.queryAllRules();
            }
        });
    }
}
