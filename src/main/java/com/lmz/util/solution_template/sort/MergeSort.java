package com.lmz.util.solution_template.sort;

/**
 * 解题代码，并非正确代码
 * 对数组进行排序
 */
public class MergeSort {
    int[] temp;

    /**
     * 归并排序
     * @param nums
     * @return
     */
    public int[] mergeSort(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        //System.out.println(Arrays.toString(nums));
        return nums;
    }

    void mergeSort(int[] nums,int left,int right){
        if(left >= right) return;
        //因为mid一直向下取整，则一定会偏向于left,所以左边[left,mid]，右边[mid+1,right];
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
}
