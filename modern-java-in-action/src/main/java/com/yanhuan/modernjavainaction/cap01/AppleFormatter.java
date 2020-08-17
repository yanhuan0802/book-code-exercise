package com.yanhuan.modernjavainaction.cap01;

/**
 * @author : yan
 * @Project Name : test
 * @Package Name : com.ikingtech.javashizhan.cap01
 * @Description :
 * @Creation Date: 2020-01-17 0:28
 * -----------------------------------------------------
 */
@FunctionalInterface
public interface AppleFormatter<T> {
    String accept(T t);
}
