package com.lmz.algorithm.other.old.divide_and_conquer;

import com.lmz.my.leetcode.TransformUtil;

import java.util.Arrays;

public class ReversePairs51 {
    /**
     * leetcode: 树状数组
     * 每次只需要计算两个归并小分组中的后一个，中的每一个数的逆序对个数就行了
     */
    public int reversePairs1(int[] nums) {
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
     * 归并统计逆序对
     * 每次只需要计算两个归并小分组中的后一个，中的每一个数的逆序对个数就行了
     */
    int count = 0;
    int[] temp;
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
        return count;
    }

    void mergeSort(int[] nums,int left,int right){
        if(left >= right) return;
        int mid = left + (right -left)/2; //开始递归划分
        mergeSort(nums,left,mid);       //归并排序左部分    [left,mid]
        mergeSort(nums,mid+1,right);        //归并排序右部分    [mid+1,right]

        merge(nums,left,mid,right);         //合并
    }

    void merge(int[] nums,int left,int mid,int right){
        int i = left; //左部分首元素
        int j = mid+1;  //右部分首元素
        int idx = left;


        while(i <= mid && j <= right){//在范围之内
            if(nums[i] <= nums[j]){
                temp[idx++] = nums[i++];
            }else{
                //  nums[i] > nums[j],包含i
                count += mid - i + 1;//只需要这行代码
                temp[idx++] = nums[j++];
            }
        }
        while(i <= mid ){   //左边还剩
            temp[idx++] = nums[i++];
        }
        while(j <= right){  //右边还剩
            temp[idx++] = nums[j++];
        }
        // System.out.println(Arrays.toString(nums));
        //将temp中的元素  全部都copy到原数组里边去
        idx = left;
        while(left <= right){
            nums[left++] = temp[idx++];
        }
        // System.out.println(Arrays.toString(nums));
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