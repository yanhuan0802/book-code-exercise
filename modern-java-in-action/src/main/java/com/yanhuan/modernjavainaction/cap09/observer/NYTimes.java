package com.yanhuan.modernjavainaction.cap09.observer;

/**
 * 纽约时报
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class NYTimes implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Break news in NY !" + tweet);
        }
    }
}
