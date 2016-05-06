package com.X.dal.domain;

import java.io.Serializable;

/**
 * Created by donahue on 5/6/16.
 */
public class StudentDO implements Serializable {
    private static final long serialVersionUID = 310308226585247132L;
    private long id;
    private String studentID;
    private String email;
    private String nick;

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
