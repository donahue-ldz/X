package com.X.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dezhao.ldz on 6/18/15.
 * Email : dezhao.ldz@alibaba-inc.com
 */
public class AjaxUtils {
    public static boolean isAjax(HttpServletRequest request) {
        if(request!=null&&"XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")))
            return true;
        return false;
    }


}
