package test;

import com.lmz.my.leetcode.TransformUtil;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-07-15 22:21
 */
public class as {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        reverse(nums,0,n - k - 1);
        System.out.println(Arrays.toString(nums));
        reverse(nums,n - k,n-1);
        System.out.println(Arrays.toString(nums));
        reverse(nums,0, n-1);
        System.out.println(Arrays.toString(nums));
    }
    void reverse(int[] nums,int left,int right){
        for(int i = left,j = right; i < j; i++,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        as as = new as();
        as.rotate(TransformUtil.toIntArray("[1,2,3,4,5,6,7]"),3);
    }
}
