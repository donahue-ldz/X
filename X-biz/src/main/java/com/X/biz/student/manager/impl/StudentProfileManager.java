package com.X.biz.student.manager.impl;

import com.X.biz.exception.XException;
import com.X.biz.student.manager.IStudentDBManager;
import com.X.biz.student.manager.IStudentProfileManager;
import com.X.dal.domain.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 11:22 PM
 **/
@Service("studentProfileManager")
public class StudentProfileManager implements IStudentProfileManager {
    @Autowired
    private IStudentDBManager studentDBManager;

    @Override
    public void loginWithEmail(String email) throws XException {

    }

    @Override
    public void loginWithStudentID(String studentID, HttpSession session) throws XException {
        StudentDO student = studentDBManager.queryStudentByStuID(studentID);
        if(student==null) throw new RuntimeException("学号不存在!");
        session.setAttribute(studentID,student);
    }

    @Override
    public void register(String email, String studentID, String studentName) throws XException {
        StudentDO student = studentDBManager.queryStudentByStuID(studentID);
        if(student==null) {
            student = new StudentDO();
            student.setStudentID(studentID).setEmail(email).setStudentName(studentName);
            studentDBManager.save(student);
        }else {
            throw new RuntimeException("学生存在,请换一个学号!");
        }

    }
}
