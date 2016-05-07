package com.X.biz.admin.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.StudentDO;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 3:18 PM
 **/
public interface IAdminDBManager {
    long save(StudentDO student) throws XException;
    StudentDO queryStudentByStuID(String stuID) throws Exception;
    StudentDO queryStudentByEmail(String email) throws Exception;
}
