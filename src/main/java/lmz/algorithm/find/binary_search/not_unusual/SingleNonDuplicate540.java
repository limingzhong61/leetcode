package lmz.algorithm.find.binary_search.not_unusual;

import lmz.my.leetcode.TransformUtil;

public class SingleNonDuplicate540 {
    /**
     * 利用成对的性质，因为总是一对一对夹杂着出现的，这如果全是一对一对的总是偶数下标开始(0开始）
     * check-> [odd] == [odd - 1] ||
     * true,false; 单个x是第一个使上述关系不成立得下标，右边界
     */
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //当mid 是偶数时，mid+1=mid⊕1；
            //当 mid 是奇数时，mid−1=mid⊕1。
            if(nums[mid] == nums[mid ^ 1]){
                low = mid  + 1;
            }else{
                high = mid - 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        SingleNonDuplicate540 singleNonDuplicate540 = new SingleNonDuplicate540();
        System.out.println(singleNonDuplicate540.singleNonDuplicate(TransformUtil.toIntArray("[1,1,2,3,3,4,4,8,8]")));
    }
}
