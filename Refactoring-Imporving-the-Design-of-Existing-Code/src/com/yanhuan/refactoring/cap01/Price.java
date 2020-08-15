package com.yanhuan.refactoring.cap01;

/**
 * state模式改造价格获取（new class）
 *
 * @author YanHuan
 * @date 2020-08-15 16:39
 */
public abstract class Price {
    /**
     * 价格获取
     *
     * @return 价格
     */
     abstract int getPriceCode();

    /**
     * 金额计算
     *
     * @param dayRented 租期
     * @return 金额
     */
    abstract double getCharge(int dayRented);

    /**
     * 积分计算（new）
     *
     * @return 积分值
     */
    int getFrequentRenterPoints(int dayRented) {
        return 1;
    }
}
