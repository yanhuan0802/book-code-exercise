package com.yanhuan.modernjavainaction.cap02;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : yan
 * @Project Name : test
 * @Package Name : com.ikingtech.javashizhan.cap02
 * @Description :
 * @Creation Date: 2020-02-04 11:45
 * <p>
 * -----------------------------------------------------
 */
public class LambdaPractice {
    public static void main(String[] args) {
//        List<String> list = Stream
//                .of("1", "2", "bilibili", "of", "codesheep", "5", "at", "BILIBILI", "codesheep", "23", "CHEERS", "6")
//                .collect(Collectors.toList());
//        final String collect = list.stream()
//                .map(String::toLowerCase)
//                .filter(i -> i.length() >= 5)
//                .filter(i -> !isNum(i))
//                .distinct()
//                .sorted(Comparator.naturalOrder())
//                .collect(Collectors.joining("❤"));
//        System.out.println(collect);
//        Consumer c = System.out::println;
    }

    public static Boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
