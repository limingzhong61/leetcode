package com.lmz.leetcode.practice.p.old.intro;

public class GenerateTheString1374 {
    public String generateTheString(int n) {
        StringBuffer sb = new StringBuffer();
        if (n % 2 == 1) {
            return sb.append("a".repeat(n)).toString();
        }
        return sb.append("a".repeat(n - 1)).append("b").toString();
    }


    public String generateTheString2(int n) {
        if(n % 2 == 1){
            return  getNCharString('a',n);
        }else{
            return getNCharString('a',n-1)+'b';
        }
    }

    String getNCharString(char a,int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <n; i++){
            sb.append(a);
        }
        return sb.toString();
    }
}
