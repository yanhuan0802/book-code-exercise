package com.yanhuan.modernjavainaction.cap17.temp;

import java.util.concurrent.Flow.*;

/**
 * Subscriber接口实现，打印输出收到的温度数据
 *
 * @author Yan
 */
public class TempSubscriber implements Subscriber<TempInfo> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(TempInfo tempInfo) {
        System.out.println(tempInfo);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }

}
