package com.X.aop.logger;

/**
 * Created by dezhao.ldz on 4/14/16.
 * Email : dezhao.ldz@alibaba-inc.com
 */
public interface LogMaker {
    void log(LogLevel level,LogRecord record);
}
