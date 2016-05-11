package com.X.biz.common.helper;

import com.X.common.messageDigest.MD5Digest;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 10:16 AM
 **/
public class PasswordHelper {
    public static String md5(String password){
       return MD5Digest.digest32(password);
    }
}
