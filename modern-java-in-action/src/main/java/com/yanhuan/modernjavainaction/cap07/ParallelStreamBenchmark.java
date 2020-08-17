package com.yanhuan.modernjavainaction.cap07;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author : yan
 * -----------------------------------------------------
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
public class ParallelStreamBenchmark {

//    @Benchmark
//    public long seSum(long n) {
//        return Stream.iterate(1L, i -> i + 1)
//                .limit(n)
//                //.parallel()
//                .reduce(0L, Long::sum);
//    }
//
//    @TearDown(Level.Invocation)
//    public void tearDown() {
//        System.gc();
//    }
}
