package com.X.biz.common;

import com.X.biz.exception.XException;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-15 4:59 PM
 **/
public interface IImageCourseManager {
    long save(byte[] imageBytes) throws XException;

}
