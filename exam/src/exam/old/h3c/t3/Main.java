package exam.old.h3c.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] cs = s.toCharArray();
        int maxLen = 0;
        int n = cs.length;
        int startIdx = -1;
        for(int i = 0; i < n; i++){
            int left = i,right = i+1;
            while(left >= 0 && right < n && cs[left] == cs[right]){
                left--;
                right++;
            }
            if(right - left - 1 > maxLen){
                maxLen = right - left - 1;
                startIdx = left;
            }


            left = i;
            right = i;
            while(left >= 0 && right < n && cs[left] == cs[right]){
                left--;
                right++;
            }
            if(right - left - 1 > maxLen){
                maxLen = right - left - 1;
                startIdx = left;
            }
        }
        System.out.println(s.substring(startIdx + 1, startIdx + maxLen + 1));
    }
}
