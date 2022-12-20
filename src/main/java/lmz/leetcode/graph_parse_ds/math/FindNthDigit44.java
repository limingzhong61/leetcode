package lmz.leetcode.graph_parse_ds.math;

public class FindNthDigit44 {
    /**
     * leetcode 优化代码
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            start *= 10;
            digit += 1;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }


    public int findNthDigit1(int n) {
        if (n < 10) {
            return n;
        }
        //计算n的真正的位数
        int digitCnt = 1;
        long digitSum = 10;
        long lastDigitSum = 0;
        long base = 90;
        //每一轮的个数总和
        /**
         *,1：0-10
         *,2：10-10 + 90*2
         * 3：10 + 90*2-10 + 90*2+900*3
         */
        //找到最大位数
        while (n >= digitSum) {
            digitCnt++;
            lastDigitSum = digitSum;
            digitSum += base * digitCnt;
            base *= 10;
        }
        /**
         * 现在 n 介于 lastDigitSum，digitSum
         * 位数为 digitCnt;
         */
        long diff = n - lastDigitSum;
        /**
         * 差值/当前位数+当前基础（10|100,1000）
         * 找到当前真实的值num
         */
        int num = (int) (diff / digitCnt) + (int) Math.pow(10, digitCnt - 1);
        int digitIndex = (int) diff % digitCnt;
        //在num中取出对应的位数
        int ans =(num / (int)(Math.pow(10, digitCnt - digitIndex - 1))) % 10;
        return ans;
    }


    public static void main(String[] args) {
        FindNthDigit44 findNthDigit44 = new FindNthDigit44();

        System.out.println(findNthDigit44.findNthDigit(11));
        System.out.println(findNthDigit44.findNthDigit(11) == 0);

        System.out.println(findNthDigit44.findNthDigit(3));
        System.out.println(findNthDigit44.findNthDigit(3) == 3);

        System.out.println(findNthDigit44.findNthDigit(10));
        System.out.println(findNthDigit44.findNthDigit(10) == 1);
    }
}
