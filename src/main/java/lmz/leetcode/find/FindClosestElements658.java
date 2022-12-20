package lmz.leetcode.find;

import lmz.my.leetcode.TransformUtil;

import java.util.*;


public class FindClosestElements658 {
    /**
     * 二分法+双指针
     * 先通过二分法找到一个离x最近的值，然后用双指针找到k个值
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = binarySearch(arr, x), left = right - 1; // 如果没有找到，则返回大于x的一个位置
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            if (left < 0) {
                res.add(arr[right++]);
                continue;
            } else if (right >= arr.length) {
                res.add(arr[left--]);
                continue;
            }
            int absL = Math.abs(x - arr[left]);
            int absR = Math.abs(x - arr[right]);
            if (absL <= absR) {
                res.add(arr[left--]);
            } else {
                res.add(arr[right++]);
            }
        }
        Collections.sort(res); // 对结果排序
        return res;
    }

    private int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }


    /**
     * 代码优化：利用绝对值排序，不用新建class
     * 先计算绝对差值，然后排序，前k个就是答案
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        //1 <= k <= arr.length
        //1 <= arr.length <= 104
        List<Integer> nums = new ArrayList<>(arr.length);
        for (int i : arr) {
            nums.add(i);
        }
        nums.sort((a, b) -> { // 按自然序相反排序
            int absA = Math.abs(x - a);
            int absB = Math.abs(x - b);
            if (absA == absB) {
                return a - b;
            }
            return absA - absB;
        });
        List<Integer> res = nums.subList(0, k);
        Collections.sort(res);
        return res;
    }

    /**
     * 先计算绝对差值，然后排序，前k个就是答案
     */
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        //1 <= k <= arr.length
        //1 <= arr.length <= 104
        int n = arr.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], Math.abs(x - arr[i]));
        }
        Arrays.sort(pairs, (a, b) -> {
            if (a.diff == b.diff) {
                return a.num - b.num;
            }
            return a.diff - b.diff;
        });
        List<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            res.add(pairs[i].num);
        }
        res.sort((a, b) -> a - b);
        return res;
    }

    class Pair {
        int num;
        int diff;

        Pair(int num, int diff) {
            this.num = num;
            this.diff = diff;
        }
    }

    public static void main(String[] args) {
        FindClosestElements658 findClosestElements = new FindClosestElements658();
        //testCase(findClosestElements, "[1,2,3,4,5]", 4, 3, "[1,2,3,4]");
        testCase(findClosestElements, "[0,0,1,2,3,3,4,7,7,8]", 3, 5, "[3,3,4]");
    }

    private static void testCase(FindClosestElements658 findClosestElements, String original, int k, int x, String original1) {
        System.out.println(findClosestElements.findClosestElements(
                TransformUtil.toIntArray(original), k, x));
        System.out.println(findClosestElements.findClosestElements(
                TransformUtil.toIntArray(original), k, x).equals(
                TransformUtil.toArrayList(original1)));
    }
}
