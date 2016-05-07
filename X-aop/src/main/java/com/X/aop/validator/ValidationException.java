package com.X.aop.validator;

/**
 * Created by dezhao.ldz on 4/14/16.
 * Email : dezhao.ldz@alibaba-inc.com
 */
public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = -7656428040935050265L;

    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ValidationException(Throwable throwable) {
        super(throwable);
    }

    ;

}
