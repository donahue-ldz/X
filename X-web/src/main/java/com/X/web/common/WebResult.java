package com.X.web.common;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

public class WebResult<T> extends Result {
    private List<T> list = Lists.newArrayList();

    private T obj;   //对象结果
    private Map<String, Object> otherData = Maps.newHashMap();

    public Map<String, Object> getOtherData() {
        return otherData;
    }
    public void setOtherData(Map<String, Object> otherData) {
        this.otherData = otherData;
    }

    public void addOtherData(String key, Object obj) {
        this.otherData.put(key, obj);
    }


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}