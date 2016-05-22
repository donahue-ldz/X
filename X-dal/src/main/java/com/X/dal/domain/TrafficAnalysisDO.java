package com.X.dal.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-22 10:15 AM
 **/
public class TrafficAnalysisDO implements Serializable {

    private Long id;
    private String ip;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public TrafficAnalysisDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public TrafficAnalysisDO setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public TrafficAnalysisDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public TrafficAnalysisDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
