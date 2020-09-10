package com.yanhuan.refactoring.cap07;

/**
 * 搬移字段
 *
 * @author YanHuan
 * @date 2020-09-10 22:59
 */
public class Account {

    private AccountType type;

    double interestForAmountDays(double amount, int days) {
        return type.getInterestRate() * amount * days / 365;
    }
}
