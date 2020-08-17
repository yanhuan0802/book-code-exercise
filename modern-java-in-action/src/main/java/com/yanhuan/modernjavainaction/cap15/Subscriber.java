package com.yanhuan.modernjavainaction.cap15;

/**
 * @author Yan
 */
public interface Subscriber<T> {
    /**
     * 接受订阅者
     *
     * @param t 订阅者
     */
    void onNext(T t);
}
