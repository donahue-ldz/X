package com.X.biz.common;

import com.X.biz.exception.XException;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by donahue on 5/11/16.
 */
public interface IImageManager {
    String save(File image, HttpServletRequest request) throws XException;
    String save(byte[] imageBytes, HttpServletRequest request) throws XException;

}
