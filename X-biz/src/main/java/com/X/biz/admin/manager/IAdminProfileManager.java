package com.X.biz.admin.manager;

import com.X.biz.exception.XException;
import org.hibernate.validator.constraints.NotEmpty;

import javax.servlet.http.HttpSession;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 11:21 PM
 **/
public interface IAdminProfileManager {
    void loginWithEmail(@NotEmpty String email, @NotEmpty String password, HttpSession session) throws XException;

}
