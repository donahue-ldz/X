package com.X.biz.admin.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.admin.manager.IAdminDBManager;
import com.X.biz.admin.manager.IAdminProfileManager;
import com.X.biz.common.Void;
import com.X.biz.exception.XException;
import com.X.dal.domain.AdminDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 11:22 PM
 **/
@Service("adminProfileManager")
public class AdminProfileManager implements IAdminProfileManager {
    @Autowired
    private IAdminDBManager adminDBManager;

    @Override
    public void loginWithEmail(final String email, final String password, final HttpSession session) throws XException {
        RunWrapper.run(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                AdminDO admin = adminDBManager.queryAdminByEmail(email);
                boolean success = false;
                if (admin != null) {
                    if (password.equals(admin.getPassword())) {
                        session.setAttribute("user", admin);
                        success = true;
                    }

                }
                if (!success)
                    throw new XException("管理员不存在或者密码错误...");
                return Void.instance;
            }
        });
    }

}
