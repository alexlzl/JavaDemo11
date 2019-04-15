package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * ##享元工厂：用于创建具体享元类，维护相同的享元对象。它保证相同的享元对象可以被系统共享。
 * 即，其内部使用了类似单例模式的方法，当请求对象已经存在时，直接返回对象，不存在时，在创建对象。
 * ##抽象享元：定义需要共享的对象业务接口。享元类被创建出来总是为了实现某些特定的业务逻辑，而抽象享元便定义这些逻辑的语义行为。
 * ##具体享元类：实现抽象享元类的接口，完成某一具体逻辑。
 * ##客户端：使用享元模式的组件，通过享元工厂取得享元对象。
 */
public class FlyWeightFactory {
    private Map<String, FlyWeight> bookPools = new HashMap<String, FlyWeight>();
    private static FlyWeightFactory factory = new FlyWeightFactory();

    public static FlyWeightFactory getInstance() {
        return factory;
    }

    //添加订单
    public FlyWeight getOrder(String bookName) {
        FlyWeight order = null;
        if (bookPools.containsKey(bookName)) {
            order = bookPools.get(bookName);
        } else {
            order = new BookOrder(bookName);
            bookPools.put(bookName, order);
        }
        return order;
    }

    public int getTotalObjects() {
        return bookPools.size();
    }

}
