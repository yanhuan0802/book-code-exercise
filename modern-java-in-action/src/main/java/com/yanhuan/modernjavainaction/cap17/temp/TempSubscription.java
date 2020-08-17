package com.yanhuan.modernjavainaction.cap17.temp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.*;

/**
 * Subscription接口实现 向Subscriber发送TempInfo Stream
 *
 * @author Yan
 */
public class TempSubscription implements Subscription {

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    private final Subscriber<? super TempInfo> subscriber;

    private final String town;

    public TempSubscription(Subscriber<? super TempInfo> subscriber,
                            String town) {
        this.subscriber = subscriber;
        this.town = town;
    }

    @Override
    public void request(long n) {
        executor.submit(() -> {
            for (long i = 0L; i < n; i++) {
                //subscriber每处理一个请求执行一次循环
                try {
                    subscriber.onNext(TempInfo.fetch(town));
                } catch (Exception e) {
                    //查询温度时如果发送失效，将出错信息返回给Subscriber
                    subscriber.onError(e);
                    break;
                }
            }
        });
    }

    @Override
    public void cancel() {
        //如果Subscription被取消了，那么向Subscriber发送一个完成（onComplete）信号
        subscriber.onComplete();
    }
}
