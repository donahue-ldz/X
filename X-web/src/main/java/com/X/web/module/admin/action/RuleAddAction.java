package com.X.web.module.admin.action;

import com.X.biz.teacher.manager.IRuleManager;
import com.X.dal.domain.AdminDO;
import com.X.dal.domain.RuleDO;
import com.X.web.common.BaseAction;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.dataresolver.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-17 11:31 AM
 **/
public class RuleAddAction extends BaseAction {
    @Autowired
    private IRuleManager ruleManager;

    public void execute(TurbineRunData runData, @Param("ruleName") final String ruleName,
                        @Param("ruleDesc") final String description,
                        @Param("ruleCredit") final long score) throws Exception {
        AdminDO admin = (AdminDO) getUser();
        RuleDO rule = new RuleDO();
        rule.setRuleName(ruleName).setDescription(description).setScore(score);
        rule.setGmtCreate(new Date()).setCreator(admin.getAdminName());
        ruleManager.save(rule);
    }
}
