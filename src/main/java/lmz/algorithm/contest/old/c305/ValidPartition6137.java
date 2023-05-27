package lmz.algorithm.contest.old.c305;

import java.util.HashMap;
import java.util.Map;

public class ValidPartition6137 {
    /**
     * 记忆化搜索
     */
    public boolean validPartition(int[] nums) {
        return search(nums,0,nums.length-1);
    }
    Map<String,Boolean> map = new HashMap<>();
    private boolean search(int[] nums, int left, int right) {
        if(left > right){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(left).append(',').append(right);
        if(map.containsKey(sb.toString())){
            return  map.get(sb.toString());
        }

        if(left+1 <= right && nums[left] == nums[left+1]){
            if(left+1 == right){
                map.put(sb.toString(),true);
               return true;
            }
            if(left+2 <= right && nums[left+ 1] == nums[left+ 2]){
                if(left+2 == right){
                    map.put(sb.toString(),true);
                    return true;
                }
                //System.out.println(nums[left] + ","+nums[left+1] + ","+nums[left+2] + ",");
                if(search(nums,left+3,right)){
                    map.put(sb.toString(),true);
                    return true;
                }
            }
            //System.out.println(nums[left] + ","+nums[left+1]);
            if(search(nums,left+2,right)){
                map.put(sb.toString(),true);
                return true;
            }
        }
        if(left+2 <= right && nums[left+ 2] - nums[left+ 1] == 1 && nums[left+1] - nums[left] == 1){
            if(left+2 == right){
                map.put(sb.toString(),true);
                return true;
            }
            //System.out.println(nums[left] + ","+nums[left+1] + ","+nums[left+2] + ",");
            if(search(nums,left+3,right)){
                map.put(sb.toString(),true);
                return true;
            }
        }
        //System.out.println("----------------划分error------------");
        map.put(sb.toString(),false);
        return false;
    }



}
