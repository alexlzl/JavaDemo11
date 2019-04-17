package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 访问者模式的优点
 * <p>
 * 符合单一职责原则：凡是适用访问者模式的场景中，元素类中需要封装在访问者中的操作必定是与元素类本身关系不大且是易变的操作，
 * 使用访问者模式一方面符合单一职责原则，另一方面，因为被封装的操作通常来说都是易变的，
 * 所以当发生变化时，就可以在不改变元素类本身的前提下，实现对变化部分的扩展。
 * 扩展性良好：元素类可以通过接受不同的访问者来实现对不同操作的扩展。
 * 访问者模式的适用场景
 * <p>
 * 假如一个对象中存在着一些与本对象不相干（或者关系较弱）的操作，为了避免这些操作污染这个对象，
 * 则可以使用访问者模式来把这些操作封装到访问者中去。
 * <p>
 * 假如一组对象中，存在着相似的操作，为了避免出现大量重复的代码，
 * 也可以将这些重复的操作封装到访问者中去。
 * <p>
 * 但是，访问者模式并不是那么完美，它也有着致命的缺陷：增加新的元素类比较困难。通过访问者模式的代码可以看到，
 * 在访问者类中，每一个元素类都有它对应的处理方法，也就是说，
 * 每增加一个元素类都需要修改访问者类（也包括访问者类的子类或者实现类），修改起来相当麻烦。
 * 也就是说，在元素类数目不确定的情况下，应该慎用访问者模式。所以，访问者模式比较适用于对已有功能的重构，
 * 比如说，一个项目的基本功能已经确定下来，元素类的数据已经基本确定下来不会变了，会变的只是这些元素内的相关操作，
 * 这时候，我们可以使用访问者模式对原有的代码进行重构一遍，这样一来，就可以在不修改各个元素类的情况下，对原有功能进行修改。
 */
abstract class Element {
    public abstract void accept(IVisitor visitor);

    public abstract void doSomething();
}

interface IVisitor {
    public void visit(ConcreteElement1 el1);

    public void visit(ConcreteElement2 el2);
}

class ConcreteElement1 extends Element {
    public void doSomething() {
        System.out.println("这是元素1");
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class ConcreteElement2 extends Element {
    public void doSomething() {
        System.out.println("这是元素2");
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class Visitor implements IVisitor {

    public void visit(ConcreteElement1 el1) {
        el1.doSomething();
    }

    public void visit(ConcreteElement2 el2) {
        el2.doSomething();
    }
}

class ObjectStruture {
    public static List<Element> getList() {
        List<Element> list = new ArrayList<Element>();
        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            int a = ran.nextInt(100);
            if (a > 50) {
                list.add(new ConcreteElement1());
            } else {
                list.add(new ConcreteElement2());
            }
        }
        return list;
    }
}

public class Client {
    public static void main(String[] args) {
        List<Element> list = ObjectStruture.getList();
        for (Element e : list) {
            e.accept(new Visitor());
        }
    }
}


