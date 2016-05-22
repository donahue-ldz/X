package com.X.biz.aggregation;

import com.X.biz.admin.vo.XView;
import com.X.biz.exception.XException;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-22 10:33 AM
 **/
public interface XViewAgg {
    XView view() throws XException;
}
