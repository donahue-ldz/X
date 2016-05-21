package com.X.biz.student.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.StudentDO;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 3:18 PM
 **/
public interface IStudentDBManager {
    long save(StudentDO student) throws XException;
    void updateStudentByID(Long id,StudentDO student) throws XException;
    StudentDO queryStudentByStuID(String stuID) throws XException;
    StudentDO queryStudentByEmail(String email) throws XException;
    StudentDO queryStudentByID(Long id) throws XException;
    List<StudentDO> queryAllStudents()throws XException;
}
