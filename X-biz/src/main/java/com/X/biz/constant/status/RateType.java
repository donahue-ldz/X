package com.X.biz.constant.status;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 9:12 PM
 **/
public enum  RateType {
    FAVORITE("1"),SHARE("2"),JOIN("3");
    private String value;

    RateType(String value) {
        this.value = value;
    }
    public String SQLValue(){
        return value;
    }
}
