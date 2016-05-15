package com.X.dal.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 3:09 PM
 **/
public class CourseCategoryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    /**
     * 节点名
     */
    private String name;
    /**
     * 支持继承
     */
    private long parentID;

    /**
     * 节点描述
     */
    private String description;



    private Date gmtCreate;

    private Date gmtModified;

    private String status;

    public long getId() {
        return id;
    }

    public CourseCategoryDO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseCategoryDO setName(String name) {
        this.name = name;
        return this;
    }

    public long getParentID() {
        return parentID;
    }

    public CourseCategoryDO setParentID(long parentID) {
        this.parentID = parentID;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CourseCategoryDO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public CourseCategoryDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public CourseCategoryDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public CourseCategoryDO setStatus(String status) {
        this.status = status;
        return this;
    }
}
