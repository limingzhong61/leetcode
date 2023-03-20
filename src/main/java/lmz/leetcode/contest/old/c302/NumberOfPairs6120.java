package lmz.leetcode.contest.old.c302;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.Arrays;

public class NumberOfPairs6120 {
    /**
     * 模拟
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     */
    public int[] numberOfPairs(int[] nums) {
        int len = nums.length;
        int[] map = new int[101];
        Arrays.fill(map,-1);
        for(int i = 0; i < len; i++){
            if(map[nums[i]] != -1){
                nums[map[nums[i]]] = -1; //标记除去
                map[nums[i]] = -1;
                nums[i] = -1; //标记除去
            }else{
                map[nums[i]] = i;
            }
        }
        int cnt = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] != -1){
                cnt++;
            }
        }
        return new int[]{(len-cnt) / 2,cnt};
    }

    public static void main(String[] args) {
        NumberOfPairs6120 numberOfPairs = new NumberOfPairs6120();
        System.out.println(Arrays.toString(numberOfPairs.numberOfPairs(TransformUtil.toIntArray("[1,3,2,1,3,2,2]"))));
    }
}
