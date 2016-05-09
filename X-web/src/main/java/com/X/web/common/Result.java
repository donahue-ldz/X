package com.X.web.common;


/**
 * 返回结果
 */
public abstract class Result {
    protected boolean success = true;
    protected String errorMsg;
    protected String errorCode;

    public Result setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Result setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        success=false;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Result setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }
}
