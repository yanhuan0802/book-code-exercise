package com.yanhuan.modernjavainaction.cap15;

/**
 * @author Yan
 */
public class ArithmeticCell extends SimpleCell {

    private int left;
    private int right;

    public ArithmeticCell(String name) {
        super(name);
    }

    public void setLeft(int left) {
        this.left = left;
        //更新单元格中的值  并通知所有事件订阅者该变化
        onNext(left + this.right);
    }

    public void setRight(int right) {
        this.right = right;
        //更新单元格中的值  并通知所有事件订阅者该变化
        onNext(right + this.left);
    }


    public static void main(String[] args) {
        ArithmeticCell c3 = new ArithmeticCell("C3");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c1 = new SimpleCell("C1");

        c1.subscribe(c3::setLeft);
        c2.subscribe(c3::setRight);

        c1.onNext(10);
        c2.onNext(20);
        c1.onNext(15);
    }
}
