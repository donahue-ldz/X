package com.X.aop.logger;

/**
 * Created by dezhao.ldz on 4/14/16.
 * Email : dezhao.ldz@alibaba-inc.com
 */
public class ConsoleLogger implements LogMaker {
    @Override
    public void log(LogLevel level, LogRecord record) {
        System.err.println("level=[" + level + "]," + record);
    }
}
