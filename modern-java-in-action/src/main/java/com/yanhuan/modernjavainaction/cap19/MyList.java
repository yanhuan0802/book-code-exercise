package com.yanhuan.modernjavainaction.cap19;

import java.util.function.Predicate;

/**
 * @author Yan
 */
public interface MyList<T> {

    T head();

    MyList<T> tail();

    default boolean isEmpty() {
        return true;
    }

    MyList<T> filter(Predicate<T> p);
}
