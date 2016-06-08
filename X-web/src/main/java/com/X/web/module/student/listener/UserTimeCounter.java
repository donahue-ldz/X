package com.X.web.module.student.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-01 PM4:27
 **/
public class UserTimeCounter implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.err.println("lasted modified:"+httpSessionEvent.getSession().getLastAccessedTime());
        System.err.println("createTime:"+httpSessionEvent.getSession().getCreationTime());
        System.err.println("user:"+httpSessionEvent.getSession().getAttribute("user"));
    }
}
