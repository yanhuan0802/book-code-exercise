package com.yanhuan.modernjavainaction.appendixA;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 重复注解
 *
 * @author YanHuan
 * @date 2020-08-22 9:54
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Authors {
    Author[] value();
}
