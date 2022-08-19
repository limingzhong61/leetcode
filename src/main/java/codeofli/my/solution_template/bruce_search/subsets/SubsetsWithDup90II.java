package codeofli.my.solution_template.bruce_search.subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsWithDup90II {
    /**
     * 全排列+set去重
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res =new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            if(!set.contains(temp)){
                res.add(temp);
                set.add(temp);
            }
        }
        return res;
    }
}
