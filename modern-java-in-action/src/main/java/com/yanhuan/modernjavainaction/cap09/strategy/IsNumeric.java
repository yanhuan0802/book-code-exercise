package com.yanhuan.modernjavainaction.cap09.strategy;

/**
 * 校验数字
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class IsNumeric implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
