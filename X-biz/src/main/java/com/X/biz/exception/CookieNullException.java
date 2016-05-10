package com.X.biz.exception;

/**
 * Created by dezhao.ldz on 9/21/15.
 * Email : dezhao.ldz@alibaba-inc.com
 */
public class CookieNullException extends XException {
    private static final String EX_MSG = "系统cookie失效,重新登录";
    public CookieNullException() {
        super(EX_MSG);
    }

    public CookieNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public CookieNullException(String message) {
        super(message);
    }
}
