package com.lmz.algorithm.find.binary_search.not_unusual;

import com.lmz.my.leetcode.TransformUtil;

public class Search33 {
    /**
     * 二分查找
     * 定理一：只有在顺序区间内才可以通过区间两端的数值判断target是否在其中。
     *
     * 定理二：判断顺序区间还是乱序区间，只需要对比 left 和 right 是否是顺序对即可，left <= right，顺序区间，否则乱序区间。
     *
     * 通过不断的用Mid二分，根据定理二，将整个数组划分成顺序区间和乱序区间，然后利用定理一判断target是否在顺序区间，如果在顺序区间，下次循环就直接取顺序区间，如果不在，那么下次循环就取乱序区间。
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0,right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]){ // [l,mid] 有序;注意是<=
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid -1;
                }else{
                    left = mid +1;
                }
            }else{  //   [mid+1,right] 有序，当[l,mid]不为有序，则在另一条mid一定 < right

                if(nums[mid+1] <= target && target <= nums[right]){
                    left = mid +1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search33 search33 = new Search33();
        testCase(search33, "[4,5,6,7,0,1,2]", 0, 4);
        testCase(search33, "[4,5,6,7,0,1,2]", 3, -1);
        testCase(search33, "[1]", 0, -1);
        testCase(search33, "[3,1]", 1, 1);
    }

    private static void testCase(Search33 search33, String original, int target, int x) {
        System.out.println(search33.search(TransformUtil.toIntArray(original), target));
        System.out.println(search33.search(TransformUtil.toIntArray(original), target) == x);
    }
}
