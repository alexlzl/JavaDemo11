package com.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyUtil {
    private  IDemo test;
    private int[] i=new int[]{0,2};
    public DynamicProxyUtil(IDemo iDemo){
        test=iDemo;
    }

    public  IDemo getProxy(){
        return (IDemo) Proxy.newProxyInstance(test.getClass().getClassLoader(),test.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理类增加之前===========");
                IDemo iDemo = (IDemo) method.invoke(test);
                System.out.println("代理类增加之后===========");
                return iDemo;
            }
        });
    }
}
