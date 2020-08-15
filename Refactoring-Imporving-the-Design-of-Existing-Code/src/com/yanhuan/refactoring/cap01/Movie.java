package com.yanhuan.refactoring.cap01;

/**
 * 影片
 *
 * @author YanHuan
 * @date 2020-08-15 13:31
 */
public class Movie {
    /**
     * 儿童片
     */
    public static final int CHILDREN = 2;

    /**
     * 普通片
     */
    public static final int REGULAR = 0;

    /**
     * 新片
     */
    public static final int NEW_RELEASE = 1;

    private String title;

//    private int priceCode;

    private Price price;

    /**
     * 修改构造方法
     * 确保任何时候都是以get()/set()方法获取priceCode
     *
     * @param title     标题
     * @param priceCode 价格
     */
    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
//        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
//        return priceCode;
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
//        this.priceCode = priceCode;

        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDREN:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    /**
     * 计算每次租赁的金额（new）
     * <p>
     * 用state模式改造
     *
     * @param dayRented 租期
     * @return 金额
     */
    double getCharge(int dayRented) {
        return price.getCharge(dayRented);
    }


    /**
     * 积分计算（new）
     *
     * @return 积分值
     */
    int getFrequentRenterPoints(int dayRented) {
        return price.getFrequentRenterPoints(dayRented);
    }
}
