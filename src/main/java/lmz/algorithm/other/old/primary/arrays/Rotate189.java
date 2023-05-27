package lmz.algorithm.other.old.primary.arrays;

public class Rotate189 {
    /**
     * my1:
     * 利用额外的数组
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] newNums = new int[n];
        k = k % n;//k很大，但n轮后就是原数组
        System.arraycopy(nums, 0, newNums, 0, n);
        for (int i = 0; i < n; i++) {
            nums[(i+k)%n] = newNums[i];
        }
    }

    /**
     * 法二：用3次逆置达到数组移动k位。
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; //k很大，但n轮后就是原数组
        reverseArray(nums, 0, n - k - 1);
        reverseArray(nums, n - k, n - 1);
        reverseArray(nums, 0, n - 1);
    }

    /**
     * [start,end]逆置
     *
     * @param nums
     * @param start
     * @param end
     */
    public void reverseArray(int[] nums, int start, int end) {
        for (; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

    /**
     * 方法二：环状替换
     * 官方解题算法
     */
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            int count = gcd(k, n);
            for (int start = 0; start < count; ++start) {
                int current = start;
                int prev = nums[start];
                do {
                    int next = (current + k) % n;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    current = next;
                } while (start != current);
            }
        }

        public int gcd(int x, int y) {
            return y > 0 ? gcd(y, x % y) : x;
        }

    }
}
