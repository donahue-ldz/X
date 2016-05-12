package com.X.biz.common.impl;

import com.X.biz.common.IImageManager;
import com.X.biz.exception.XException;
import com.X.biz.system.Config;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 11:05 PM
 **/
@Service("imageManager")
public class ImageManager implements IImageManager {

    @Override
    public String save(File image) throws XException {
        String configDirectory = Config.FILE_UPLOAD_DIRECTORY;
        return null;
    }
}
