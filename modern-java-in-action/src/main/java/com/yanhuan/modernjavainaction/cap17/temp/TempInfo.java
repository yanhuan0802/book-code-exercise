package com.yanhuan.modernjavainaction.cap17.temp;

import java.util.Random;

/**
 * @author Yan
 */
public class TempInfo {
    public static final Random random = new Random();

    private final String town;

    private final int temp;

    public TempInfo(String town, int temp) {
        this.town = town;
        this.temp = temp;
    }

    /**
     * 城市的tempInfo实例都通过静态工厂方法创建
     */
    public static TempInfo fetch(String town) {
        if (random.nextInt(10) == 0) {
            //获取当前温度  每十次操作可能随机失败一次
            throw new RuntimeException("Error!");
        }
        //返回温度，值是介于华氏0度到99度之间的一个随机数
        return new TempInfo(town, random.nextInt(100));
    }

    public String getTown() {
        return town;
    }

    public int getTemp() {
        return temp;
    }

    @Override
    public String toString() {
        return town + ":" + temp;
    }
}
