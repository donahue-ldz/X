package com.X.web.common;

import com.X.biz.exception.CookieNullException;
import com.X.biz.exception.XException;
import com.alibaba.citrus.service.requestcontext.parser.ParserRequestContext;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.TurbineRunData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 定义算法的骨架
 * 针对权限管理
 */
public abstract class BaseScreen {
    protected static final Logger log = LoggerFactory.getLogger(BaseScreen.class);
    @Resource
    protected ParserRequestContext reqContext;
    @Resource
    protected HttpServletRequest request;
    @Resource
    protected HttpServletResponse response;
    @Resource
    protected HttpSession session;
    private ThreadLocal<TurbineRunData> runData = new ThreadLocal<TurbineRunData>();

    protected TurbineRunData getRunData() {
        return runData.get();
    }

    final public void execute(Context context, TurbineRunData runData) {
        this.runData.set(runData);
        WebResult webResult = new WebResult();
        try {
            validateCookies();
            // 判断有没有权限访问页面
            if (!validateAuth()) {
                String authPage = "/error/noPermission.vm";
                runData.setRedirectTarget(authPage);
            } else {
                webResult = handleRequest(context);
            }
        } catch (CookieNullException ex) {

        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            webResult.setErrorMsg(ex.getMessage());
            String errorPage = "/error/error.vm";
            runData.setRedirectTarget(errorPage);
            return;
        }
        context.put("webResult", webResult);
    }

    /**
     * 页面授权验证
     *
     * @return
     */
    protected boolean validateAuth() {
        return true;
    }

    /**
     * 执行请求
     *
     * @return
     */
    protected abstract WebResult handleRequest(Context context) throws Exception;

    /**
     * 获得访问页面所需的权限列表
     *
     * @return
     */
    protected abstract List<String> getPermissionList() throws XException;


    /**
     * 检查cookie 是否有效
     * 没有效将直接不能访问页面，避免一部分cookie失效提示不友好
     *
     * @return
     */
    final protected void validateCookies() throws CookieNullException {
       return ;
    }

    protected com.X.dal.domain.User getUser(){
        return (com.X.dal.domain.User) session.getAttribute("user");
    }
}