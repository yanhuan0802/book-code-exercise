package com.yanhuan.refactoring.cap01;

/**
 * 儿童片价格
 *
 * @author YanHuan
 * @date 2020-08-15 16:42
 */
public class ChildrenPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    double getCharge(int dayRented) {
        double result = 1.5;
        if (dayRented > 3) {
            result += (dayRented - 3) * 1.5;
        }
        return result;
    }
}
