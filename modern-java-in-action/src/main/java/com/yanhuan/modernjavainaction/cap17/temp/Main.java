package com.yanhuan.modernjavainaction.cap17.temp;


import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Flow.*;
import java.util.concurrent.TimeUnit;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.LongStream;

/**
 * main类  创建Publisher并向其订阅TempSubscriber
 *
 * @author Yan
 */
public class Main {
    public static void main(String[] args) {
        //创建一个新的纽约温度的Publisher，并向其订阅TempSubscriber事件
//        getCelsiusTemperatures("New York").subscribe(new TempSubscriber());
//        Observable<TempInfo> observable = getTemperature("New York");
//        observable.blockingSubscribe(new TempObserver());

        DoubleUnaryOperator convertCtoF = curriedConverter(9.0 / 5, 32);
        double v = convertCtoF.applyAsDouble(23);
        System.out.println(v);
    }

    private static Publisher<TempInfo> getTemperatures(String town) {
        return subscriber -> subscriber.onSubscribe(new TempSubscription(subscriber, town));
    }

    private static Publisher<TempInfo> getCelsiusTemperatures(String town) {
        return subscriber -> {
            TempProcessor tempProcessor = new TempProcessor();
            tempProcessor.subscribe(subscriber);
            tempProcessor.onSubscribe(new TempSubscription(tempProcessor, town));
        };
    }

    public static Observable<TempInfo> getTemperature(String town) {
        return Observable.create(emitter ->
                Observable.interval(1, TimeUnit.SECONDS)
                        .subscribe(i -> {
                            if (!emitter.isDisposed()) {
                                if (i >= 5) {
                                    emitter.onComplete();
                                } else {
                                    try {
                                        emitter.onNext(TempInfo.fetch(town));
                                    } catch (Exception e) {
                                        emitter.onError(e);
                                    }
                                }
                            }
                        }));

    }


    public static List<List<Integer>> subsets(List<Integer> list) {
        if (list.isEmpty()) {
            ArrayList<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> reset = list.subList(1, list.size());
        List<List<Integer>> subans = subsets(reset);
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);
    }

    public static List<List<Integer>> insertAll(Integer first,
                                                List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            ArrayList<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    public static List<List<Integer>> concat(List<List<Integer>> a,
                                             List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }

    static long factorialIterative(long n) {
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    static long factorialRecursive(long n) {
        return n == 1 ? 1 : n * factorialRecursive(n - 1);
    }

    static long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long a, long b) -> a * b);
    }

    static long factorialHelper(long n) {
        return factorialHelper(1, n);
    }

    static long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n - 1);
    }

    static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }

}
