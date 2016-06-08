package com.X.web.module.student.listener;

import com.alibaba.citrus.service.requestcontext.session.SessionConfig;
import com.alibaba.citrus.service.requestcontext.session.SessionLifecycleListener;

import javax.servlet.http.HttpSession;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-01 PM4:28
 **/
public class UserOnlineCounter implements SessionLifecycleListener {
    private static long onlineNum = 0;

    @Override
    public void sessionCreated(HttpSession session) {
        onlineNum++;
    }

    @Override
    public void sessionInvalidated(HttpSession session) {
        onlineNum--;
    }

    @Override
    public void sessionVisited(HttpSession session) {

    }

    @Override
    public void init(SessionConfig sessionConfig) {

    }

    public long getOnlineNum() {
        return onlineNum;
    }
}
