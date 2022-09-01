package codeofli.leetcode.other.easy;

public class CountOdds1523 {
    /**
     将low统一为奇数，则答案为1 + (high-low)/2
     */
    public int countOdds1(int low, int high) {
        if(low == high){
            return low % 2 == 1 ? 1 : 0;
        }
        if(low % 2 == 0){
            low++;
        }
        return 1 + (high-low)/2;
    }

    /**
     * leetcode：奇偶是不是交替出现的，比如4，一定包含两个偶数，两个奇数。推广一点，任意一个数他有的奇数直接除2，如果这个数是奇数，就需要加1。7/2＝3(向下取整)，
     * 再加1就是7这个区间包含的奇数，总共4个奇数。这行代码就是在两个区间内取交集，你画一个区间图就明白了
     */
    public int countOdds2(int low, int high) {
        return (high+1)/2 - low/2;
    }
    /**
     * 前缀和思想
     */
    public int countOdds(int low, int high) {
        return pre(high) - pre(low - 1);
    }

    public int pre(int x) {
        return (x + 1) >> 1;
    }

}
