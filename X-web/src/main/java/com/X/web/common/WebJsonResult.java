package com.X.web.common;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebJsonResult<T>  extends Result {

	private T obj;

    private List<T> objList;

    private String errorCode;

    private Map<String,Object> otherData=new HashMap<String,Object>();

    public WebJsonResult() {

    }

    public T getObj() {
        return obj;
    }

    public WebJsonResult<T> setObj(T obj) {
        this.obj = obj;
        return this;
    }

    public List<T> getObjList() {
        return objList;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public WebJsonResult setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public WebJsonResult<T> setObjList(List<T> objList) {
        this.objList = objList;
        return this;
    }

    public Map<String, Object> getOtherData() {
        return otherData;
    }

    public WebJsonResult<T> setOtherData(Map<String, Object> otherData) {
        this.otherData = otherData;
        return this;
    }

    public WebJsonResult<T> setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        success = false;
        return this;
    }
    public WebJsonResult<T> addOtherData(String key, Object obj) {
        this.otherData.put(key,obj);
        return this;
    }

}
