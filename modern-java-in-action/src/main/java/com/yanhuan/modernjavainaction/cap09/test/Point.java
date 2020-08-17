package com.yanhuan.modernjavainaction.cap09.test;

/**
 * 点
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Point moveRightBy(int x) {
        return new Point(this.x + x, this.y);
    }
}
