package com.X.biz.common;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 9:39 PM
 **/
public interface IFileManager {
    void save(byte [] bytes, String directory, String fileName) throws Exception;
}
