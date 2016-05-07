package com.X.aop.logger;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by dezhao.ldz on 4/13/16.
 * Email : dezhao.ldz@alibaba-inc.com
 */
@Target({TYPE, METHOD})
@Retention(RUNTIME)
public @interface Log {
     LogLevel value() default LogLevel.DEBUG;
}
