package com.yanhuan.modernjavainaction.cap13;

public class C implements B, A {

    @Override
    public void hello() {
        B.super.hello();
    }
}
