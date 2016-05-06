package com.X.common.cache;

import java.util.concurrent.Callable;

/**
 * Created by yunj on 06-08.
 * modified dezhao.ldz
 */
public interface LightCache {

    <T> T get(String key, final Callable<T> builder) throws Exception;

    void flushAll() throws Exception;

    boolean flush(String key, Object value) throws Exception;

    void clear() throws Exception;

    String cacheStatus() throws Exception;
}
