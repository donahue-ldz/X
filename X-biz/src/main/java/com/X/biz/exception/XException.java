package com.X.biz.exception;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-07 3:20 PM
 **/
public class XException extends Exception {
    public XException(){
        super();
    }

    public XException(String message){
        super(message);
    }
    public XException(Throwable throwable){
        super(throwable);
    }
    public XException(String message,Throwable cause){
        super(message,cause);
    }
}
