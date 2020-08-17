package com.yanhuan.modernjavainaction.cap09.factory;

/**
 * 工厂
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class TestFactory {
    public static void main(String[] args) {
        Product loan = ProductFactory.createProduct("loan");
        System.out.println(loan);
    }
}
