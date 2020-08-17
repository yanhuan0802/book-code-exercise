package com.yanhuan.modernjavainaction.cap09.observer;

/**
 * 观察者
 *
 * @author : yan
 * -----------------------------------------------------
 */
public interface Observer {
    /**
     * 通知
     *
     * @param tweet 消息
     */
    void notify(String tweet);
}
