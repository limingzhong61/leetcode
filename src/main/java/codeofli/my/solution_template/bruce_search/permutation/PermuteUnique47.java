package codeofli.my.solution_template.bruce_search.permutation;

import codeofli.my.leetcode.TransformUtil;

import java.util.*;

public class PermuteUnique47 {
    /**
     * 全排列+set去重
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        permutation(nums,0);
        return  res;
    }
    Set<String> set = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    private void permutation(int[] nums, int cur) {
        if(cur == nums.length){
            if(!set.contains(Arrays.toString(nums))){
               set.add(Arrays.toString(nums));
               List<Integer> temp = new ArrayList<>(nums.length);
               for(int item : nums){
                   temp.add(item);
               }
               res.add(temp);
            }
            return;
        }
        //在[cur,n]中选择一个数nums[i]为第cur的数
        for(int i = cur; i < nums.length; i++){
            swap(nums,i,cur);
            permutation(nums,cur+1);
            swap(nums,i,cur); //交换回来，方便下一次递归
        }
    }

    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        PermuteUnique47 permuteUnique47 = new PermuteUnique47();
        System.out.println(permuteUnique47.permuteUnique(TransformUtil.toIntArray("[1,1,2]")));
    }





}
