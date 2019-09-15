package com.ann.bronze.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description //TODO
 * @Author latecomer
 * @Date 19:35 2019-09-15
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface MyAnnotation {
    String value() default "default value";
}
