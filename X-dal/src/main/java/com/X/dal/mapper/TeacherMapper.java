package com.X.dal.mapper;

import com.X.dal.domain.TeacherDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by donahue on 5/6/16.
 */
@Repository
public interface TeacherMapper {
    long save(TeacherDO teacher);
    TeacherDO queryTeacherBytTeacherID(@Param("teacherID") String teacherID);
    TeacherDO queryAllTeachers();
}
