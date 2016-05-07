package com.X.dal.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by donahue on 5/6/16.
 */
public class StudentDO implements Serializable {
    private static final long serialVersionUID = 310308226585247132L;
    private long id;
    /**
     * 学号
     */
    private String studentID;
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
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
