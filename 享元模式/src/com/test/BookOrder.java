package com.test;

public class BookOrder implements FlyWeight {
    private String name;
    BookOrder(String name){
        this.name = name;
    }
    @Override
    public void cell() {
        System.out.println("卖了一本书，书名为'"+this.name+"'");
    }
}
