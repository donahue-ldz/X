package com.X.biz.common;

import com.X.biz.exception.XException;

import java.io.File;

/**
 * Created by donahue on 5/11/16.
 */
public interface IImageManager {
    String save(File image) throws XException;

}
