package com.lmz.leetcode.practice.hot_100_offer;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-06-29 16:52
 */
public class NextPermutation31 {
    /**
     * 逆序找到i的后面[i+1,n)是否存在比nums[i]更大的数字，取大于 nums[i]中最小的一个min[i+1,n),idx记作minIdx
     * 则将i,minIdx交换，并且[i+1,n)变为升序则为答案
     *
     * [i+1,n)变为升序： 交换后 [i+1,n)任然为降序,直接逆置即为升序
     * 首先 未交换前[i+1,n)必然降序 nums[i+1,minIdx) > nums[minIdx] > nums(minIdx,n)
     * nums[i+1,minIdx) > nums[minIdx] > nums[i] > nums(minIdx,n)
     * 则交换后还是降序
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length ;
        boolean has = false;
        int maxIdx = n-1;
        for(int i = n-1; i >= 0 ; i--){
            if(nums[maxIdx] < nums[i]){
                maxIdx = i;
            }
            if(nums[i] < nums[maxIdx]){
                int minIdx = maxIdx;
                for(int j = i; j < n; j++){
                    if(nums[j] > nums[i] && nums[j] <= nums[minIdx]){ // 找到最右边的最小值
                        minIdx = j;
                    }
                }
                // 将i,j交换，并且[i,n)变为升序则为答案
                swap(nums, minIdx, i);
                // 交换后 [i+1,n)任然为降序,直接逆置即为升序
                for(int k = i+1,j = n-1; k < j;j--, k++){
                    System.out.printf("%d,%d\n",nums[k],nums[j]);
                    swap(nums, k, j);
                }
                has = true;
                break;
            }
        }
        if(!has){ //说明这个序列 递减 ，直接整个逆序，取最小
            for(int i = 0,j = n-1; i < j;j--, i++){
                swap(nums, i, j);
            }
        }
    }

    /**
     我们希望下一个数 比当前数大，这样才满足 “下一个排列” 的定义。因此只需要 将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
     我们还希望下一个数 增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
     在 尽可能靠右的低位 进行交换，需要 从后向前 查找
     将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
     将「大数」换到前面后，需要将「大数」后面的所有数 重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和          4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
     */
    public void nextPermutation2(int[] nums) {
        int n = nums.length;
        boolean next = false;
        // 尽可能靠右的低位进行交换，从后往前找，
        for(int i = n-2; i >= 0; i--){
            // 尽可能小的「大数」 与前面的「小数」交换
            // 找到nums[idx] > nums[i] 中的最小的一个
            int x = nums[i],idx = 0;
            for(int j = i+1; j < n; j++){
                if(nums[i] < nums[j] &&(idx == 0 || nums[j] < nums[idx])){
                    idx = j;
                }
            }
            if(idx != 0){
                // swap(i,idx)
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                // sort nums[i+1,n)
                Arrays.sort(nums,i+1,n);
                return;
            }
        }
        if(!next){
            Arrays.sort(nums);
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
