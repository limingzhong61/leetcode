package com.lmz.my.just_fun;

import java.util.Random;

/**
 * 面试题： 利用Random3 生成 Random5
 * @author: limingzhong
 * @create: 2023-07-30 20:41
 */
public class RandomMToRandomN {
    static Random random = new Random(7);
    static int m  = 3;
    static int n  = 5;
    /**
     * 生成[0,m)的随机数
     */
    static int randomM(int m){
        return random.nextInt(m);
    }

    /**
     * 利用randomM生成randomN
     * @return
     */
    static int randomN(){
        // m * [0,m) + [0,m) 范围：0 - m*m
        int t = m * m / n * n;
        int x;
        do{
            x = m * randomM(m) + randomM(m);
        }while(x >= t);
        return x % n;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 25; i++){
            System.out.println(randomN());
        }
    }
}
