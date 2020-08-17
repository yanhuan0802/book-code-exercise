package com.yanhuan.modernjavainaction.cap17.temp;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author Yan
 */
public class TempObserver implements Observer<TempInfo> {

    @Override
    public void onSubscribe(@NonNull Disposable disposable) {

    }

    @Override
    public void onNext(@NonNull TempInfo tempInfo) {
        System.out.println(tempInfo);
    }

    @Override
    public void onError(@NonNull Throwable throwable) {
        System.out.println("Got problem:" + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}
