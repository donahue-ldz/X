package com.X.biz.student.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.exception.XException;
import com.X.biz.student.manager.IStudentDBManager;
import com.X.common.validator.ValidateHelper;
import com.X.common.validator.ValidationResult;
import com.X.dal.domain.StudentDO;
import com.X.dal.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 3:23 PM
 **/
@Service("studentDBManager")
public class StudentDBManager implements IStudentDBManager {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public long save(final StudentDO student) throws XException {
        ValidationResult validationResult = ValidateHelper.validateEntity(student);
        if (validationResult.isHasErrors())
            throw new XException(validationResult.getErrorMsg().toString());
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                studentMapper.save(student);
                return student.getId();
            }
        });
    }

    @Override
    public void updateStudentByID(Long id, StudentDO student) throws XException {
        studentMapper.updateStudentByID(id,student);
    }

    @Override
    public StudentDO queryStudentByStuID(@NotNull final String stuID) throws XException {
        return RunWrapper.run(new Callable<StudentDO>() {
            @Override
            public StudentDO call() throws Exception {
                return studentMapper.queryStudentByStuID(stuID);
            }
        });
    }

    @Override
    public StudentDO queryStudentByEmail(@NotNull final String email) throws XException {
        return RunWrapper.run(new Callable<StudentDO>() {
            @Override
            public StudentDO call() throws Exception {
                return studentMapper.queryStudentByEmail(email);
            }
        });
    }

    @Override
    public StudentDO queryStudentByID(final Long id) throws XException {
        return RunWrapper.run(new Callable<StudentDO>() {
            @Override
            public StudentDO call() throws Exception {
                return studentMapper.queryStudentByID(id);
            }
        });
    }
}
