package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 由上面的打印结果我们可以得出如下结论：
 * * 可以节省重复创建对象的开销，因为被享元模式维护的相同对象只会被创建一次，当创建对象比较耗时时，便可以节省大量时间。
 * 由于创建对象的数量减少，所以对系统内存的需求也减小，这将使得GC的压力也相应地降低，进而使得系统拥有一个更健康的内存结构和更快的反应速度。
 */
public class PatternTest {

    private static List<FlyWeight> orders = new ArrayList<FlyWeight>();
    private static FlyWeightFactory factory;

    public static void main(String[] args) {
        factory = FlyWeightFactory.getInstance();
        takeOrders("三国演义");
        takeOrders("水浒传");
        takeOrders("封神榜");
        takeOrders("三体");
        takeOrders("红楼梦");
        takeOrders("三国演义");
        takeOrders("封神榜");
        takeOrders("水浒传");

        for (FlyWeight order : orders) {
            order.cell();
        }
        // 打印生成的订单java对象数量
        System.out.println("\n客户一共买了 " + orders.size() + " 本书! ");
        // 打印生成的订单java对象数量
        System.out.println("共生成了 " + factory.getTotalObjects()
                + " 个 FlyWeight java对象! ");
    }

    private static void takeOrders(String bookName) {
        orders.add(factory.getOrder(bookName));
    }
}
