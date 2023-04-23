package com.lmz;

/**
 * @author: limingzhong
 * @create: ${YEAR}-${MONTH}-${DAY} ${TIME}
 */
public class Main {
    public static void main(String[] args) {
        ThreadLocal<Integer> a = new ThreadLocal<>();
        a.set(1);
        a.get();
        System.out.println("Hello world!");
    }
}