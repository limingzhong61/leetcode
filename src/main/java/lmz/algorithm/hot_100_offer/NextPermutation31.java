package lmz.algorithm.hot_100_offer;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-06-29 16:52
 */
public class NextPermutation31 {
    /**
     * 逆序找到i的后面[i+1,n)是否存在比nums[i]更大的数字，取大于 nums[i]中最小的一个min[i+1,n),idx记作minIdx
     * 则将i,minIdx交换，并且[i+1,n)变为升序则为答案
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

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
