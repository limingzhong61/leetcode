package codeofli.leetcode.everyday;

import codeofli.my.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionSizeTwo757 {
    /**
     * leetcode: 贪心2
     */
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int pre1 = intervals[0][1] - 1, pre2 = intervals[0][1], ans = 2;
        for (int i = 1; i < intervals.length; i++) {
            //始终保持pre1<pre2
            if (pre1 >= intervals[i][0] && pre2 <= intervals[i][1]) {
                continue;
            }//两个数都在范围内
            else if (pre2 < intervals[i][0]) {
                //两个数都不在范围内
                ans += 2;
                pre1 = intervals[i][1] - 1;
                pre2 = intervals[i][1];
            } else if (pre1 < intervals[i][0]) {
                ans++;
                if (pre2 == intervals[i][1]) {
                    pre1 = pre2 - 1;
                } else {
                    pre1 = pre2;
                    pre2 = intervals[i][1]; // 贪心，取最右边
                }
            }
        }
        return ans;
    }

    /**
     * leetcode：贪心
     */
    public int intersectionSizeTwo2(int[][] intervals) {
        int n = intervals.length;
        int res = 0;
        int m = 2;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        // 记录每次intervals里面取了那m=2个值
        List<Integer>[] temp = new List[n];
        for (int i = 0; i < n; i++) {
            temp[i] = new ArrayList<Integer>();
        }
        for (int i = n - 1; i >= 0; i--) {
            //在当前intervals[i]的最左边开始尝试，（贪心）
            for (int j = intervals[i][0], k = temp[i].size(); k < m; j++, k++) {
                res++;
                //i-1在interval[i-1]中尝试添加j
                help(intervals, temp, i - 1, j);
            }
        }
        return res;
    }

    public void help(int[][] intervals, List<Integer>[] temp, int pos, int num) {
        for (int i = pos; i >= 0; i--) {
            if (intervals[i][1] < num) { // [0]...[1] 和num...不相交？
                break;
            }
            temp[i].add(num); // 相交添加元素
        }
    }

    /**
     * 找到一个最小的集合 S,S可以是多个区间合并在一起:错误
     */
    public int intersectionSizeTwo1(int[][] intervals) {
        //[1, 3000]
        int n = intervals.length;
        if (n == 1) {
            //一个整数区间 [a, b]  ( a < b ) ,则肯定>=2
            return 2;
        }
        //存储可能的取值<s,e>表示在<s,e>区间任意取两个长度的值都符合条件
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (nums1, nums2) -> {
            if (nums1[0] == nums2[0]) {
                return nums2[1] - nums1[1];
            }
            return nums1[0] - nums2[0];
        });

        list.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < n; i++) {
            boolean intersect = false;
            for (int j = 0; j < list.size(); j++) {
                int[] range = list.get(j);
                //相交且大于2
                if (range[0] < intervals[i][1] && range[1] > intervals[i][0]) {
                    //取交集
                    range[0] = Math.max(range[0], intervals[i][0]);
                    range[1] = Math.min(range[1], intervals[i][1]);
                    intersect = true;
                    break;
                }//不相交 或小于2
            }
            if (!intersect) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }

        }
        list.sort((nums1, nums2) -> nums1[0] - nums2[0]);
        int res = list.size() * 2;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1)[1] == list.get(i)[0]) { // 重叠一个
                res--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionSizeTwo757 intersectionSizeTwo = new IntersectionSizeTwo757();
        testCase(intersectionSizeTwo, " [[1, 3], [1, 4], [2, 5], [3, 5]]", 3);
        testCase(intersectionSizeTwo, " [[1, 2], [2, 3], [2, 4], [4, 5]]", 5);
        testCase(intersectionSizeTwo, "[[2,10],[3,7],[3,15],[4,11],[6,12],[6,16],[7,8],[7,11],[7,15],[11,12]]", 5);
        testCase(intersectionSizeTwo, "[[1,3],[1,2],[0,1]]", 3);
        testCase(intersectionSizeTwo, "[[6,21],[1,15],[15,20],[10,21],[0,7]]", 4);
        testCase(intersectionSizeTwo, "[[1,3],[4,9],[0,10],[6,7],[1,2],[0,6],[7,9],[0,1],[2,5],[6,8]]", 7);
    }

    private static void testCase(IntersectionSizeTwo757 intersectionSizeTwo, String original, int x) {
        System.out.println(intersectionSizeTwo.intersectionSizeTwo(
                TransformUtil.toIntMatrix(original)));
        System.out.println(intersectionSizeTwo.intersectionSizeTwo(
                TransformUtil.toIntMatrix(original)) == x);
    }
}
