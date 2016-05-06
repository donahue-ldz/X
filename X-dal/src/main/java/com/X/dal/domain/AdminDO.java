package com.X.dal.domain;

import java.io.Serializable;

/**
 * Created by donahue on 5/6/16.
 */
public class AdminDO implements Serializable{

    private static final long serialVersionUID = -3500879575645892867L;

    private long id;
    private String adminID;
    private String email;
    private String nick;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
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
