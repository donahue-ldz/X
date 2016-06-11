package com.X.dal.mapper;

import com.X.dal.domain.StudentDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by donahue on 5/6/16.
 */
@Repository
public interface StudentMapper {
    long save(StudentDO student);
    void updateStudentByID(@Param("id") final Long id,@Param("student") StudentDO student);
    StudentDO queryStudentByStuID(@Param("studentID") String stuID);
    StudentDO queryStudentByEmail(@Param("email") String email);
    StudentDO queryStudentByID(@Param("id") Long id);
    List<StudentDO> queryAllStudents();
    List<HashMap> registerReport(@Param("fromDay")String fromDays, @Param("toDay")String toDay);

}
