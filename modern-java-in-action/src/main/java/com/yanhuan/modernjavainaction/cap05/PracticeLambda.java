package com.yanhuan.modernjavainaction.cap05;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : yan
 * @Project Name : test
 * @Package Name : com.ikingtech.javashizhan.cap05
 * @Description : TODO
 * @Creation Date: 2020-03-23 23:54
 * -----------------------------------------------------
 */
public class PracticeLambda {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brain = new Trader("Brain", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brain, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //byte[] decode = Base64.decode("4564");
//        IntSupplier fib = new IntSupplier() {
//            private int previous = 0;
//            private int current = 1;
//            @Override
//            public int getAsInt() {
//                int oldPrevious = this.previous;
//                int nextValue = this.previous + this.current;
//                this.previous = this.current;
//                this.current = nextValue;
//                return oldPrevious;
//            }
//        };
//        IntStream.generate(fib)
//                .limit(10)
//                .forEach(System.out::println);
//        IntStream tows = IntStream.generate(new IntSupplier() {
//            @Override
//            public int getAsInt() {
//                return 2;
//            }
//        });

//        Stream.generate(Math::random)
//                .limit(5)
//                .forEach(System.out::println);
//        IntStream.iterate(0, n -> n < 100, n -> n + 4)
//                .forEach(System.out::println);
//        Stream.iterate(0, n -> n < 100, n -> n + 4)
//                .forEach(System.out::println);
//        Stream.iterate(new int[]{0,1},t->new int[]{t[1],t[0]+t[1]})
//                .limit(20)
//                .map(t->t[0])
//                .forEach(System.out::println);
        //.forEach(ints -> System.out.println(ints[0]+","+ints[1]));
//        Stream.iterate(0, n -> n + 2)
//                .limit(10)
//                .forEach(System.out::println);
        //Files.lines(path) 从文件中读取所有行作为stream
//        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
//            long count = lines.flatMap(line -> Arrays.stream(line.split(" ")))
//                    .distinct()
//                    .count();
//            System.out.println(count);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        int[] numbers = {1,2,3,4,6,2};
//        IntStream stream = Arrays.stream(numbers);
//        int sum = Arrays.stream(numbers).sum();
//        System.out.println(sum);
//        Stream<String> stringStream = Stream.of("config", "home", "user")
//                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));
//        String homeValue = System.getProperty("home");
//        Stream<String> stream = Stream.ofNullable(System.getProperty("home"));
//        Stream<Object> empty = Stream.empty();
//        Stream.of("Modern","Java","In","Action")
//                .map(String::toUpperCase)
//                .forEach(System.out::println);
        //随机生成勾股数
//        List<int[]> collect = IntStream.rangeClosed(1, 100).boxed()
//                .flatMap(a ->
//                        IntStream.rangeClosed(1, 100)
//                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
//                )
//                .limit(5)
//                .collect(Collectors.toList());
//        collect.forEach(ints -> {
//            for (final int anInt : ints) {
//                System.out.print(anInt + "   ");
//            }
//            System.out.println();
//        });

//        List<Integer> collect = IntStream.rangeClosed(1, 100)
//                .boxed()
//                .collect(Collectors.toList());
//        System.out.println(collect);
        //找到交易额最小的交易
//        Optional<Transaction> min = transactions.stream()
//                .min(Comparator.comparing(Transaction::getValue));
//        min.ifPresent(System.out::println);
//        Optional<Transaction> reduce = transactions.stream()
//                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
//        System.out.println(reduce);
        //所有交易中，最高的交易额是多少
//        Integer integer = transactions.stream()
//                .map(Transaction::getValue)
//                .reduce(Integer::max)
//                .orElse(0);
//        System.out.println(integer);
        //打印生活在剑桥的交易员的所有交易额
//        transactions.stream()
//                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
//                .map(Transaction::getValue)
//                .forEach(System.out::println);
//                .reduce(Integer::sum)
//                .orElse(0);
//        System.out.println(integer);
        //有没有交易员是在米兰工作的
//        boolean b = transactions.stream()
//                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
//        System.out.println(b);
        //返回所有交易员的姓名字符串，按字母顺序排序
//        String collect = transactions.stream()
//                .map(Transaction::getTrader)
//                .map(Trader::getName)
//                .distinct()
//                .sorted()
//                .collect(Collectors.joining(","));
//        System.out.println(collect);
        //查找所有来自剑桥的交易员 并按照姓名排序
//        List<Trader> collect = transactions.stream()
//                .map(Transaction::getTrader)
//                .filter(trader -> "Cambridge".equals(trader.getCity()))
//                .distinct()
//                .sorted(Comparator.comparing(Trader::getName))
//                .collect(Collectors.toList());
//        System.out.println(collect);
        //交易员都在哪些不同的城市工作过？
//        List<String> city = transactions.stream()
//                .map(Transaction::getTrader)
//                .map(Trader::getCity)
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(city);
        //找出2011年发生的所有交易，并按照交易额由低到高排序
//        List<Transaction> collect = transactions.stream()
//                .filter(transaction -> transaction.getYear() == 2011)
//                .sorted(Comparator.comparingInt(Transaction::getValue))
//                .collect(Collectors.toList());
//        System.out.println(collect);
    }
}
