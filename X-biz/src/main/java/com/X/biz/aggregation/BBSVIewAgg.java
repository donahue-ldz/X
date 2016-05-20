package com.X.biz.aggregation;

import com.X.biz.bbs.vo.BBSView;
import com.X.biz.exception.XException;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-19 10:21 PM
 **/
public interface BBSViewAgg {
    BBSView view() throws XException;
}
