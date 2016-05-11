package com.X.common.messageDigest;

import java.security.MessageDigest;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 10:39 AM
 **/
public class MD5Digest {
    public static String digest32(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            digest.reset();
            digest.update(data.getBytes("UTF-8"));
            byte[] bytes = digest.digest();
            StringBuffer buffer = new StringBuffer();
            for (byte b : bytes) {
                String toHexStr = Integer.toHexString(b & 0xff);
                buffer.append(
                        toHexStr.length() == 1 ? "0" + toHexStr : toHexStr
                );

            }
            return buffer.toString();
        } catch (Exception e) {
            //
        }
        return null;

    }
    public static String digest16(String data){
        String digest = digest32(data);
        return digest.substring(8,24);
    }

    public static void main(String []args){
        String s = "donahue";
        System.err.println(digest32(s));
    }
}
