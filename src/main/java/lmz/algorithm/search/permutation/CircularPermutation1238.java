package lmz.algorithm.search.permutation;

import java.util.ArrayList;
import java.util.List;

public class CircularPermutation1238 {
    /**
     * 全排列+剪枝
     *
     * p[0] = start
     * p[i] 和 p[i+1] 的二进制表示形式只有一位不同
     * p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
     */
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        int len = (1 << n )- 1;
        // System.out.println(len);
        int[] nums = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            nums[i] = i;
        }
        swap(nums, 0, start);
        int cur = 1;
        search(len, start, nums, cur, res);
        return res;
    }

    private void search(int n, int start, int[] nums, int cur, List<Integer> res) {
        if(res.size() > 0) return;
        if (cur == n + 1) {
            if (check(nums[0], nums[n])) {
                for(var x :nums){
                    res.add(x);
                }
                return;
            }
            return;
        }

        for (int i = cur; i <= n; i++) {
            if (check(nums[i], nums[i - 1])) {
                swap(nums, cur, i);
                search(n, start, nums, cur + 1, res);
                swap(nums, cur, i); // 修改后回溯
            }
        }
        return;
    }

    private boolean check(int a, int b) {
        int res = a ^ b;
        int cntOne = 0;
        while (res > 0) {
            if ((res & 1) == 1) {
                cntOne++;
            }
            res >>= 1;
        }
        return cntOne == 1;
    }


    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
