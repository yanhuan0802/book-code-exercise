package com.yanhuan.refactoring.cap01;

/**
 * 新片价格
 *
 * @author YanHuan
 * @date 2020-08-15 16:45
 */
public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int dayRented) {
        return dayRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int dayRented) {
        return dayRented > 1 ? 2 : 1;
    }
}
