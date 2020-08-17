package com.yanhuan.modernjavainaction.cap09.observer;

/**
 * 法国世界报
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class LeMonde implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            System.out.println("today cheese, wine and news" + tweet);
        }
    }
}
