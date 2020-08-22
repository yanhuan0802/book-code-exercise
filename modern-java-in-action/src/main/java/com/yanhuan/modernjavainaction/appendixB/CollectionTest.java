package com.yanhuan.modernjavainaction.appendixB;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * 集合API
 *
 * @author YanHuan
 * @date 2020-08-22 10:51
 */
public class CollectionTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Integer count = 0;
        if (map.containsKey("ABC")) {
            count = map.get("ABC");
        }

        Integer integer = map.getOrDefault("ABC", 0);

        //使用LongAdder计算多个值之和
        LongAdder adder = new LongAdder();
        adder.add(10);
        long sum = adder.sum();
        System.out.println(sum);

        //使用LongAccumulator计算多个值之和
        LongAccumulator acc = new LongAccumulator(Long::sum, 0);
        acc.accumulate(10);
        long l = acc.get();
        System.out.println(l);

        //setAll
        int[] evenNumbers = new int[10];
        Arrays.setAll(evenNumbers, i -> i * 2);
        Arrays.stream(evenNumbers).forEach(System.out::println);
    }
}
