package codeofli.leetcode.find.kth.easy;

public class FindKthPositive1539 {
    /**
     * leetcode评论：
     * 1.缺失的正整数一定 >= k
     * 2.数组中每出现一个 <= k 的数字, 意味着少了一个缺失的数字, 此时k+1
     */
    public int findKthPositive(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                k++;
            }
        }

        return k;
    }
    /**
     * 1 <= arr.length <= 1000
     * 范围小，暴力查询
     */
    public int findKthPositive1(int[] arr, int k) {
        int next =  1;
        for(int i = 0; i < arr.length; i++){
            while(next != arr[i]){
                next++;
                k--;
                if(k == 0){
                    return next;
                }
            }
        }
        while ( k != 0){
            next++;
        }
        return next;
    }
}
