package com.yanhuan.modernjavainaction.cap09.observer;

/**
 * 测试
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class ObserverTest {
    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new LeMonde());
        feed.registerObserver(new Guardian());
        feed.notifyObservers("The queen said her favourite book is Modern Java in Action");
    }
}
