package codeofli.leetcode.contest.c_10_16;

import codeofli.my.leetcode.TransformUtil;

import java.util.LinkedList;
import java.util.Queue;

public class CountSubarrays {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        if (minK == maxK) {
            return f(nums, minK, maxK);
        }
        //<idx,min,max,cnt>
        //var f = new int[n][3];
        long res  = 0;
        int left = 0,right = 0;
        for (; left < n; left++) {
            if(nums[left] == minK){
                while(right < n && nums[right] < maxK){
                    right++;
                }
                if(right >= n){
                    break;
                }
            }else if(nums[left] == maxK){

            }
        }
        return res;
    }

    private long f(int[] nums, int minK, int maxK) {
        int n = nums.length;
        //<idx,min,max,cnt>
        //var f = new int[n][3];
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == minK) {
                int j = i;
                while (j + 1 < n && nums[j + 1] == minK) {
                    j++;
                }
                long len = j - i + 1;
                res += (len * (len +1)) / 2;
                i = j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountSubarrays countSubarrays = new CountSubarrays();
        System.out.println(countSubarrays.countSubarrays(TransformUtil.toIntArray("[1,3,5,2,7,5]"), 1, 5));
        System.out.println(countSubarrays.countSubarrays(TransformUtil.toIntArray("[1,3,5,2,7,5]"), 1, 5) == 2);
        System.out.println(countSubarrays.countSubarrays(TransformUtil.toIntArray("[1,1,1,1]"), 1, 1));
        System.out.println(countSubarrays.countSubarrays(TransformUtil.toIntArray("[1,1,1,1]"), 1, 1) == 10);
    }
}
