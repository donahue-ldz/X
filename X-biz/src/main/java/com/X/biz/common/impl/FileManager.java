package com.X.biz.common.impl;

import com.X.biz.common.IFileManager;
import com.google.common.io.Files;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 9:39 PM
 **/
@Service("fileManager")
public class FileManager implements IFileManager{
    @Override
    public void save(byte[] bytes, @NotEmpty String directory, @NotEmpty String fileName) throws Exception {
        File dic = new File(directory);
        if(!dic.exists()) dic.mkdirs();
        File file = new File(dic,fileName);
        Files.write(bytes,file);
    }

    @Override
    public void save(File file, @NotEmpty String directory, @NotEmpty String fileName) throws Exception {
        byte[] bytes = null;
        FileInputStream fis  = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream(4096);
        byte [] buffer = new byte[4096];
        int n;
        while ((n= fis.read(buffer))!=-1){
            bos.write(buffer,0,n);
        }
        fis.close();
        bos.close();
        bytes = bos.toByteArray();
        save(bytes,directory,fileName);
    }
}
