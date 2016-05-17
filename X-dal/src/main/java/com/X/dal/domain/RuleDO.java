package com.X.dal.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-06 4:19 PM
 **/
public class RuleDO implements Serializable{

    private long id;
    /**
     * 规则名
     */
    @NotEmpty(message = "积分规则名不能为空")
    private String ruleName;
    /**
     * 规则对应的积分
     */
    @NotNull
    private Long score;
    /**
     * 描述
     */
    private String description;

    /**
     * 规则创建人
     */
    @NotEmpty
    private String creator;

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

    public long getId() {
        return id;
    }

    public RuleDO setId(long id) {
        this.id = id;
        return this;
    }

    public String getRuleName() {
        return ruleName;
    }

    public RuleDO setRuleName(String ruleName) {
        this.ruleName = ruleName;
        return this;
    }

    public Long getScore() {
        return score;
    }

    public RuleDO setScore(Long score) {
        this.score = score;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RuleDO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public RuleDO setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public RuleDO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public RuleDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public RuleDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
