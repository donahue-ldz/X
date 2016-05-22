package com.X.common.utils;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import javax.annotation.CheckReturnValue;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by dezhao.ldz on 11/3/15.
 * Email : dezhao.ldz@alibaba-inc.com
 */
@CheckReturnValue
public class Tool {
    /**
     * 返回标准的UUID字符串
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 返回UUID字符串，长度为32个字符
     */
    public static String getUUID32() {
        String uuid = getUUID();
        return uuid.replace("-", "");
    }

    public static String getUUID16() {
        return getUUID32().substring(16);
    }

    /**
     * 返回36位原始UUID
     *
     * @param s
     * @return
     */
    public static String parseUUID(String s) {
        if (s.length() != 32 || s.indexOf("_") != -1)
            throw new IllegalArgumentException("Invalid string: " + s);
        else {
            StringBuffer buffer = new StringBuffer();
            buffer.append(s.substring(0, 8)).append("-").append(s.substring(8, 12)).append("-")
                    .append(s.substring(12, 16)).append("-").append(s.substring(16, 20)).append("-")
                    .append(s.substring(20, 32));
            return buffer.toString();

        }

    }

    public static boolean hasElement(Collection e) {
        return e != null && !e.isEmpty();
    }

    public static <K, V> Map<K, V> toLinkedMap(List<K> list) {
        Map<K, V> map = Maps.newLinkedHashMap();
        for (K k : list) {
            map.put(k, null);
        }
        return map;
    }

    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static <T> List<T> Set2List(Set<T> set) {
        List<T> list = Lists.newArrayList();
        list.addAll(set);
        return list;
    }

    public static boolean isCn(String s) {
        Pattern ALLOWS = Pattern.compile("^[a-zA-Z0-9_]+$");
        if (!ALLOWS.matcher(s).matches()) {
            return true;
        }
        return false;
    }

    public static boolean containUpperCase(String s) {
        Pattern ALLOWS = Pattern.compile("^[a-z0-9_]+$");
        if (ALLOWS.matcher(s).matches()) {
            return false;
        }
        return true;
    }

    public static String UTF8EncodeURL(String s) {
        String encodeStr = null;
        try {
            encodeStr = URLEncoder.encode(s, Charsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            // java platform support utf8
        }
        return encodeStr;
    }

    public static String UTF8DecodeURL(String s) {
        String decodeStr = null;
        try {
            decodeStr = URLDecoder.decode(s, Charsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            // java platform support utf8
        }
        return decodeStr;
    }

    public static <T> List<T> safeList(List<T> list) {
        return list != null ? list : Lists.<T>newArrayList();
    }

    public static String getRequestIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


}