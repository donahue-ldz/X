package com.X.aop.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by dezhao.ldz on 4/14/16.
 * Email : dezhao.ldz@alibaba-inc.com
 */
public class Log4jLogger implements LogMaker {
    @Override
    public void log(LogLevel level, LogRecord record) {
        switch (level) {

            case DEBUG:
                debug(record.getThrowable(), record);
                break;

            case INFO:
                info(record.getThrowable(), record);
                break;

            case WARN:
                warn(record.getThrowable(), record);
                break;

            case ERROR:
                error(record.getThrowable(), record);
                break;
        }
    }


    private void debug(Throwable throwable, LogRecord record) {

        if (throwable != null) {
            getLogger(record.getClassName()).debug(record.toString() + " Exception --> " + throwable);
        } else {
            getLogger(record.getClassName()).debug(record.toString());
        }
    }

    private void info(Throwable throwable, LogRecord record) {

        if (throwable != null) {
            getLogger(record.getClassName()).info(record.toString() + " Exception --> " + throwable);
        } else {
            getLogger(record.getClassName()).info(record.toString());
        }
    }

    private void warn(Throwable throwable, LogRecord record) {

        if (throwable != null) {
            getLogger(record.getClassName()).warn(record.toString() + " Exception --> " + throwable);
        } else {
            getLogger(record.getClassName()).warn(record.toString());
        }
    }

    private void error(Throwable throwable, LogRecord record) {

        if (throwable != null) {
            getLogger(record.getClassName()).error(record.toString() + " Exception --> " + throwable);
        } else {
            getLogger(record.getClassName()).error(record.toString());
        }
    }


    private Logger getLogger(Class<?> clazz) {

        return LoggerFactory.getLogger(clazz);
    }
}
