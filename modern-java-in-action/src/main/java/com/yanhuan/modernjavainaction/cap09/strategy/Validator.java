package com.yanhuan.modernjavainaction.cap09.strategy;

/**
 * 验证器
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class Validator {
    private final ValidationStrategy validationStrategy;

    public Validator(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean validate(String s) {
        return validationStrategy.execute(s);
    }

}
