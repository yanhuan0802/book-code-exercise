package com.yanhuan.refactoring.cap08;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Change Value to Reference
 *
 * @author YanHuan
 * @date 2020-09-16 22:52
 */
public class Customer {

    private final String name;

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
}
