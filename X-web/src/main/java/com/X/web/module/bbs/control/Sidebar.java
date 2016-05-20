package com.X.web.module.bbs.control;

import com.X.biz.aggregation.BBSViewAgg;
import com.X.biz.aggregation.UserViewAgg;
import com.X.biz.exception.XException;
import com.X.dal.domain.User;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 5:31 PM
 **/
public class Sidebar extends BaseScreen {
    @Autowired
    private BBSViewAgg bbsViewAgg;
    @Autowired
    private UserViewAgg userViewAgg;

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setBBSInfo(context);
        setUserInfo(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setUserInfo(Context context) throws XException {
        User user = getUser();
        if (user != null)
            context.put("userView", userViewAgg.view(user.ID(), user.role().SQLValue()));

    }

    private void setBBSInfo(Context context) throws XException {
        context.put("bbs", bbsViewAgg.view());
    }
}
