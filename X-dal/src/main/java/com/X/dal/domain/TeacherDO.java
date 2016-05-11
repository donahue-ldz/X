package com.X.dal.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by donahue on 5/6/16.
 */
public class TeacherDO implements Serializable,User {
    private static final long serialVersionUID = 3630901731174836684L;


    private long id;
    /**
     * 教师工号
     */
    @NotEmpty
    private String teacherID;
    /**
     * 教师名
     */
    @NotEmpty
    private String teacherName;

    /**
     * 头像
     */
    private  long avatarID;

    @NotEmpty
    @Email(message = "email illegal")
    private String email;
    @NotEmpty
    private String nick;

    /**
     * 状态
     */
    private String status;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;

    @Override
    public Role role() {
        return Role.TEACHER;
    }

    public long getId() {
        return id;
    }

    public TeacherDO setId(long id) {
        this.id = id;
        return this;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public TeacherDO setTeacherID(String teacherID) {
        this.teacherID = teacherID;
        return this;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public TeacherDO setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public long getAvatarID() {
        return avatarID;
    }

    public TeacherDO setAvatarID(long avatarID) {
        this.avatarID = avatarID;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TeacherDO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNick() {
        return nick;
    }

    public TeacherDO setNick(String nick) {
        this.nick = nick;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TeacherDO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public TeacherDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public TeacherDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
