package com.X.biz.admin.vo;

import com.X.dal.domain.GrantCreditDO;

import java.io.Serializable;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-11 AM10:15
 **/
public class StudentCreditItemVO implements Serializable {

    private Long id;

    private String rules;
    private Long scores;
    /**
     * 学号
     */
    private String creator;
    private String description;

    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public StudentCreditItemVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRules() {
        return rules;
    }

    public StudentCreditItemVO setRules(String rules) {
        this.rules = rules;
        return this;
    }

    public Long getScores() {
        return scores;
    }

    public StudentCreditItemVO setScores(Long scores) {
        this.scores = scores;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public StudentCreditItemVO setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StudentCreditItemVO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public StudentCreditItemVO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public StudentCreditItemVO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }

    public static StudentCreditItemVO convert(GrantCreditDO grantCredit) {
        checkNotNull(grantCredit);
        StudentCreditItemVO vo = new StudentCreditItemVO();
        vo.setId(grantCredit.getId());
        vo.setRules(grantCredit.getRules());
        vo.setScores(grantCredit.getScores());
        vo.setDescription(grantCredit.getDescription());
        vo.setCreator(grantCredit.getCreator());
        vo.setGmtCreate(grantCredit.getGmtCreate());
        vo.setGmtModified(grantCredit.getGmtModified());
        return vo;
    }
}
