package lmz.leetcode.graph_parse_ds.divide_and_conquer;

import lmz.my.leetcode.TransformUtil;

import java.util.Arrays;

public class ReversePairs51 {
    /**
     * leetcode: 树状数组
     * 每次只需要计算两个归并小分组中的后一个，中的每一个数的逆序对个数就行了
     */
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        System.arraycopy(nums, 0, tmp, 0, n);
        // 离散化
        Arrays.sort(tmp);
        for (int i = 0; i < n; ++i) {
            nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
        }
        // 树状数组统计逆序对
        BIT bit = new BIT(n);
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            ans += bit.query(nums[i] - 1);
            bit.update(nums[i]);
        }
        return ans;
    }


    /**
     * 利用归并排序
     * 每次只需要计算两个归并小分组中的后一个，中的每一个数的逆序对个数就行了
     */
    int[] copied;
    int[] sorted;
    int cnt = 0;

    public int reversePairs1(int[] nums) {
        sorted = nums;
        cnt = 0;
        copied = new int[nums.length];
        mergeSortCnt(0, nums.length-1);
        return cnt;
    }

    private void mergeSortCnt(int start, int end) {
        if (start >= end) {
            return;
        }
        int half = start + (end - start) / 2;
        mergeSortCnt(start, half);
        mergeSortCnt(half + 1, end);
        merge(start,half, end);
    }

    private void merge(int start,int half, int end) {
        int index = start;

        //复制数组用于比较
        for(int i = start; i <= end;i++){
            copied[i] = sorted[i];
        }
        int i,j;
        for (i = start, j = half + 1; i <= half && j <= end; ) {
            //采用小于等于时，归并排序才是一个稳定的排序
            if (copied[i] <= copied[j]) {
                sorted[index++] = copied[i++];
            } else {
                cnt += half - i + 1;
                sorted[index++] = copied[j++];
            }
        }
        for (;i <= half; i++) {
            sorted[index++] = copied[i];
        }
        for (;j <= end; j++) {
            sorted[index++] = copied[j];
        }
    }

    public static void main(String[] args) {
        ReversePairs51 reversePairs51 = new ReversePairs51();
        System.out.println(reversePairs51.reversePairs(TransformUtil.toIntArray("[7,5,6,4]")));
        System.out.println(reversePairs51.reversePairs(TransformUtil.toIntArray("[7,5,6,4]")) == 5);
        System.out.println(reversePairs51.reversePairs(TransformUtil.toIntArray("[1,3,2,3,1]")));
        System.out.println(reversePairs51.reversePairs(TransformUtil.toIntArray("[1,3,2,3,1]")) == 4);
    }
}
class BIT {
    private int[] tree;
    private int n;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public static int lowbit(int x) {
        return x & (-x);
    }

    public int query(int x) {
        int ret = 0;
        while (x != 0) {
            ret += tree[x];
            x -= lowbit(x);
        }
        return ret;
    }

    public void update(int x) {
        while (x <= n) {
            ++tree[x];
            x += lowbit(x);
        }
    }
}