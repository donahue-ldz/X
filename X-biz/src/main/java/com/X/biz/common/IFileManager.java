package com.X.biz.common;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.File;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 9:39 PM
 **/
public interface IFileManager {
    void save(byte [] bytes, @NotEmpty  String directory, @NotEmpty String fileName) throws Exception;
    void save(File file,@NotEmpty String directory,@NotEmpty String fileName) throws Exception;
}
