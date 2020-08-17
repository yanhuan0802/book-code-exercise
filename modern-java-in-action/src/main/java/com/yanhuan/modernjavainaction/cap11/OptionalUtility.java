package com.yanhuan.modernjavainaction.cap11;

import java.util.Optional;

/**
 * @author Yan
 */
public class OptionalUtility {
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
