package lmz.leetcode.find.binary_search.not_unusual;

/**
 * @author: codeofli
 * @create: 2022-11-05 10:49
 */
public class SearchII81 {
    /**
     * 暴力枚举
     * O(N)
     */
    public boolean search(int[] nums, int target) {
        for(var n : nums){
            if(n == target){
                return true;
            }
        }
        return  false;
    }
}
