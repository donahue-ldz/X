package com.X.biz.student.manager;

import com.X.biz.exception.XException;
import org.hibernate.validator.constraints.NotEmpty;

import javax.servlet.http.HttpSession;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 11:21 PM
 **/
public interface IStudentProfileManager {
    void loginWithEmail(@NotEmpty String email,@NotEmpty String password) throws XException;
    void loginWithStudentID(@NotEmpty String studentID,@NotEmpty String password, HttpSession session) throws XException;
    void register(@NotEmpty String email,@NotEmpty String studentID,@NotEmpty String studentName,@NotEmpty String password) throws XException;

}
