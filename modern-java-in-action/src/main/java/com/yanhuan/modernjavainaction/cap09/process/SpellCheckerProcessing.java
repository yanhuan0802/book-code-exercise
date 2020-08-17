package com.yanhuan.modernjavainaction.cap09.process;

/**
 * TODO
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
