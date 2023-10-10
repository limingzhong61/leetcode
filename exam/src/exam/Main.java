package exam;//package main
//注意不要添加包名称，否则会报错。

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int m = in.nextInt();

        char[] cs = s.toCharArray();

        char startChar = cs[0];
        int n = cs.length;
        int ans = 1;
        for(int i = 1; i < n; ){
            int useM = m * 2;
            if(m > 0 && i + m < n){
                int cnt = 0;
                for(int j = 0; j < m; j++){
                    cnt += Math.abs(cs[i] - cs[i-1])+ 1;
                    i++;
                }
                ans += Math.min(useM, cnt);
            }else{
                ans += Math.abs(cs[i] - cs[i-1]) + 1;
                i++;
            }
        }
        System.out.println(ans);
    }
}
/**
 CCCCC 3
 5

 ABA 0
 5

 ADDA 2
 9

 ACAC 2
 8
 */