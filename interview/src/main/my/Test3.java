package com.lmz.algorithm_learning;

import java.lang.reflect.InvocationTargetException;

public class Test3 {

    static  final  Test3 INSTANCE = new Test3();
    static  final  boolean a = initA();

    private static boolean initA() {
        return true;
    }

    final  boolean b = a;

    boolean getB(){
        return  b;
    }
    static  final boolean c = a;

    boolean getC(){
        return  c;
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println(INSTANCE.getB() + "," + INSTANCE.getC());

    }
}