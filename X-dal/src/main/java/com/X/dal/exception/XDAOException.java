package com.X.dal.exception;

/**
 * Created by donahue on 5/6/16.
 */
public class XDAOException extends Exception{

    private static final long serialVersionUID = 2198076290841334919L;

    public XDAOException() {
        super();
    }

    public XDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public XDAOException(String message) {
        super(message);
    }
}
