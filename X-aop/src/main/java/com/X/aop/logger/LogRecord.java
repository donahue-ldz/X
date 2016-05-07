package com.X.aop.logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * Created by dezhao.ldz on 4/13/16.
 * Email : dezhao.ldz@alibaba-inc.com
 */
public class LogRecord {

    @JSONField(name = "class")
    private Class className;
    @JSONField(name = "method")
    private String methodSignature;
    private Map<String,Object> params;

    @JSONField(serialize = false)
    private Throwable throwable;
    private Object returnValue;
    private long TotalExecMillis;

    private String state;   //status:success|fail

    public Class getClassName() {
        return className;
    }

    public LogRecord setClassName(Class className) {
        this.className = className;
        return this;
    }

    public String getMethodSignature() {
        return methodSignature;
    }

    public LogRecord setMethodSignature(String methodSignature) {
        this.methodSignature = methodSignature;
        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public LogRecord setParams(Map<String, Object> params) {
        this.params = params;
        return this;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public LogRecord setThrowable(Throwable throwable) {
        this.throwable = throwable;
        return this;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public LogRecord setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
        return this;
    }

    public long getTotalExecMillis() {
        return TotalExecMillis;
    }

    public LogRecord setTotalExecMillis(long totalExecMillis) {
        TotalExecMillis = totalExecMillis;
        return this;
    }

    public String getState() {
        return state;
    }

    public LogRecord setState(String state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, true);
    }

    public static final String STATUS_SUCCESS = "success";
    public static final String STATUS_FAIL = "fail";

}
