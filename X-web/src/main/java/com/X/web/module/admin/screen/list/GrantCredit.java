package com.X.web.module.admin.screen.list;

import com.X.biz.admin.manager.IRuleManager;
import com.X.biz.exception.XException;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-21 8:02 PM
 **/
public class GrantCredit extends BaseScreen {
    @Autowired
    private IRuleManager ruleManager;

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setRules(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setRules(Context context) throws XException {
        context.put("rules", ruleManager.queryAllRules());
    }
}
