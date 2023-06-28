package exam.t1.t2;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 输入各台手机的剩余电量，返回能坚持的最大时间
     *
     * @param batteries int整型一维数组 每台手机剩余电量，[0,100]之间
     * @return int整型
     */
    public int maxTime(int[] batteries) {
        Arrays.sort(batteries);
        int n = batteries.length;
        if (n < 5) {
            return 0;
        }
        int[] arr = new int[5];
        int res = 0;
        int idx = 0;
        for (int i = n - 1; i > n - 5; i--) {
            arr[idx++] = batteries[i];
        }
        res += getMin(arr);
        for (int i = n - 5; i >= 0; ) {
            Arrays.sort(arr);
            for (int j = 0; j < 5; j++) {
                if (arr[j] != 0) {
                    break;
                } else {
                    arr[j] = batteries[i--];
                    if (i < 0) {
                        break;
                    }
                }
            }

            res += getMin(arr);
        }
        return res;

    }

    private static int getMin(int[] arr) {
        int min = arr[0];
        for (int j = 0; j < 5; j++) {
            min = Math.min(min,arr[j]);
        }
        for (int j = 0; j < 5; j++) {
            arr[j] -= min;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxTime(new int[]{100, 100, 100, 50, 100, 5, 10}));
    }
}
