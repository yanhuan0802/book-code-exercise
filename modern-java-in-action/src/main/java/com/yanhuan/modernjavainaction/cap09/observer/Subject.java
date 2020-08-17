package com.yanhuan.modernjavainaction.cap09.observer;


/**
 * 观察者主题
 *
 * @author : yan
 * -----------------------------------------------------
 */
public interface Subject {
    /**
     * 注册观察者
     *
     * @param o 观察者对象
     */
    void registerObserver(Observer o);

    /**
     * 通知
     *
     * @param sweet 消息内容
     */
    void notifyObservers(String sweet);
}
