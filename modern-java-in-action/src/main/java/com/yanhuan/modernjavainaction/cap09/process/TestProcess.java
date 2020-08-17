package com.yanhuan.modernjavainaction.cap09.process;


import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * 测试责任链
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class TestProcess {
    public static void main(String[] args) {
//        HeaderTextProcessing p1 = new HeaderTextProcessing();
//        SpellCheckerProcessing p2 = new SpellCheckerProcessing();
//        p1.setSuccessor(p2);
//        String handle = p1.handle("Aren't labdas really sexy?!! ");
//        System.out.println(handle);

        //使用lambda表达式
        UnaryOperator<String> head = (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spell = (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> function = head.andThen(spell);
        String apply = function.apply("Aren't labdas really sexy?!!");
        System.out.println(apply);
    }
}
