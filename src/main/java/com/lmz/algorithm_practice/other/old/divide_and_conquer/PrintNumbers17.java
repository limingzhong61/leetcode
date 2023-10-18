package com.lmz.algorithm_practice.other.old.divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintNumbers17 {
    /**
     子集生成： 模拟大数
     */
    List<String> ans  = new ArrayList<>();
    public int[] printNumbers(int n) {
        dfs(n,0);
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            if(ans.get(i).equals("")) continue;
            res[i] = Integer.parseInt(ans.get(i));
        }
        return res;
    }
    StringBuilder sb = new StringBuilder();
    // 生成长度为 len 的数字，正在确定第cur位（从左往右）
    void dfs(int n,int cur){
        if(cur == n){
            ans.add(sb.toString());
            System.out.println(ans.get(ans.size()-1));
            return;
        }
        //int start = cur == 0 ? 1 : 0; //第0位只能从1开始
        for(int i = 0; i < 10; i++){
            sb.append(i);
            dfs(n,cur+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        PrintNumbers17 printNumbers17 = new PrintNumbers17();
        //printNumbers17.printNumbers(3);
        System.out.println(Arrays.toString(printNumbers17.printNumbers(3)));
    }
}
