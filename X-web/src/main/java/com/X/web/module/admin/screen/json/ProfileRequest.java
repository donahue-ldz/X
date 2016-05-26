package com.X.web.module.admin.screen.json;

import com.X.biz.admin.manager.IAdminProfileManager;
import com.X.web.common.BaseAction;
import com.X.web.common.WebJsonResult;
import com.alibaba.citrus.turbine.dataresolver.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 11:21 PM
 **/
public class ProfileRequest extends BaseAction{
    @Autowired
    private IAdminProfileManager adminProfileManager;

    public WebJsonResult doLogin(@Param("email")final String email,@Param("password") final String password){
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {
                adminProfileManager.loginWithEmail(email,password,session);
                return new WebJsonResult();
            }
        });
    }

}
