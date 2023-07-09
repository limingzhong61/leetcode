package com.lmz.algorithm.find.binary_search;

public class SortedSquares977 {
    /*先全部平方，肯定是两端在两遍最大
     后双指针比较
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }
        int low = 0, high = n - 1,index = n-1;
        while(low <= high){
            if(nums[low] < nums[high]){
                res[index--] = nums[high--];

            }else{
                res[index--] = nums[low++];
            }
        }
        return  res;
    }
}
