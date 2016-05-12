package com.X.biz.common.impl;

import com.X.biz.common.IFileManager;
import com.google.common.io.Files;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 9:39 PM
 **/
@Service("fileManager")
public class FileManager implements IFileManager{
    @Override
    public void save(byte[] bytes, String directory, String fileName) throws Exception {
        File dic = new File(directory);
        if(!dic.exists()) dic.mkdir();
        File file = new File(dic,fileName);

        Files.write(bytes,file);
    }
}
