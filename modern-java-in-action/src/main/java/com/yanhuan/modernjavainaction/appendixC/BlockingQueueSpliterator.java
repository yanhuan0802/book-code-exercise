package com.yanhuan.modernjavainaction.appendixC;

import java.util.Spliterator;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

/**
 * 遍历BlockingQueue并读取其中元素的Spliterator
 *
 * @author YanHuan
 * @date 2020-08-29 12:21
 */
public class BlockingQueueSpliterator<T> implements Spliterator<T> {
    private final BlockingQueue<T> q;

    public BlockingQueueSpliterator(BlockingQueue<T> q) {
        this.q = q;
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        T t;
        while (true) {
            try {
                t = q.take();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (t != ForkingStreamConsumer.END_OF_STREAM) {
            action.accept(t);
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<T> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }
}
