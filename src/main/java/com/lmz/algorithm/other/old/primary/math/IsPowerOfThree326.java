package com.lmz.algorithm.other.old.primary.math;

public class IsPowerOfThree326 {
    /**
     * my:迭代
     */
    public boolean isPowerOfThree(int n) {
        if(n == 0){
            return false;
        }
        while (n != 1){
            if(n % 3 != 0){
                return false;
            }
            n /= 3;
        }
        return true;
    }

    class Solution {
        /**
         * leetcode
         */
        public boolean isPowerOfThree(int n) {
            while (n != 0 && n % 3 == 0) {
                n /= 3;
            }
            return n == 1;
        }
    }


    public static void main(String[] args) {
        IsPowerOfThree326 isPowerOfThree326 = new IsPowerOfThree326();
        System.out.println(isPowerOfThree326.isPowerOfThree(27));
        System.out.println(isPowerOfThree326.isPowerOfThree(0));
        System.out.println(isPowerOfThree326.isPowerOfThree(9));
        System.out.println(isPowerOfThree326.isPowerOfThree(45));
        System.out.println(isPowerOfThree326.isPowerOfThree(1));
    }
}
