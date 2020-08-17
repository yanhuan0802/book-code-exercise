package com.yanhuan.modernjavainaction.cap04;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : yan
 * @Project Name : test
 * @Package Name : com.ikingtech.javashizhan.cap04
 * @Description : 引入流
 * @Creation Date: 2020-03-10 21:52
 * -----------------------------------------------------
 */
public class StreamTest {

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(Collectors.partitioningBy(StreamTest::isPrime));
    }

    public static boolean isPrime(int candidate) {
        int sqrt = (int) Math.sqrt(candidate);
        return IntStream.range(2, sqrt)
                .noneMatch(i -> candidate % i == 0);
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
        int sqrt = (int) Math.sqrt(candidate);
        return primes.stream()
                .takeWhile(i -> i <= sqrt)
                .noneMatch(i -> candidate % i == 0);
    }


    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );
        
//        Logger logger = Logger.getAnonymousLogger();
//        logger.finer();
//        Integer collect1 = menu.stream().mapToInt(Dish::getCalories).sum();
//        System.out.println(collect1);
//        ArrayList<Object> collect1 = menu.stream().collect(ArrayList::new, List::add, List::addAll);
//        System.out.println(collect1);
//        List<Dish> collect1 = menu.stream().collect(new ToListCollector<>());
//        System.out.println(collect1);
//        Map<Boolean, Dish> collect = menu.stream()
//                .collect(Collectors
//                        .partitioningBy(
//                                Dish::isVegetarian,
//                                Collectors.collectingAndThen(
//                                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
//                                        Optional::get)));
//        System.out.println(collect);
//        Map<Boolean, Map<Dish.Type, List<Dish>>> collect = menu.stream()
//                .collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
//        System.out.println(collect);

//        Map<Dish.Type, Dish> collect = menu.stream()
//                .collect(Collectors.toMap(Dish::getType, Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(Dish::getCalories))));

//        Map<Dish.Type, Optional<Dish>> collect = menu.stream()
//                .collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
//        System.out.println(collect);
//        Map<Dish.Type, Long> collect = menu.stream()
//                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
//        System.out.println(collect);

//        Map<Dish.Type, List<String>> collect = menu.stream()
//                .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toList())));

//        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> collect = menu.stream().collect(
//                Collectors.groupingBy(Dish::getType,
//                        Collectors.groupingBy(dish -> {
//                            if (dish.getCalories() < 400) {
//                                return CaloricLevel.DIET;
//                            } else if (dish.getCalories() <= 700) {
//                                return CaloricLevel.NORMAL;
//                            } else {
//                                return CaloricLevel.FAT;
//                            }
//                        })
//                )
//        );
//        System.out.println(collect);
//        Map<Dish.Type, List<Dish>> collect = menu.stream()
//                .collect(Collectors.groupingBy(Dish::getType,
//                        Collectors.filtering(dish -> dish.getCalories() > 500, Collectors.toList())));
//        System.out.println(collect);
//        Map<Dish.Type, List<String>> collect = menu.stream()
//                .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toList())));
//        System.out.println(collect);
//        Map<Dish.Type, List<Dish>> collect = menu.stream()
//                .filter(dish -> dish.getCalories() > 500)
//                .collect(Collectors.groupingBy(Dish::getType));
//        System.out.println(collect);
//        Map<CaloricLevel, List<Dish>> collect = menu.stream()
//                .collect(Collectors.groupingBy(dish -> {
//                    if (dish.getCalories() < 400) {
//                        return CaloricLevel.DIET;
//                    } else if (dish.getCalories() <= 700) {
//                        return CaloricLevel.NORMAL;
//                    } else {
//                        return CaloricLevel.FAT;
//                    }
//                }));
//        System.out.println(collect);
//        Map<Dish.Type, List<Dish>> collect = menu.stream()
//                .collect(Collectors.groupingBy(Dish::getType));
//        System.out.println(collect);
//        Optional<Dish> collect = menu.stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);
//        System.out.println(collect);
//        Integer collect = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
//        System.out.println(collect);
//        Integer collect = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
//        System.out.println(collect);
//        System.out.println("------------");
//        int sum = menu.stream().mapToInt(Dish::getCalories).sum();
//        System.out.println(sum);
//        String collect = menu.stream()
//                .map(Dish::getName)
//                .collect(Collectors.joining(", "));
//        System.out.println(collect);
//        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
//        System.out.println(collect);
//        Double collect = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
//        System.out.println(collect);
//        Integer collect = menu.stream().mapToInt(Dish::getCalories).sum();
//        System.out.println(collect);
//        Optional<Dish> collect = menu.stream().min(Comparator.comparing(Dish::getCalories));
//        System.out.println(collect.orElse(null));
//        Long collect = menu.stream().count();
//        System.out.println(collect);
//        IntStream intStream = menu.stream()
//                .mapToInt(Dish::getCalories);
//        Stream<Integer> boxed = intStream.boxed();
//        OptionalDouble average = menu.stream()
//                .mapToInt(Dish::getCalories)
//                .average();
//        if (average.isPresent()) {
//            System.out.println(average.getAsDouble());
//        }
        //        Integer integer = menu.stream()
//                .findFirst()
//                .filter(Dish::isVegetarian)
//                .map(Dish::getCalories)
//                .reduce(Integer::sum)
//                .orElse(0);
//        System.out.println(integer);
//        Integer reduce = menu.stream()
//                .map(dish -> 1)
//                .reduce(0, Integer::sum);
//        System.out.println(reduce);
//        Integer integer = CollUtil.toList(1, 2, 3, 4, 5)
//                .stream()
//                .reduce(Integer::min)
//                .orElse(0);
//        System.out.println(integer);
//                .stream()
//                .reduce(1, (a, b) -> a * b);
//        System.out.println(reduce);
//                .stream()
//                .reduce(0, Integer::sum);
//        System.out.println(sum);
//                .stream()
//                .map(i -> i * i)
//                .filter(i -> i % 3 == 0)
//                .findFirst()
//                .ifPresent(System.out::println);
//         menu.stream()
//                .filter(Dish::isVegetarian)
//                .findAny()
//                .ifPresent(System.out::println);
//        System.out.println(dish);
//        boolean b = menu.stream()
//                .noneMatch(dish -> dish.getCalories() > 1000);
//        System.out.println(b);
//        boolean b = menu.stream()
//                .allMatch(dish -> dish.getCalories() > 500);
//        System.out.println(b);
//        boolean b = menu.stream()
//                .anyMatch(Dish::isVegetarian);
//        System.out.println(b);
//        ArrayList<Integer> nums1 = CollUtil.toList(1, 2, 3);
//        ArrayList<Integer> nums2 = CollUtil.toList(3, 4);
//        nums1.stream()
//                .flatMap(i -> nums2.stream()
//                        //.filter(j -> (i + j) % 3 == 0)
//                        .map(j -> new int[]{i, j}))
//                .collect(Collectors.toList())
//                .forEach(ints -> Arrays.stream(ints)
//                        .forEach(System.out::println));
//        List<Integer> collect = CollUtil.toList(1, 2, 3, 4, 5)
//                .stream()
//                .map(integer -> integer * integer)
//                .collect(Collectors.toList());
//        System.out.println(collect);

        //        List<String> collect = CollUtil.toList("Hello", "World")
//                .stream()
//                .map(s -> s.split(""))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(collect);
//        List<Stream<String>> collect = CollUtil.toList("Hello", "World")
//                .stream()
//                .map(s -> s.split(""))
//                .map(Arrays::stream)
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(collect);

//        List<Integer> collect = menu.stream()
//                .map(Dish::getName)
//                .map(String::length)
//                .collect(Collectors.toList());
//        System.out.println(collect);
//        List<Dish> collect = menu.stream()
//                .takeWhile(dish -> dish.getCalories() < 320)
//                .collect(Collectors.toList());
//        System.out.println(collect);
//        List<Dish> collect = menu.stream()
//                .filter(dish -> dish.getType() == Dish.Type.MEAT)
//                .limit(2)
//                .collect(Collectors.toList());
//        System.out.println(collect);
//        List<Integer> integers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
//        integers.stream()
//                .filter(integer -> integer % 2 == 0)
//                .distinct()
//                .forEach(System.out::println);
//        List<Dish> collect = menu.stream()
//                .filter(Dish::isVegetarian)
//                .collect(Collectors.toList());
//        System.out.println(collect);

        //        List<String> collect = menu.stream()
//                .filter(dish -> dish.getCalories() > 300)
//                .map(Dish::getName)
//                .collect(Collectors.toList());
        //调试查看中间过程
//        List<String> highDishNames = menu.stream()
//                .filter(dish -> {
//                    System.out.println("filtering:" + dish.getName());
//                    return dish.getCalories() > 300;
//                })
//                .map(dish -> {
//                    System.out.println("mapping:" + dish.getName());
//                    return dish.getName();
//                })
//                .limit(3)
//                .collect(Collectors.toList());
//        System.out.println(highDishNames);
        List<Integer> collect = Stream.of("modern", "Java", "in", "action")
                .map(String::length)
                .collect(Collectors.toList());
//        System.out.println(collect);
        //流只能被消费一次
//        stream.forEach(System.out::println);
        //       stream.forEach(System.out::println);
    }
}
