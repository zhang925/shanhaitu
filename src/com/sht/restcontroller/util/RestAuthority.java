package com.sht.restcontroller.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @Description 拦截rest 的权限
 * @author zzy
 * @date 2018年6月7日 22:45:18
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RestAuthority {

    /** 要执行的具体操作比如：添加用户 **/
    public String name() default "";

}
