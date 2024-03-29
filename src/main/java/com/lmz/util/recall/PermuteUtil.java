package com.lmz.util.recall;


import com.lmz.util.solution_template.bruce_search.permutation.Permute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 全排列模板，没有重复元素
 */
public class PermuteUtil {
    /**
     * 下一次排列：
     * 每次选择一个数i作为全排列的第cur个数，然后继续递归生成[cur+1,n]后面的数
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutation(nums, 0,res);
        return res;
    }
    private void permutation(int[] nums, int cur, List<List<Integer>> res) {
        if (cur == nums.length) {
            List<Integer> temp = new ArrayList<>(nums.length);
            for (int item : nums) {
                temp.add(item);
            }
            res.add(temp);
            return;
        }
        //在[cur,n]中选择一个数nums[i]为第cur的数
        for (int i = cur; i < nums.length; i++) {
            swap(nums, i, cur);
            permutation(nums, cur + 1, res);
            swap(nums, i, cur); //交换回来，方便下一次递归
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    public static void main(String[] args) {
        Permute permute = new Permute();
        //System.out.println(permute.permuteUnique(TransformUtil.toIntArray("[1,1,2]")));
        System.out.println(permute.permuteUnique(IntStream.range(0, 9).toArray()));
    }

    /**
     * 逆序找到i的后面[i+1,n)是否存在比nums[i]更大的数字，取大于 nums[i]中最小的一个min[i+1,n),idx记作minIdx
     * 则将i,minIdx交换，并且[i+1,n)变为升序则为答案
     *
     * [i+1,n)变为升序： 交换后 [i+1,n)任然为降序,直接逆置即为升序
     * 首先 未交换前[i+1,n)必然降序 nums[i+1,minIdx) > nums[minIdx] > nums(minIdx,n)
     * nums[i+1,minIdx) > nums[minIdx] > nums[i] > nums(minIdx,n)
     * 则交换后还是降序
     */
    public static void nextPermutation(int[] nums) {
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
}

