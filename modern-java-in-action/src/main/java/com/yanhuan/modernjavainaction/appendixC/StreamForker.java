package com.yanhuan.modernjavainaction.appendixC;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 在一个流上执行多个操作
 *
 * @author YanHuan
 * @date 2020-08-29 11:10
 */
public class StreamForker<T> {
    private final Stream<T> stream;
    private final Map<Object, Function<Stream<T>, ?>> forks = new HashMap<>();

    public StreamForker(Stream<T> stream) {
        this.stream = stream;
    }

    public StreamForker<T> fork(Object key, Function<Stream<T>, ?> f) {
        //使用一个键对流上的函数进行索引
        forks.put(key, f);
        return this;
    }

    public Results getResults() {
        ForkingStreamConsumer<T> consumer = build();
        try {
            stream.sequential().forEach(consumer);
        } finally {
            consumer.finish();
        }
        return consumer;
    }

    private ForkingStreamConsumer<T> build() {
        List<BlockingDeque<T>> queues = new ArrayList<>();
        Map<Object, Future<?>> actions = forks.entrySet().stream().reduce(
                new HashMap<>(),
                (map, e) -> {
                    map.put(e.getKey(), getOperationResult(queues, e.getValue()));
                    return map;
                },
                (m1, m2) -> {
                    m1.putAll(m2);
                    return m1;
                });
        return new ForkingStreamConsumer<>(queues, actions);
    }

    /**
     * 创建future
     *
     * @param queues 队列
     * @param f      function
     * @return future
     */
    private Future<?> getOperationResult(List<BlockingDeque<T>> queues, Function<Stream<T>, ?> f) {
        BlockingDeque<T> queue = new LinkedBlockingDeque<>();
        queues.add(queue);
        Spliterator<T> spliterator = new BlockingQueueSpliterator<>(queue);
        Stream<T> source = StreamSupport.stream(spliterator, false);
        return CompletableFuture.supplyAsync(() -> f.apply(source));
    }
}
