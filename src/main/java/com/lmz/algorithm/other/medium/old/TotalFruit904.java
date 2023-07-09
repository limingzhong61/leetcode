package com.lmz.algorithm.other.medium.old;

import com.lmz.my.leetcode.TransformUtil;

public class TotalFruit904 {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        //0 <= fruits[i] < fruits.length
        //<val,start,end>
        var record = new int[2][3];
        int res = 1;
        record[0][0] = -1; //标记没有记录
        record[1][0] = -1; //标记没有记录
        record[0][0] = fruits[0];
        record[0][1] = 0;
        record[0][2] = 0;
        for (int i = 1; i < n; i++) {
            if (record[0][0] == fruits[i]) {
                record[0][2] = i; //更新end
                if (record[1][0] != -1) { //已经有两了,新来的为最后一个
                    swap(record, 0, 1);
                }
            } else {
                if (record[1][0] == -1) {
                    record[1][0] = fruits[i];
                    record[1][1] = i;
                    record[1][2] = i;
                } else if (record[1][0] == fruits[i]) {
                    record[1][2] = i; //更新end
                } else { //已经有两了
                    res = Math.max(res, 1 + Math.max(record[0][2], record[1][2]) - Math.min(record[0][1], record[1][1]));
                    //最后一个的开始位置应该在第一个最后位置的下一个位置
                    record[1][1] = record[0][2] + 1;
                    record[0][0] = fruits[i];
                    record[0][1] = i;
                    record[0][2] = i;
                    swap(record, 0, 1);
                }
            }
        }
        //最后一个没有统计进去
        res = Math.max(res, 1 + Math.max(record[0][2], record[1][2]) - Math.min(record[0][1], record[1][1]));
        return res;
    }

    public static void swap(int[][] nums, int a, int b) {
        int[] temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        TotalFruit904 totalFruit904 = new TotalFruit904();
        System.out.println(totalFruit904.totalFruit(TransformUtil.toIntArray("[0,0,1,1]")));
    }
}
