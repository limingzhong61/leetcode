package lmz.algorithm.search.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-06-11 21:07
 */
public class SearchUtil {
    /**
     * 选和不选
     */
    public static  List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return ans;
    }
    private static final  List<List<Integer>> ans = new ArrayList<>();
    private static final  List<Integer> path = new ArrayList<>();
    private static void  dfs(int[] nums, int i) {
        if(i == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不选 nums[i]
        dfs(nums,i+1);
        // 选 nums[i]
        path.add(nums[i]);
        dfs(nums,i+1);
        path.remove(path.size()-1); // 恢复现场
    }
}
