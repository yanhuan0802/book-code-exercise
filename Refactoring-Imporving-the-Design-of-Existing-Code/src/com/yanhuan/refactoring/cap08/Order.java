package com.yanhuan.refactoring.cap08;


/**
 * Change Value to Reference
 *
 * @author YanHuan
 * @date 2020-09-16 22:54
 */
public class Order {
    private Customer customer;

    public Order(String customerName) {
        this.customer = Customer.getNamed(customerName);
    }

    public String getCustomer() {
        return customer.getName();
    }

    public void setCustomer(String customerName) {
        this.customer = Customer.getNamed(customerName);
    }


}
