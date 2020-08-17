package com.yanhuan.modernjavainaction.cap03;

import java.io.BufferedReader;

/**
 * @author : yan
 * @Project Name : test
 * @Package Name : com.ikingtech.javashizhan.cap03
 * @Description :
 * @Creation Date: 2020-01-19 23:06
 * -----------------------------------------------------
 */
@FunctionalInterface
public interface BufferReaderProcessor {
    String process(BufferedReader b) throws Exception;
}
