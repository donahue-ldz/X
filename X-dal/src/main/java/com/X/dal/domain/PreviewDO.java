package com.X.dal.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-26 AM9:35
 **/
public class PreviewDO implements Serializable {
    private long id;
    private String fileName;
    private String content;

    private Date gmtCreate;
    private Date gmtModified;

    public long getId() {
        return id;
    }

    public PreviewDO setId(long id) {
        this.id = id;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public PreviewDO setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PreviewDO setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public PreviewDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public PreviewDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
