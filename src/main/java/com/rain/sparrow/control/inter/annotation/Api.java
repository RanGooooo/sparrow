package com.rain.sparrow.control.inter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Api {

    /**描述*/
    String description() default "";

    /**接口类型*/
    String type() default ApiConstant.API_TYPE_01;
}
