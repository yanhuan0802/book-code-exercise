package com.yanhuan.modernjavainaction.cap09.strategy;

/**
 * 策略
 *
 * @author : yan
 * -----------------------------------------------------
 */
@FunctionalInterface
public interface ValidationStrategy {
    /**
     * 执行策略
     *
     * @param s 字符串
     * @return 执行结果
     */
    boolean execute(String s);
}
