package com.X.web.module.admin.control;

import com.X.biz.exception.XException;
import com.X.dal.domain.AdminDO;
import com.X.dal.domain.Role;
import com.X.dal.domain.User;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;

import java.util.List;

/**
 * Created by dezhao.ldz on 11/19/15.
 * Email : dezhao.ldz@alibaba-inc.com
 */
public class Navbar extends BaseScreen {


    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        return null;
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }
    private void setAdminInfo(Context context)throws XException{
        User user = (User) session.getAttribute("user");
        if(user.role().value().equals(Role.ADMIN.value())) {
            AdminDO admin = (AdminDO) user;
            context.put("admin", admin);

        }
    }
}

