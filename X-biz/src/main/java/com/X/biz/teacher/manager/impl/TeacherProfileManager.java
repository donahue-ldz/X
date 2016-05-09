package com.X.biz.teacher.manager.impl;

import com.X.biz.exception.XException;
import com.X.biz.teacher.manager.ITeacherProfileManager;
import org.springframework.stereotype.Service;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 11:22 PM
 **/
@Service("teacherProfileManager")
public class TeacherProfileManager implements ITeacherProfileManager {
    @Override
    public void loginWithEmail(String email) throws XException {

    }

    @Override
    public void loginWithStudentID(String studentID) throws XException {

    }

    @Override
    public void register(String email, String studentID, String nick, String studentName) throws XException {

    }
}
