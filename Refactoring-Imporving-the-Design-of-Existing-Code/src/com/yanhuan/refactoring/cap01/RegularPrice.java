package com.yanhuan.refactoring.cap01;

/**
 * 普通片价格
 *
 * @author YanHuan
 * @date 2020-08-15 16:46
 */
public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int dayRented) {
        double result = 2;
        if (dayRented > 2) {
            result += (dayRented - 2) * 1.5;
        }
        return result;
    }
}
