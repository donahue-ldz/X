package com.X.web.common;


import com.alibaba.citrus.service.requestcontext.parser.ParserRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.Callable;

public abstract class BaseAction {
    private static final Logger log = LoggerFactory.getLogger(BaseAction.class);
    @Resource
    protected ParserRequestContext context;
    @Resource
    protected HttpServletRequest request;
    @Resource
    protected HttpSession session;
    @Resource
    protected HttpServletResponse response;

    protected WebJsonResult runWrapper(Callable<WebJsonResult> callable) {
        WebJsonResult result = new WebJsonResult();
        try {
            return callable.call();
        } catch (Exception e) {
            if (log.isWarnEnabled()) {
                log.warn(e.getMessage(), e);
            }
            if (e.getCause() != null)
                result.setErrorMsg(e.getCause().toString());
            else
                result.setErrorMsg(e.getMessage());
            return result;
        }
    }




}