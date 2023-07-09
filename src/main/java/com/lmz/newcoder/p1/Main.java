package com.lmz.newcoder.p1;

/**
 * @author: codeofli
 * @create: 2022-11-10 14:15
 */

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        String[] split = s.split(":");
        if(Integer.parseInt(split[0]) > Integer.parseInt(split[1])){
            System.out.println("Hala Madrid!");
        }else if(Integer.parseInt(split[0]) < Integer.parseInt(split[1])){
            System.out.println("Vamos Barca!");
        }else{
            System.out.println("Draw...");
        }
    }
}
