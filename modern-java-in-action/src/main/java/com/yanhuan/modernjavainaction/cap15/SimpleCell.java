package com.yanhuan.modernjavainaction.cap15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yan
 */
public class SimpleCell implements Publisher<Integer>, Subscriber<Integer> {

    private int value = 0;
    private String name;

    private List<Subscriber> subscribers = new ArrayList<>();

    public SimpleCell(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        //增加订阅者
        subscribers.add(subscriber);
    }

    private void notifyAllSubscribers() {
        //通知所有订阅者有一个新值产生
        subscribers.forEach(subscriber -> subscriber.onNext(this.value));
    }

    @Override
    public void onNext(Integer newValue) {
        //通过更新自己的值来响应它订阅的单元格发生的变化
        this.value = newValue;
        System.out.println(this.name + ":" + this.value);
        notifyAllSubscribers();
    }

}
