package com.X.biz.constant.status;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 9:12 PM
 **/
public enum  RateType {
    /**
     * 点赞
     */
    FAVORITE("1"),
    /**
     * 社交账号分享
     */
    SHARE("2"),
    /**
     * 课程的加入
     */
    JOIN("3"),
    /**
     * 浏览次数
     */
    View("4"),
    /**
     * 收藏
     */
    BOOKMARK("5");

    private String value;

    RateType(String value) {
        this.value = value;
    }
    public String SQLValue(){
        return value;
    }
}
