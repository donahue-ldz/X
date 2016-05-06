package com.X.common.cache;

import com.google.common.base.Strings;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class LocalLightCache implements LightCache {
    private static final Object NULL_KEY = new Object();
    private static final Pattern UN_ASCII_CHAR = Pattern.compile("[^\\x20-\\x7E]+");
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final Cache<Object, CacheEntry> cache;
    private final String name;

    //////////////////////////////////////////////////////////

    @Override
    public <T> T get(final String _key, final Callable<T> builder) throws Exception {
        Object key = _key == null ? NULL_KEY : _key;
        return (T) cache.get(key, new Callable<CacheEntry>() {
            @Override
            public CacheEntry call() throws Exception {
                CacheEntry en = new CacheEntry();
                en.gmtCreate = System.currentTimeMillis();
                en.key = _key;
                en.valueBuilder = builder;
                en.value = builder.call();
                return en;
            }
        }).value;
    }

    @Override
    public void flushAll() throws Exception {
        List<CacheEntry> list = Lists.newArrayList(cache.asMap().values());
        for (CacheEntry en : list) {
            log.info("flush: {}.{}", name, getLogStr(en.key));
            en.value = en.valueBuilder.call();
            en.gmtModified = System.currentTimeMillis();
        }
    }

    @Override
    public boolean flush(String key, Object value) throws Exception {
        CacheEntry en = cache.getIfPresent(key);
        if (en == null) return false;
        log.info("flush: {}.{}", name, getLogStr(key));
        en.value = value;
        return true;
    }

    @Override
    public void clear() {
        cache.invalidateAll();
    }

    //////////////////////////////////////////////////////////

    private LocalLightCache(Cache<Object, CacheEntry> cache, String name) {
        this.cache = cache;
        this.name = name;
    }

    public static LightCache createSizeLimit(int size, String name) {
        Cache<Object, CacheEntry> cache = CacheBuilder.newBuilder().maximumSize(size).recordStats().build();
        return new LocalLightCache(cache, name);
    }

    public static LightCache createSizeLimit(String name) {
        return createSizeLimit(1024, name);
    }

    public static LightCache createTimeLimit(int size, int sec, String name) {
        Cache<Object, CacheEntry> cache = CacheBuilder.newBuilder().maximumSize(size).expireAfterWrite(sec, TimeUnit.SECONDS).recordStats().build();
        return new LocalLightCache(cache, name);
    }

    public static LightCache createUnLimit(String name) {
        Cache<Object, CacheEntry> cache = CacheBuilder.newBuilder().recordStats().build();
        return new LocalLightCache(cache, name);
    }

    public static LightCache createDefault(String name) {
        return createTimeLimit(1024, 999, name);
    }

    ///////////////////////////////////////////////////////////////

    private static class CacheEntry {
        public String key;
        public Object value;
        public long gmtCreate;
        public long gmtModified;
        public Callable valueBuilder;
    }

    private static String getLogStr(String key) {
        return Strings.isNullOrEmpty(key) ? "" : UN_ASCII_CHAR.matcher(key).replaceAll(" ");
    }

    @Override
    public String cacheStatus() throws Exception {
        return cache.stats().toString();
    }

    public static void main(String[] args) {
        System.out.println(getLogStr("a\1\2\nddd\1\2\n\3\2\1ss"));
    }
}
