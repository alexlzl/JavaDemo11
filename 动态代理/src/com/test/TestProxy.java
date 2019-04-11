package com.test;

public class TestProxy {
    public static void main(String[] args){
        new DynamicProxyUtil(new Test()).getProxy().test();
    }
}
