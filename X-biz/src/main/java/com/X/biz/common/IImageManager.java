package com.X.biz.common;

import com.X.biz.exception.XException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by donahue on 5/11/16.
 */
public interface IImageManager {
    String save(byte[] imageBytes, HttpServletRequest request) throws XException;
}
