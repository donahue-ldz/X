package com.X.dal.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-21 8:11 PM
 **/
public class GrantCreditDO implements Serializable {

    private Long id;
    /**
     * 多个积分规则用|分割
     */
    private String rules;
    @NotNull
    private Long scores;
    /**
     * 学号
     */
    private String studentID;

    private String creator;
    private String description;

    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public GrantCreditDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRules() {
        return rules;
    }

    public GrantCreditDO setRules(String rules) {
        this.rules = rules;
        return this;
    }

    public Long getScores() {
        return scores;
    }

    public GrantCreditDO setScores(Long scores) {
        this.scores = scores;
        return this;
    }

    public String getStudentID() {
        return studentID;
    }

    public GrantCreditDO setStudentID(String studentID) {
        this.studentID = studentID;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public GrantCreditDO setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GrantCreditDO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public GrantCreditDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public GrantCreditDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
