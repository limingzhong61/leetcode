package lmz.leetcode.find.binary_search.not_unusual.function_calculate;

public class JudgeSquareSum633 {
    /**
     * 双指针
     */
    public boolean judgeSquareSum(int c) {
        long left = 0,right = (long)Math.sqrt(c);
        while(left <= right){
            long sum = left *left + right *right;
            if(sum == c){
                return  true;
            }else if(sum < c){
                left++;
            }else {
                right--;
            }
        }
        return false;
    }
    /**
     * 枚举，利用sqrt()
     */
    public boolean judgeSquareSum1(int c) {
        for (int a = 0; a <= Math.sqrt(c); a++) {
            int diff = c - a * a;
            int b = (int)Math.sqrt(diff);
            if (diff == b * b) {
                return true;
            }
        }
        return false;
    }

}
