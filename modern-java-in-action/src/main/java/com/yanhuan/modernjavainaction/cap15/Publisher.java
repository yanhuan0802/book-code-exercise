package com.yanhuan.modernjavainaction.cap15;

/**
 * @author Yan
 */
public interface Publisher<T> {
    /**
     * 订阅
     *
     * @param subscriber 订阅者
     */
    void subscribe(Subscriber<? super T> subscriber);
}
