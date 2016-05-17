package com.X.biz.student.wrapper;

import com.X.dal.domain.Role;
import com.X.dal.domain.StudentDO;
import com.X.dal.domain.User;

import java.io.Serializable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-15 3:45 PM
 **/
public class StudentWrapper implements Serializable ,User{
    private StudentDO student;
    private String avatarURL;

    public StudentDO getStudent() {
        return student;
    }

    public StudentWrapper setStudent(StudentDO student) {
        this.student = student;
        return this;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public StudentWrapper setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
        return this;
    }

    @Override
    public Role role() {
        return Role.STUDENT;
    }

    @Override
    public Long ID() {
        return student.getId();
    }
}
