package com.X.dal.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by donahue on 5/6/16.
 */
public class AdminDO implements Serializable,User {
    private static final long serialVersionUID = -3500879575645892867L;
    private long id;
    /**
     * 电子邮件
     */
    @NotEmpty
    @Email(message = "email illegal")
    private String email;

    /**
     * 姓名
     */
    @NotEmpty
    private String adminName;

    /**
     * 头像
     */
    private long avatarID;
    /**
     * 昵称
     */
    @NotEmpty
    private String nick;

    @NotEmpty
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
        return Role.ADMIN;
    }

    @Override
    public Long ID() {
        return id;
    }

    public long getId() {
        return id;
    }

    public AdminDO setId(long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AdminDO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAdminName() {
        return adminName;
    }

    public AdminDO setAdminName(String adminName) {
        this.adminName = adminName;
        return this;
    }

    public long getAvatarID() {
        return avatarID;
    }

    public AdminDO setAvatarID(long avatarID) {
        this.avatarID = avatarID;
        return this;
    }

    public String getNick() {
        return nick;
    }

    public AdminDO setNick(String nick) {
        this.nick = nick;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AdminDO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public AdminDO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public AdminDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public AdminDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
