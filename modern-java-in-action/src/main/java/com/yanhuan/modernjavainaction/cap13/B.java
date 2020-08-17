package com.yanhuan.modernjavainaction.cap13;

public interface B {
    default void hello(){
        System.out.println("Hello from B");
    }
}
