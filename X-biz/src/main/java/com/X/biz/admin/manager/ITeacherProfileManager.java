package com.X.biz.admin.manager;

import com.X.biz.exception.XException;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 11:21 PM
 **/
public interface ITeacherProfileManager {
    void loginWithEmail(String email) throws XException;
    void loginWithStudentID(String studentID) throws XException;
    void register(String email, String studentID, String nick, String studentName) throws XException;

}
