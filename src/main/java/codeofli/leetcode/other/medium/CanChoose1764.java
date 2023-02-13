package codeofli.leetcode.other.medium;

public class CanChoose1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int cur = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == groups[cur][0]){
                int k = 0,j = i;
                while(k < groups[cur].length && j < nums.length && groups[cur][k] == nums[j]){
                    j++;
                    k++;
                }
                if(k == groups[cur].length){
                    i = j - 1;
                    cur++;
                    if(cur == groups.length) return true;
                }
            }
        }
        return false;
    }
}
