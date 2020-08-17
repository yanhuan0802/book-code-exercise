package com.yanhuan.modernjavainaction.cap04;


/**
 * @author : yan
 * @Project Name : test
 * @Package Name : com.ikingtech.javashizhan.cap04
 * @Description :  碟
 * @Creation Date: 2020-03-10 21:59
 * -----------------------------------------------------
 */
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;


    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type{MEAT,FISH,OTHER}
}
