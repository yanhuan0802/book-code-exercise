package com.yanhuan.refactoring.cap06;

/**
 * 提炼函数
 *
 * @author YanHuan
 * @date 2020-09-07 22:34
 */
public class ReorganizeMethod {

    private String name;

    private int quantity;
    private int itemPrice;


    /**
     * old
     *
     * @param amount 数量
     */
    void printOwing(double amount) {
        printBanner();

        //print details
        System.out.println("name:" + name);
        System.out.println("amount:" + amount);
    }

    private void printBanner() {
    }

    void printOwingR(double amount) {
        printBanner();
        printDetails(amount);
    }

    private void printDetails(double amount) {
        System.out.println("name:" + name);
        System.out.println("amount:" + amount);
    }

    /*
     * Replace Temp with Query
     */

    double basePrice() {
        return quantity * itemPrice;
    }

    double replace() {
        double basePrice = quantity * itemPrice;
        if (basePrice > 1000) {
            return basePrice * 0.95;
        } else {
            return basePrice * 0.98;
        }
    }

    double replaceB() {
        if (basePrice() > 1000) {
            return basePrice() * 0.95;
        } else {
            return basePrice() * 0.98;
        }
    }
}
