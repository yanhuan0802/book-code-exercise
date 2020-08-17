package com.yanhuan.modernjavainaction.cap09.factory;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * TODO
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class ProductFactory {

    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduct(String name) {
        Supplier<Product> p = map.get(name);
        if (p != null) {
            return p.get();
        }
        throw new RuntimeException("No such Product " + name);
    }
}
