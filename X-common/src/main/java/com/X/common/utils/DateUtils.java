package com.X.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dezhao.ldz on 9/8/15.
 * Email : dezhao.ldz@alibaba-inc.com
 */
public class DateUtils {

    public final static String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>(){
        synchronized protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(NORM_DATETIME_PATTERN);
        };
    };

    public final static SimpleDateFormat NORM_DATETIME_FORMAT = threadLocal.get();


    public static synchronized String currentDate() {
        DateFormat DATE = new SimpleDateFormat("yyyyMMddHHmmss");
        return DATE.format(new Date());
    }

    /**
     * 在base 日期的基础上 加减多少天
     * @param base
     * @param day
     * @return
     */
    public static Date day(Date base,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(base);
        calendar.add(Calendar.DAY_OF_YEAR,day);
        return calendar.getTime();
    }

}
