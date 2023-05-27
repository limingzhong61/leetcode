package lmz.algorithm.two_pointer;

import lmz.my.leetcode.TransformUtil;

import java.util.Arrays;

public class SortColors75 {
    /**
     * 两遍扫描，第一遍把0放入正确位置，第二遍处理1
     */
    public void sortColors1(int[] nums) {
        //1 <= n <= 300
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, index, i);
                index++;
            }
        }
        for (int i = index; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, index, i);
                index++;
            }
        }
    }

    /**
     * 双指针：0,2为左右两端，用left，right表示需要插入的位置，维护一个两侧分别为0,2的状态
     */
    public void sortColors(int[] nums) {
        //1 <= n <= 300
        int n = nums.length;
        for (int left = 0, right = n - 1, i = 0; i <= right;i++ ) {
            while(i <= right && nums[i] == 2){
                swap(nums, right, i);
                right--;
            }
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
            }
        }
    }

    /**
     * 双指针：p0,p1分别记录0,1插入的位置,
     * 关键在于，p1>p0则交换i,p0时，将p0上的1给交换出去了，需要交换i,p1,将交换出去的1放在p1的位置
     */
    public void sortColors2(int[] nums) {
        //1 <= n <= 300
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if(p1 > p0){
                    //将交换出去的1放在p1的位置
                    swap(nums,i,p1);
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                swap(nums,i,p1);
                p1++;
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
        int[] array = TransformUtil.toIntArray("[2,0,2,1,1,0]");
        //int[] array = StringTransformUtil.toIntArray("[2,0,1]");
        sortColors75.sortColors(array);
        System.out.println(Arrays.toString(array));
    }


}
