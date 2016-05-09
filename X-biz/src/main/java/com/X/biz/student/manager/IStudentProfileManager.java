package com.X.biz.student.manager;

import com.X.biz.exception.XException;
import org.hibernate.validator.constraints.NotEmpty;

import javax.servlet.http.HttpSession;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 11:21 PM
 **/
public interface IStudentProfileManager {
    void loginWithEmail(@NotEmpty String email) throws XException;
    void loginWithStudentID(@NotEmpty String studentID, HttpSession session) throws XException;
    void register(String email,String studentID,String studentName) throws XException;

}
