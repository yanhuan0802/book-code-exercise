package com.yanhuan.modernjavainaction.cap09.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    /**
     * 注册
     *
     * @param o 观察者对象
     */
    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    /**
     * 通知
     *
     * @param sweet 消息内容
     */
    @Override
    public void notifyObservers(String sweet) {
        observers.forEach(o -> o.notify(sweet));
    }
}
