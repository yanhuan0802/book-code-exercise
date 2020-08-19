package com.yanhuan.modernjavainaction.cap20;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Java和Scala的比较
 *
 * @author YanHuan
 * @date 2020-08-20 0:05
 */
public class CompareScalaDemo {
    static Function<Integer, Integer> multiplyCurry(int x) {
        return (Integer y) -> x * y;
    }

    public static void main(String[] args) {
        Stream.of(1, 3, 5, 7)
                .map(multiplyCurry(2))
                .forEach(System.out::println);
    }
}
