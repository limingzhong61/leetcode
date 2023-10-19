package com.lmz.leetcode.practice.other.old.primary.strings;

public class CountAndSay38 {

    //迭代模拟
    public String countAndSay(int n) {
        String pre = "1";
        //StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n ;i++){
            char[] chars = pre.toCharArray();
            int length = chars.length;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < length;){
                char startChar = chars[j];
                int cnt = 0;
                //记录相同char个数
                while(j < length && startChar == chars[j]){
                    cnt++;
                    j++;
                }
                sb.append(cnt).append(startChar);
            }
            // System.out.println(sb);
            pre = sb.toString();
        }
        return pre;
    }

    public static void main(String[] args) {
        CountAndSay38 countAndSay38 = new CountAndSay38();
        System.out.println(countAndSay38.countAndSay(30));
    }
}
