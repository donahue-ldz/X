package com.X.dal.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 所有图片的存储,为了以后图片的分离
 * 类似图片空间
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 9:07 AM
 **/
public class PictureDO implements Serializable{

    private static final long serialVersionUID = -6973322955273348482L;

    private long id;
    /**
     * 图片描述
     */
    private String alt;
    /**
     * 图片存取的URL
     */
    private String url;
    /**
     * 图片的状态
     */
    private String status;

    private Date gmtCreate;
    private Date gmtModified;

    public long getId() {
        return id;
    }

    public PictureDO setId(long id) {
        this.id = id;
        return this;
    }

    public String getAlt() {
        return alt;
    }

    public PictureDO setAlt(String alt) {
        this.alt = alt;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureDO setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public PictureDO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public PictureDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public PictureDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
