package exam.old.lian_tong.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String[] split = name.split(",");
        int n = Integer.parseInt(split[0]);
        long num = Long.parseLong(split[1]);
        if(split[1].length() != n){
            System.out.println(-1);
            return;
        }
        char[] cs = split[1].toCharArray();
        long sum = 0;
        for(int i = 0; i < n; i++){
            int d = cs[i] - '0';
            sum += (long) d * d * d;
        }

        System.out.println( sum == num ? 1 : -1);
    }
}

