package com.X.biz.student.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.common.Void;
import com.X.biz.exception.XException;
import com.X.biz.student.manager.IStudentDBManager;
import com.X.biz.student.manager.IStudentProfileManager;
import com.X.dal.domain.StudentDO;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 11:22 PM
 **/
@Service("studentProfileManager")
public class StudentProfileManager implements IStudentProfileManager {
    @Autowired
    private IStudentDBManager studentDBManager;

    @Override
    public void loginWithEmail(@NotEmpty  String email,@NotEmpty String password) throws XException {

    }

    @Override
    public void loginWithStudentID(final String studentID, @NotEmpty final String password, final HttpSession session) throws XException {
        RunWrapper.run(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                StudentDO student = studentDBManager.queryStudentByStuID(studentID);
                if (student == null) throw new RuntimeException("学号不存在!");
                else {
                    if (password.equals(student.getPassword()))
                        session.setAttribute("user", student);
                    else
                        throw new XException("密码错误");
                }

                return Void.instance;
            }
        });

    }

    @Override
    public void register(@NotEmpty final String email, @NotEmpty final String studentID,
                         @NotEmpty final String studentName, @NotEmpty final String password) throws XException {
        RunWrapper.run(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                StudentDO student = studentDBManager.queryStudentByStuID(studentID);
                if (student == null) {
                    student = new StudentDO();
                    student.setStudentID(studentID)
                            .setEmail(email)
                            .setStudentName(studentName)
                            .setPassword(password)
                            .setGmtCreate(new Date());
                    studentDBManager.save(student);
                } else {
                    throw new XException("学生存在,请换一个学号!");
                }
                return Void.instance;
            }

        });
    }
}
