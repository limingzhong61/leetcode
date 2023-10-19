package com.lmz.leetcode.practice.other.medium.old;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class AdvantageCount870 {
    /**
     * 贪心算法：lc优化
     * nums
     * 在本题中，由于nums1中的每一个元素都要与nums
     * 2中的元素配对，而我们是按照顺序考虑nums2中的元素的。
     * 因此在遍历结束后，\textit{nums}_2nums2中剩余的元素实际上是原先 \textit{nums}_2nums2的一个后缀。因此当 \textit{nums}_1nums
     * 1
     * 
     *   的首个元素无法配对时，我们给它配对一个 \textit{nums}_2nums 
     * 2
     *   的尾元素即可，并将该尾元素移除。
     * 排序后+双指针
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int n = nums1.length;
        // sortedNums2Val,index,res
        int[][] pair = new int[n][3];
        for(int i = 0; i < n; i++){
            pair[i][0] = nums2[i];
            pair[i][1] = i;
        }
        Arrays.sort(pair,(a,b) -> a[0] - b[0]);
        //  用栈记录没被使用的nums1
        Deque<Integer> stack = new LinkedList<>();
        //1 <= nums1.length <= 10^5
        int[] res = new int[n];
        int idx = 0;
        int idx2 = 0;
        for(; idx2 < n; idx2++){
            pair[idx2][2] = Integer.MAX_VALUE;
            while(idx < n && nums1[idx] <= pair[idx2][0]){
                stack.add(nums1[idx]);
                idx++;
            }
            if(idx >= n){ //nums1中已经没有更大的值了，而且
                break;
            }
            pair[idx2][2] = nums1[idx];
            idx++; // 此idx已经被使用
        }
        idx = 0;
        while(!stack.isEmpty()){
            pair[idx2++][2] = stack.pop();
        }
        for(int i = 0; i < n; i++){
            res[pair[i][1]] = pair[i][2];
        }
        return res;
    }

    public static void main(String[] args) {
        AdvantageCount870 advantageCount870 = new AdvantageCount870();
        System.out.println(Arrays.toString(advantageCount870.advantageCount(TransformUtil.toIntArray("[2,0,4,1,2]"),
                TransformUtil.toIntArray("[1,3,0,0,2]"))));
    }
}
