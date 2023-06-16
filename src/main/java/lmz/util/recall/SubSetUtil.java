package lmz.util.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-06-15 22:35
 */
public class SubSetUtil {
    /**
     * 思路：选和不选
     * 在nums集合中生成全部的子集
     *
     * @param nums 集合
     * @return nums集合中生成全部的子集
     */
    public static List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    private static List<List<Integer>> ans = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    private static void dfs(int[] nums, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不选 nums[i]
        dfs(nums, i + 1);
        // 选 nums[i]
        path.add(nums[i]);
        dfs(nums, i + 1);
        path.remove(path.size() - 1); // 恢复现场
    }
}
