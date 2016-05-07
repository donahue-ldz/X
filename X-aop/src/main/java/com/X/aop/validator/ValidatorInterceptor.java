package com.X.aop.validator;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static com.google.common.collect.Iterables.getFirst;

/**
 * Created by dezhao.ldz on 4/14/16.
 * Email : dezhao.ldz@alibaba-inc.com
 */
public class ValidatorInterceptor implements MethodInterceptor {
    private final Validator validator;

    public ValidatorInterceptor() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        for (Object argument : arguments) {
            Set<ConstraintViolation<Object>> constraintViolations = validator.validate(argument);
            ConstraintViolation<Object> constraintViolation = getFirst(constraintViolations, null);
            if (constraintViolation == null) continue;
            throw new ValidationException(constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
        }
        return methodInvocation.proceed();

    }
}
