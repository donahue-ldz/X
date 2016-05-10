package com.X.dal.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 3:09 PM
 **/
public class TopicCategoryDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    /**
     * 支持继承
     */
    private long parentID;

    /**
     * 节点中文名
     */
    private String nameCn;
    /**
     * 节点英文名
     */
    private String nameEn;

    /**
     * 节点描述
     */
    private String desc;


    /**
     * 节点图片
     */
    private String pic;


    private Date gmtCreate;

    private Date gmtModified;

    private String status;

    public long getId() {
        return id;
    }

    public TopicCategoryDO setId(long id) {
        this.id = id;
        return this;
    }

    public long getParentID() {
        return parentID;
    }

    public TopicCategoryDO setParentID(long parentID) {
        this.parentID = parentID;
        return this;
    }

    public String getNameCn() {
        return nameCn;
    }

    public TopicCategoryDO setNameCn(String nameCn) {
        this.nameCn = nameCn;
        return this;
    }

    public String getNameEn() {
        return nameEn;
    }

    public TopicCategoryDO setNameEn(String nameEn) {
        this.nameEn = nameEn;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public TopicCategoryDO setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getPic() {
        return pic;
    }

    public TopicCategoryDO setPic(String pic) {
        this.pic = pic;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public TopicCategoryDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public TopicCategoryDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TopicCategoryDO setStatus(String status) {
        this.status = status;
        return this;
    }
}
