package com.lmz.leetcode.practice.contest.c333;

public class SquareFreeSubsets {
    /**
     * 1 <= nums.length <= 1000
     * 1 <= nums[i] <= 30
     */
    //public int squareFreeSubsets(int[] nums) {
    //    ArrayList<Integer> primeList = new ArrayList<>();
    //    primeList.add(2);
    //    for (int i = 3; i < 31; i++) {
    //        boolean prime = true;
    //        for (int j = 2; j < 31; j++) {
    //            if (i % 2 == 0) {
    //                prime = false;
    //                break;
    //            }
    //        }
    //        if(prime){
    //            primeList.add(i);
    //        }
    //    }
    //    int n = nums.length;
    //    var f = new int[n][primeList.size()];
    //    for(int i = 0; i < n; i++){
    //        int x = nums[i];
    //        for(var y : primeList){
    //            while(x % y == 0){
    //                f[i][y]++;
    //            }
    //        }
    //    }
    //}
}
