package com.X.dal.exception;

/**
 * Created by donahue on 5/6/16.
 */
public class XDaoException extends Exception{

    private static final long serialVersionUID = 2198076290841334919L;

    public XDaoException() {
        super();
    }

    public XDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public XDaoException(String message) {
        super(message);
    }
}
