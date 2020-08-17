package com.yanhuan.modernjavainaction.cap16;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author Yan
 */
public class Shop {
    public static List<Shop> shops = new ArrayList<>();

    static {
        shops = List.of(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavouriteShop"),
                new Shop("BuyItAll"));
    }

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread(() -> {
//            try {
//                double price = calculatePrice(product);
//                futurePrice.complete(price);
//            } catch (Exception e) {
//                futurePrice.completeExceptionally(e);
//            }
//        }).start();
//        return futurePrice;
    }

    public static void main(String[] args) {
//        Shop shop = new Shop();
        long start = System.nanoTime();
//        Future<Double> futurePrice = shop.getPriceAsync("my favourite product");
//        long invocationTime = (System.nanoTime() - start) / 1000000;
//        System.out.println("invocation returned after " + invocationTime + "ms");
//        System.out.println("------------------");
//        System.out.println("------------------");
//        System.out.println("------------------");
//        Double price = null;
//        try {
//            price = futurePrice.get();
//            System.out.printf("Price is %.2f%n", price);
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
        System.out.println(findPrices("myPhone27S"));
        long retrievalTime = (System.nanoTime() - start) / 1000000;
        System.out.println("Price returned after " + retrievalTime + "ms");
//        int i = Runtime.getRuntime().availableProcessors();
//        System.out.println(i);
    }

    private static final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
            (Runnable r) -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            });


    public String getName() {
        return name;
    }

    public static List<String> findPrices(String product) {
//        return shops.parallelStream()
//                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
//                .collect(Collectors.toList())
//                .stream()
//                .map(CompletableFuture::join)
//                .collect(Collectors.toList());
//        return shops.parallelStream()
//                .map(shop -> shop.getPrice(product))
//                .map(Quote::parse)
//                .map(Discount::applyDiscount)
//                .collect(Collectors.toList());
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

}