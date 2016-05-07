package com.X.biz;

import com.X.biz.exception.XException;

import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 3:37 PM
 **/
public class RunWrapper{
    public  static <T> T run(Callable<T> callable) throws XException {
        try {
            return callable.call();
        } catch (SQLException sqlEx){
            throw new XException("DB exception,exception: "+sqlEx.getCause());
        }catch (Exception e) {
            throw new XException(e);
        }
    }
}