package lmz.leetcode.bruce_solution.bruce_search.subsets;

import lmz.my.leetcode.TransformUtil;

import java.util.*;

public class SubsetsWithDup90II {

    /**
     * 排序+排除重复选择：
     * 考虑数组 [1, 2, 2]，选择前两个数，或者第一、三个数，都会得到相同的子集。
     * 也就是说，对于当前选择的数 x，若前面有与其相同的数 y，且没有选择 y，此时包含 x的子集，必然会出现在包含 y 的所有子集中。
     * 我们可以通过判断这种情况，来避免生成重复的子集。代码实现时，可以先将数组排序；
     * 迭代时，若发现没有选择上一个数，且当前数字与上一个数相同，则可以跳过当前生成的子集。
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        //1 <= nums.length <= 10
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            boolean ok = true;
            temp.clear();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {     //选择了第j位
                    if (j > 0 && (i & (1 << (j - 1))) == 0 && nums[j] == nums[j - 1]) { //当前j位被选中，但是前一位的数字和当前位相同且未被选中，会产生重复的子集
                        ok = false;
                        break;
                    }
                    temp.add(nums[j]);
                }
            }
            if (ok) {
                res.add(new ArrayList<>(temp));
            }
        }
        return res;
    }

    /**
     * 枚举子集+set去重
     */
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            temp.sort((Integer::compareTo)); //排序，防止顺序不同
            if (!set.contains(temp)) {
                res.add(temp);
                set.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubsetsWithDup90II subsetsWithDup90II = new SubsetsWithDup90II();
        System.out.println(subsetsWithDup90II.subsetsWithDup(TransformUtil.toIntArray("[1,2,2]")));
        //System.out.println(subsetsWithDup90II.subsetsWithDup(TransformUtil.toIntArray("[1,2,2]"))
        //        .equals(TransformUtil.toDoubleArrayList("[[],[1],[1,2],[1,2,2],[2],[2,2]]")));
        System.out.println(subsetsWithDup90II.subsetsWithDup(TransformUtil.toIntArray("[4,4,4,1,4]")));
        System.out.println("[[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]");
        //System.out.println(TransformUtil.toDoubleArrayList("[[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]").equals(subsetsWithDup90II.subsetsWithDup(TransformUtil.toIntArray("[4,4,4,1,4]"))));
    }
}
