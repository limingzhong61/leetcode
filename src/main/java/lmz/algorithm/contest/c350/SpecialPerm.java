//package lmz.algorithm.contest.c350;
//
///**
// * @author: limingzhong
// * @create: 2023-06-18 10:43
// */
//public class SpecialPerm {
//    /**
//     * 全陪列+剪枝
//     * @param nums
//     * @return
//     */
//    public int specialPerm(int[] nums) {
//
//        dfs(nums,0,0);
//    }
//    int ans = 0;
//    private void dfs(int[] nums, int cur, int pre) {
//        if(cur == nums.length){
//            ans++;
//            return;
//        }
//        for(int i = cur; i < nums.length - 1; i++){
//            if(cur == 0){
//                if(nums[i] % nums[i+1] == 0 || nums[i+1] % nums[i] == 0){
//                    dfs(nums,cur+1,0);
//                }
//            }
//        }
//    }
//}
