package codeofli.leetcode.other.easy;

/**
 * @author: codeofli
 * @create: 2022-11-29 9:55
 */
public class MinOperations1758 {
    /**
     * 0,1开始分别统计取最小
     */
    public int minOperations(String s) {
        int n = s.length();
        int min0 = 0,char0 = 0;
        int min1 = 0,char1 = 1;
        for(char c : s.toCharArray()){
            if(c - '0' == char0){
                min1++;
            }else{
                min0++;
            }
            char0 ^= 1;
        }
        return Math.min(min0,min1);
    }
}
