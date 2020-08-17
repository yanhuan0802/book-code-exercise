package com.yanhuan.modernjavainaction.cap10;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class Order {
    private String customer;
    private List<Trade> trades = new ArrayList<>();

    private void addTrade(Trade trade) {
        trades.add(trade);
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getValue() {
        return trades.stream().mapToDouble(Trade::getValue).sum();
    }
}
