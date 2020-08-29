package com.yanhuan.modernjavainaction.appendixC;

/**
 * 操作的执行
 *
 * @author YanHuan
 * @date 2020-08-29 11:27
 */
public interface Results {
    /**
     * 获取操作结果
     *
     * @param key key
     * @param <R> 类型
     * @return 结果
     */
    <R> R get(Object key);
}
