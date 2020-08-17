package com.yanhuan.modernjavainaction.cap05;

/**
 * @author : yan
 * @Project Name : test
 * @Package Name : com.ikingtech.javashizhan.cap05
 * @Description : TODO
 * @Creation Date: 2020-03-23 23:56
 * -----------------------------------------------------
 */
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
