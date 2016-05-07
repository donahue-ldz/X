package com.X.aop.logger;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by dezhao.ldz on 4/13/16.
 * Email : dezhao.ldz@alibaba-inc.com
 */

@Aspect
public class LogAspect {
    private LogMaker logMaker;
    private static volatile boolean enabled = true;

    @Around(value = "@annotation(Log)", argNames = "joinPoint,Log")
    public Object logAndExecute(ProceedingJoinPoint joinPoint, Log log) {
        LogRecord record = new LogRecord();
        record.setState(LogRecord.STATUS_SUCCESS);
        enterMethod(joinPoint, record);
        Stopwatch stopwatch = Stopwatch.createStarted();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            record.setThrowable(throwable);
            record.setState(LogRecord.STATUS_FAIL);
        }
        record.setTotalExecMillis(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
        Signature signature = joinPoint.getSignature();
        Class<?> cls = signature.getDeclaringType();
        record.setClassName(cls);
        if (signature instanceof MethodSignature && ((MethodSignature) signature).getReturnType() != void.class) ;
        record.setReturnValue(result);
        log(log.value(), record);
        return result;
    }

    private void enterMethod(JoinPoint joinPoint, LogRecord record) {
        if (!enabled) return;
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        String methodName = codeSignature.getName();
        record.setMethodSignature(methodName);
        String[] parameterNames = codeSignature.getParameterNames();
        Object[] parameterValues = joinPoint.getArgs();
        Map<String, Object> parameters = Maps.newLinkedHashMap();
        for (int i = 0; i < parameterValues.length; i++) {
            parameters.put(parameterNames[i], parameterValues[i]);
        }
        record.setParams(parameters);

    }

    private void log(LogLevel level, LogRecord logRecord) {
        if (!enabled) return;
        logMaker.log(level, logRecord);
    }

    public LogMaker getLogMaker() {
        return logMaker;
    }

    public LogAspect setLogMaker(LogMaker logMaker) {
        this.logMaker = logMaker;
        return this;
    }

    public static void setEnabled(boolean enabled) {
        LogAspect.enabled = enabled;
    }
}
