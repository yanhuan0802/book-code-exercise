package com.yanhuan.modernjavainaction.cap03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * @author : yan
 * @Project Name : test
 * @Package Name : com.ikingtech.javashizhan.cap03
 * @Description :
 * @Creation Date: 2020-01-19 22:56
 * -----------------------------------------------------
 */
public class LambdaTest {
    public static void main(String[] args) throws Exception {
//         final String s = processFile((BufferedReader br) -> br.readLine() + br.readLine());
//        final List<String> strings = new ArrayList<>();
//        final List<String> filter = filter(strings, s -> !s.isEmpty());
//        System.out.println(filter);
//        List<String> str = Arrays.asList("a", "b", "A", "B");
//        str.sort(String::compareToIgnoreCase);
//        Function<Integer, Integer> f = x -> x + 1;
//        Function<Integer, Integer> g = x -> x * 2;
//        Function<Integer, Integer> h = f.compose(g);
//        Integer result = h.apply(1);
//        System.out.println(result);

        DoubleUnaryOperator doubleDoubleFunction = (double x) -> x + 10;
        double integrate = integrate(doubleDoubleFunction, 3, 7);
        System.out.println(integrate);
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        return (f.applyAsDouble(a) + f.applyAsDouble(b)) * (b - a) / 2.0;
    }

    public static String processFile(BufferReaderProcessor p) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        final List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }
}
