package com.X.dal.domain;

import java.io.Serializable;

/**
 * Created by donahue on 5/6/16.
 */
public class TeacherDO implements Serializable{
    private static final long serialVersionUID = 3630901731174836684L;


    private long id;
    private String teacherID;
    private String email;
    private String nick;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
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
