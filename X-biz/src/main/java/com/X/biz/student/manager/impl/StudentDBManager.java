package com.X.biz.student.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.admin.vo.RegisterCountVO;
import com.X.biz.exception.XException;
import com.X.biz.student.manager.IStudentDBManager;
import com.X.common.validator.ValidateHelper;
import com.X.common.validator.ValidationResult;
import com.X.dal.domain.StudentDO;
import com.X.dal.mapper.StudentMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import static com.X.common.utils.Tool.safeList;

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
        studentMapper.updateStudentByID(id, student);
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

    @Override
    public List<StudentDO> queryAllStudents() throws XException {
        return RunWrapper.run(new Callable<List<StudentDO>>() {
            @Override
            public List<StudentDO> call() throws Exception {
                return safeList(studentMapper.queryAllStudents());
            }
        });
    }

    public List<RegisterCountVO> registerReport(final Date fromDay, final Date toDay) throws XException {
        return RunWrapper.run(new Callable<List<RegisterCountVO>>() {
            @Override
            public List<RegisterCountVO> call() throws Exception {
                SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>() {
                    @Override
                    synchronized protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy-MM-dd");
                    }
                }.get();
                List<HashMap> maps = studentMapper.registerReport(format.format(fromDay), format.format(toDay));
                List<RegisterCountVO> registerCountVOs = Lists.newArrayList();
                Calendar endCal = Calendar.getInstance();
                endCal.setTime(toDay);
                Calendar fromCal = Calendar.getInstance();
                fromCal.setTime(fromDay);
                while (!fromCal.after(endCal)) {
                    boolean isExist = false;
                    for (HashMap map : maps) {
                        if (map.get("time").equals(format.format(fromCal.getTime()))) {
                            isExist = true;
                            RegisterCountVO vo = new RegisterCountVO((String)map.get("time"), (Long)map.get("registerNum"));
                            registerCountVOs.add(vo);
                        }
                    }
                    if (!isExist) {
                        registerCountVOs.add(new RegisterCountVO(format.format(fromCal.getTime()), 0L));
                    }
                    fromCal.add(Calendar.DAY_OF_MONTH, 1);

                }
                return registerCountVOs;

            }
        });
    }

}
