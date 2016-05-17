package com.X.dal.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by donahue on 5/6/16.
 */
public class StudentDO implements Serializable,User {
    private static final Long serialVersionUID = 310308226585247132L;
    private Long id;
    /**
     * 学号
     */
    private String studentID;
    /**
     * 学生名
     */
    private String studentName;

    /**
     * 用户头像ID,头像保存在图片空间
     */
    private Long avatarID;
    /**
     * 电子邮件
     */
    @NotEmpty
    @Email(message = "电子邮件不合法")
    private String email;
    /**
     * 昵称
     */
    private String nick;

    /**
     * 密码
     */
    private String password;

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

    @Override
    public Long ID() {
        return id;
    }

    public Long getId() {
        return id;
    }

    public StudentDO setId(Long id) {
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

    public Long getAvatarID() {
        return avatarID;
    }

    public StudentDO setAvatarID(Long avatarID) {
        this.avatarID = avatarID;
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

    public String getPassword() {
        return password;
    }

    public StudentDO setPassword(String password) {
        this.password = password;
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
