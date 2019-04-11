package com.test;

import java.util.Arrays;

public class Test implements  ITe,IN{
    @Override
    public void test1() {

    }

    @Override
    public void test() {

    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(new Test().getClass().getInterfaces()));
    }
}
