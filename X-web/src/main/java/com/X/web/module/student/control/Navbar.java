package com.X.web.module.student.control;

import com.X.biz.exception.XException;
import com.X.biz.student.wrapper.StudentWrapper;
import com.X.dal.domain.Role;
import com.X.dal.domain.User;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dezhao.ldz on 11/19/15.
 * Email : dezhao.ldz@alibaba-inc.com
 */
public class Navbar extends BaseScreen {

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setUserInfo(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setUserInfo(Context context) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if(user!=null && user.role().SQLValue().equals(Role.STUDENT.SQLValue())) {
            StudentWrapper student = (StudentWrapper) user;
            context.put("studentWrapper", student);

        }
    }
}

