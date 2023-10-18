package com.lmz.algorithm_practice.other.old.primary.design_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ShuffleArray {
    public int[][] allArrange;
    public boolean[] picked;
    int n;

    /**
     * my:solution
     * 用java.random[0,1,2,...,n]的数字
     * 用mark标记删除，然后遍历提取
     */
    class Solution1 {
        public int[] nums;
        public int[] originNums;
        int n;

        public Solution1(int[] nums) {
            this.n = nums.length;
            this.originNums = Arrays.copyOf(nums, n);
            this.nums = nums;
            // System.out.println(Arrays.toString(nums));
            int[] record = new int[n];
        }

        public int[] reset() {
            return originNums;
        }

        public int[] shuffle() {
            Random random = new Random();
            int[] arrange = new int[n];
            int cnt = 0;
            //假设删除了
            boolean[] mark = new boolean[n];
            Arrays.fill(mark,false);
            //random选择n次，则概率相同
            for(int i = n;i >= 1; i--){
                int randIndex = random.nextInt(i);
                //if(!mark[i]){
                //    arrange[cnt++] = randIndex;
                //    continue;
                //}
                int count = 0;
                for(int j = 0; j < n; j++){
                    if(!mark[j]){
                        if(count == randIndex){
                            mark[j] = true;
                            arrange[cnt++] = nums[j];
                            break;
                        }
                        count++;
                    }
                }
                // System.out.println(Arrays.toString(arrange));
                // System.out.println(Arrays.toString(mark));
            }

            return arrange;
        }
    }

    /**
     * leetcode:
     * 用java.random[0,1,2,...,n]的数字
     * 用list直接删除，然后直接[index]提取
     */
    class Solution2 {
        public int[] nums;
        int n;

        public Solution2(int[] nums) {
            this.n = nums.length;
            this.nums = nums;
            // System.out.println(Arrays.toString(nums));
            int[] record = new int[n];
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            Random random = new Random();
            int[] arrange = new int[n];
            int cnt = 0;
            List<Integer> list = new ArrayList<>(n);
            for(int i = 0; i < n; i++){
                list.add(nums[i]);
            }
            //random选择n次，则概率相同
            for(int i = n;i >= 1; i--){
                int randIndex = random.nextInt(i);
                Integer value = list.get(randIndex);
                arrange[cnt++] = value;
                list.remove(randIndex);
            }
            return arrange;
        }
    }
    /**
     * leetcode:
     * Fisher-Yates 洗牌算法
     */
    class Solution {
        public int[] nums;
        int n;

        public Solution(int[] nums) {
            this.n = nums.length;
            this.nums = nums;
            int[] record = new int[n];
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            Random random = new Random();
            int[] arrange = Arrays.copyOf(nums, n);

            //random选择n-1次，则概率相同
            // 因为最后一次，i = 1， random=0,不需要操作
            for(int i = n-1;i > 0; i--){
                int randIndex = random.nextInt(i+1);
                //swap
                int temp = arrange[randIndex];
                arrange[randIndex] = arrange[i];
                arrange[i] = temp;
            }
            return arrange;
        }
    }











    /**
     * n个数字全排列，总共有n！种
     * my方法一:使用递归
     */
    //标记选择
    //private boolean[] picked;
    int arrangeIndex = 0;
    public void getAllArrange(int cnt,int record[]){
        if(cnt == n){
            //加入排列结果集
            for(int i = 0; i < n; i++){
                allArrange[arrangeIndex][i] = record[i];
            }
            arrangeIndex++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(!picked[i]){
                picked[i] =true;
                record[cnt] = i;
                getAllArrange(cnt+1,record);
                picked[i] = false; //放开选择，让后面可以选择。
            }
        }
    }
}
