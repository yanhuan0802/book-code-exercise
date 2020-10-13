package com.yanhuan.refactoring.cap08;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * Change Value to Reference
 *
 * @author YanHuan
 * @date 2020-09-16 22:52
 */
public class Customer {

    private final String name;

    private Set<Order> orders = new HashSet<>();

    private static final Dictionary<String, Customer> INSTANCE = new Hashtable<>();

    static void loadCustomers() {
        new Customer("Lemon").store();
        new Customer("Associated").store();
        new Customer("Bilston Gasworks").store();
    }

    private void store() {
        INSTANCE.put(this.getName(), this);
    }

    /**
     * 工厂函数
     * Replace Constructor with Factory Method
     *
     * @param name 名称
     * @return customer
     */
    public static Customer getNamed(String name) {
        return INSTANCE.get(name);
    }

    private Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 将单向关联改为双向关联：辅助函数
     *
     * @return orderSet
     */
    public Set<Order> friendOrders() {
        return orders;
    }

    /**
     * 将单向关联改为双向关联
     *
     * @param order 订单
     */
    public void addOrder(Order order) {
        order.setCustomer(this);
    }
}
