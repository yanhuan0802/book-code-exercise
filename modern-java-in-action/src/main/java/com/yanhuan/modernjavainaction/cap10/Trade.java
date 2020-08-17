package com.yanhuan.modernjavainaction.cap10;

/**
 * 交易
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class Trade {
    private enum Type {
        /**
         * 买
         */
        BUY,
        /**
         * 卖
         */
        SELL
    }

    private Type type;

    private Stock stock;
    private int quantity;
    private double price;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getValue() {
        return quantity * price;
    }
}
