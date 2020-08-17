package com.yanhuan.modernjavainaction.cap07;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 并行流
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class ParallelStreamTest {
    public static long seSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long forkJoinSum(long n) {
        long[] longs = LongStream.rangeClosed(1, n)
                .toArray();
        ForkJoinSumCalculator task = new ForkJoinSumCalculator(longs);
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args) {
        //System.out.println(seSum(10));
//        int i = Runtime.getRuntime().availableProcessors();
//        System.out.println(i);
        List<String> sdf = List.of("sdf", "dasg");
//        Collections.sort(sdf, Comparator.comparing(String::toString).reversed());

    }

}
