package com.X.web.module.student.screen.json;

import com.X.biz.student.manager.IStudentProfileManager;
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
    private IStudentProfileManager studentProfileManager;

    public WebJsonResult doRegister(@Param("studentID") final String studentID,@Param("email")final String email,
                                    @Param("studentName")final String studentName){
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {
                studentProfileManager.register(email,studentID,studentName);
                return new WebJsonResult();
            }
        });
    }
    public WebJsonResult doLogin(@Param("studentID")final String studentID){
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {
                studentProfileManager.loginWithStudentID(studentID,session);
                return new WebJsonResult();
            }
        });
    }

}
