package com.lmz.my;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

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