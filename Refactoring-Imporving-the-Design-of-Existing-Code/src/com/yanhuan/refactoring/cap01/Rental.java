package com.yanhuan.refactoring.cap01;

/**
 * 租赁：表示某个顾客租了一部影片（oldClass）
 *
 * @author YanHuan
 * @date 2020-08-15 13:37
 */
public class Rental {

    /**
     * 电影
     */
    private Movie movie;

    /**
     * 租期
     */
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    /**
     * 计算每次租赁的金额（new）
     *
     * @return 金额
     */
    double getCharge() {
        return movie.getCharge(daysRented);
    }

    /**
     * 积分计算（new）
     *
     * @return 积分值
     */
    int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}
