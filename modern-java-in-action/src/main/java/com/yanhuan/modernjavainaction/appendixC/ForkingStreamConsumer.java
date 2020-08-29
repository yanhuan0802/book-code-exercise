package com.yanhuan.modernjavainaction.appendixC;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Consumer;

/**
 * 处理多个队列的流元素
 *
 * @author YanHuan
 * @date 2020-08-29 12:11
 */
public class ForkingStreamConsumer<T> implements Consumer<T>, Results {
    static final Object END_OF_STREAM = new Object();

    private final List<BlockingDeque<T>> queues;

    private final Map<Object, Future<?>> actions;

    public ForkingStreamConsumer(List<BlockingDeque<T>> queues,
                                 Map<Object, Future<?>> actions) {
        this.queues = queues;
        this.actions = actions;
    }

    @Override
    public <R> R get(Object key) {
        try {
            return (R) actions.get(key).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void accept(T t) {
        queues.forEach(q -> q.add(t));
    }

    void finish() {
        accept((T) END_OF_STREAM);
    }
}
