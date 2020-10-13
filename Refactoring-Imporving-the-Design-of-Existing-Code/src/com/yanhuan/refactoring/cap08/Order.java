package com.yanhuan.refactoring.cap08;


import java.util.Objects;

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

    /**
     * 将单向关联改为双向关联
     *
     * @param arg 客户
     */
    public void setCustomer(Customer arg) {
        if (customer != null) {
            customer.friendOrders().remove(this);
        }
        this.customer = arg;
        if (customer != null) {
            customer.friendOrders().add(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer);
    }
}
