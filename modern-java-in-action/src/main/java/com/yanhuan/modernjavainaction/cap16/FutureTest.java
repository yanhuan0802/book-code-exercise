package com.yanhuan.modernjavainaction.cap16;

import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Object> future = executor.submit(() -> 123);
        try {
            //获取异步操作的结果  如果最终被阻塞  无法得到结果  那么在最多等待1秒钟后退出
            Object o = future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
