package com.test;

import java.util.HashMap;
import java.util.Map;

//抽象表达式(Expression)
interface Expression {
    int interpret(Context context);
}
//终结符表达式(Terminal Expression)
class Constant implements Expression {
    private int i;

    public Constant(int i) {
        this.i = i;
    }

    @Override
    public int interpret(Context context) {
        return i;
    }
}

class Variable implements Expression {
    @Override
    public int interpret(Context context) {
        return context.LookupValue(this);
    }
}
//非终结符表达式(Nonterminal Expression)
class Add implements Expression {
    private Expression left, right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}

class Sub implements Expression {
    private Expression left, right;

    public Sub(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }
}

class Mul implements Expression {
    private Expression left, right;

    public Mul(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) * right.interpret(context);
    }
}

class Div implements Expression {
    private Expression left, right;

    public Div(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) / right.interpret(context);
    }
}
//环境(Context)角色
class Context {
    private Map valueMap = new HashMap<>();

    public void addValue(Variable x, int y) {
        valueMap.put(x, y);
    }

    public int LookupValue(Variable x) {
        return (int) valueMap.get(x);
    }
}

//客户端
public class Main {
    public static void main(String[] args) {
        //(a*b)/(a-b+15000)
        Context context = new Context();
        Variable a = new Variable();
        Variable b = new Variable();
        Constant c = new Constant(15000);

        context.addValue(a, 14);
        context.addValue(b, 10000);

        Expression expression = new Div(new Mul(a, b), new Add(new Sub(a, b), c));
        System.out.println("Result = "+expression.interpret(context));
    }
}

