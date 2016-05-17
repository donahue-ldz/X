package com.X.web.module.admin.screen.list;

import com.X.biz.exception.XException;
import com.X.biz.teacher.manager.IRuleManager;
import com.X.dal.domain.RuleDO;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-17 1:01 PM
 **/
public class RuleList extends BaseScreen {
    @Autowired
    private IRuleManager ruleManager;

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setAllRules(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setAllRules(Context context) throws XException {
        List<RuleDO> ruleDOs = ruleManager.queryAllRules();
        context.put("rules", ruleDOs);
    }
}
