package com.yanhuan.modernjavainaction.cap01;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Predicate;


/**
 * @author : yan
 * @Project Name : test
 * @Package Name : com.ikingtech.javashizhan.cap01
 * @Description :
 * @Creation Date: 2020-01-16 23:32
 * -----------------------------------------------------
 */
public class FilterApples {

    private static ExecutorService executorService = Executors.newCachedThreadPool();


    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(120, "black")
        );
        Apple redApple = new Apple(120, "red");

        inventory.sort(Comparator.comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));
//        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        //System.out.println(inventory);
        //List<Apple> apples = filterApples(inventory, apple -> apple.getWeight() > 150);
        //List<Apple> apples = filterApples(inventory, apple -> "green".equals(apple.getColor()) && apple.getWeight() > 150);
//        List<Apple> apples = inventory.stream().filter(apple -> apple.getWeight() > 150).collect(Collectors.toList());

        //System.out.println(apples);
        //prettyPrintApple(inventory, apple -> apple.getWeight() > 150 ? "heavy" : "light");
        //prettyPrintApple(inventory,apple -> "green".equals(apple.getColor())?"green":"other");


        //集合中的元素比较  用comparator排序
        //inventory.sort(Comparator.comparing(Apple::getColor).thenComparing(Apple::getWeight));

        //用runnable执行代码块
        //new Thread(() -> System.out.println("hello world")).start();

        //通过callable返回结果
        //Future<String> threadName = executorService.submit(() -> Thread.currentThread().getName());

        //GUI事件处理
        Button button = new Button("Send");
    }


    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        //传进来一个判断型的函数式接口   调用方法时  要传入实现test方法的逻辑
        ArrayList<Apple> result = new ArrayList<>();
        inventory.forEach(apple -> {
            if (p.test(apple)) {
                result.add(apple);
            }
        });
        return result;
    }

    private static void prettyPrintApple(List<Apple> inventory, AppleFormatter<Apple> a) {
        inventory.forEach(apple -> {
            String accept = a.accept(apple);
            System.out.println(accept);
        });
    }
}
