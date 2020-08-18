package com.yanhuan.modernjavainaction.cap19;


import scala.collection.immutable.Range;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Yan
 */
public class TreeProcessor {
    public static int lookup(String k, int defaultVal, Tree t) {
        if (t == null) {
            return defaultVal;
        }
        if (k.equals(t.getKey())) {
            return t.getVal();
        }
        return lookup(k, defaultVal, k.compareTo(t.getKey()) < 0 ? t.getLeft() : t.getRight());
    }

    public static void update(String k, int newVal, Tree t) {
        if (t == null) {
            //增加一个新的节点
            t = new Tree(k, newVal, null, null);
        } else if (k.equals(t.getKey())) {
            t.setVal(newVal);
        } else {
            update(k, newVal, k.compareTo(t.getKey()) < 0 ? t.getLeft() : t.getRight());
        }
    }

    public static Tree fUpdate(String k, int newVal, Tree t) {
        return t == null ?
                new Tree(k, newVal, null, null) :
                k.equals(t.getKey()) ?
                        new Tree(k, newVal, t.getLeft(), t.getRight()) :
                        k.compareTo(t.getKey()) < 0 ?
                                new Tree(t.getKey(), t.getVal(), fUpdate(k, newVal, t.getLeft()), t.getRight()) :
                                new Tree(t.getKey(), t.getVal(), t.getLeft(), fUpdate(k, newVal, t.getRight()));
    }

    static IntStream numbers() {
        return IntStream.iterate(2, n -> n + 1);
    }

    static int head(IntStream numbers) {
        return numbers.findFirst().getAsInt();
    }

    static IntStream tail(IntStream numbers) {
        return numbers.skip(1);
    }

    public static void main(String[] args) {
        LazyList<Integer> numbers = from(2);

        Integer two = numbers.head();
        Integer three = numbers.tail().head();
        Integer four = numbers.tail().tail().head();

        System.out.println(
                Stream.of(two, three, four)
                        .map(String::valueOf)
                        .collect(Collectors.joining(""))
        );


        // MyLinkedList<Integer> l = new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<>()));

//        IntStream numbers = numbers();
//        int head = head(numbers);
//        IntStream filtered = tail(numbers).filter(n -> n % head != 0);
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<Integer>(n, () -> from(n + 1));
    }

    public static MyList<Integer> primes(MyList<Integer> numbers) {
        return new LazyList<>(
                numbers.head(),
                () -> primes(numbers.tail()
                        .filter(n -> n % numbers.head() != 0)
                )
        );
    }

    /**
     * 这个方法会报错  因为对Stream执行了两次终端操作
     * 实际上Stream只能被执行一次终端操作
     *
     * @param numbers
     * @return
     */
    public static IntStream primes(IntStream numbers) {
        int head = head(numbers);
        return IntStream.concat(
                IntStream.of(head),
                primes(tail(numbers).filter(n -> n % head != 0))
        );
    }


    //19.5.1：缓存或记忆表
    final Map<Range, Integer> numberOfNodes = new HashMap<>();

    Integer computeNumberOfNodesUsingCache(Range range) {
//        Integer result = numberOfNodes.get(range);
//        if (result != null) {
//            return result;
//        }
//        result = computeNuberOfNodes(range);
//        numberOfNodes.put(range, result);
//        return result;
        return numberOfNodes.computeIfAbsent(range, this::computeNuberOfNodes);
    }

    private Integer computeNuberOfNodes(Range range) {

        return 1;
    }


}
