package codeofli.leetcode.two_points;

import codeofli.my.leetcode.StringTransformUtil;

import java.util.Arrays;

public class SortColors75 {
    /**
     * 两遍扫描，第一遍把0放入正确位置，第二遍处理1
     */
    public void sortColors1(int[] nums) {
        //1 <= n <= 300
        int n = nums.length;
        int index = 0;
        for(int i = 0; i < n; i++){
           if(nums[i] == 0){
               swap(nums,index,i);
               index++;
           }
        }
        for(int i = index; i < n; i++){
            if(nums[i] == 1){
                swap(nums,index,i);
                index++;
            }
        }
    }
    /**
     * 双指针：0,2为左右两端，用left，right表示，维护一个两侧分别为0,2的状态
     */
    public void sortColors(int[] nums) {
        //1 <= n <= 300
        int n = nums.length;
        for(int left = 0,right = n-1,i = 0; i <= right;){
            if(nums[i] == 0){
                swap(nums, left, i);
                if(i == left){
                    i++;
                }
                left++;
            }else if(nums[i] == 2){
                swap(nums, right, i);
                right--;
            }else{ // nums[i] == 1
                 i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        SortColors75 sortColors75 = new SortColors75();
        //int[] array = StringTransformUtil.toIntArray("[2,0,2,1,1,0]");
        int[] array = StringTransformUtil.toIntArray("[2,0,1]");
        sortColors75.sortColors(array);
        System.out.println(Arrays.toString(array));
    }


}
