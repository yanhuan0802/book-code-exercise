package com.yanhuan.modernjavainaction.cap09.strategy;

/**
 * 校验大写字母
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class IsAllLowerCase implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
