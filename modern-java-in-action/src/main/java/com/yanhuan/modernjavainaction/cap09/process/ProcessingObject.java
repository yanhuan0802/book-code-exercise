package com.yanhuan.modernjavainaction.cap09.process;

/**
 * 责任链模式
 *
 * @author : yan
 * -----------------------------------------------------
 */
public abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
            return successor.handleWork(r);
        }
        return r;
    }

    /**
     * 执行方法
     *
     * @param input 参数
     * @return 返回结果
     */
    abstract protected T handleWork(T input);
}
