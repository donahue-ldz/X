package com.X.dal.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by donahue on 5/6/16.
 */
public class StudentDO implements Serializable,User {
    private static final long serialVersionUID = 310308226585247132L;
    private long id;
    /**
     * 学号
     */
    private String studentID;
    /**
     * 学生名
     */
    private String studentName;

    /**
     * 电子邮件
     */
    @NotEmpty
    @Email(message = "电子邮件不合法")
    private String email;
    /**
     * 昵称
     */
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
        return Role.STUDENT;
    }

    public long getId() {
        return id;
    }

    public StudentDO setId(long id) {
        this.id = id;
        return this;
    }

    public String getStudentID() {
        return studentID;
    }

    public StudentDO setStudentID(String studentID) {
        this.studentID = studentID;
        return this;
    }

    public String getStudentName() {
        return studentName;
    }

    public StudentDO setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public StudentDO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNick() {
        return nick;
    }

    public StudentDO setNick(String nick) {
        this.nick = nick;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public StudentDO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public StudentDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public StudentDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
