package com.X.biz.admin.vo;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-11 PM3:38
 **/
public class RegisterCountVO {
    private String time;
    private long registerNum;

    public String getTime() {
        return time;
    }

    public RegisterCountVO setTime(String time) {
        this.time = time;
        return this;
    }

    public long getRegisterNum() {
        return registerNum;
    }

    public RegisterCountVO setRegisterNum(long registerNum) {
        this.registerNum = registerNum;
        return this;
    }

    public RegisterCountVO(String time, Long registerNum) {
        this.time = time;
        this.registerNum = registerNum;
    }

    public RegisterCountVO(Object time) {
    }
}
