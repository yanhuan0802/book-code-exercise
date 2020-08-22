package com.yanhuan.modernjavainaction.appendixA;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 测试
 *
 * @author YanHuan
 * @date 2020-08-22 10:08
 */
public class AnnotationTest {
    public static void main(String[] args) {
        List<Object> objects = Collections.emptyList();
        Author[] authors = Book.class.getAnnotationsByType(Author.class);
        Arrays.asList(authors).forEach(author -> System.out.println(author.name()));
    }
}
