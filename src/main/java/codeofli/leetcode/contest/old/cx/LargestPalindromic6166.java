package codeofli.leetcode.contest.old.cx;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LargestPalindromic6166 {
    /**
     * 1 <= num.length <= 105
     * num 由数字（0 - 9）组成
     * <p>
     * 注意返回的整数不应含前导零。
     * 能够形成的最大回文整数。
     */
    public String largestPalindromic(String num) {
        char[] cs = num.toCharArray();
        Arrays.sort(cs);
        int[] numCnt = new int[10];
        for (char c : cs) {
            numCnt[c - '0']++;
        }
        int cntPair = 0, maxOddIdx = -1;
        for (int i = 0; i < 10; i++) {
            int x = numCnt[i];
            if(x >= 2){
                cntPair++;
            }
            if (x % 2 == 1) {
                maxOddIdx = Math.max(maxOddIdx, i);
            }
        }
        // 注意返回的整数不应含前导零。
        Deque<Character> deque = new LinkedList<>();
        if (maxOddIdx != -1) {
            deque.addFirst((char)(maxOddIdx + '0'));
        }
        // 只有1个0成对出现,不用添加;当有0且不止零时，可以添加
        if(!(numCnt[0] >=2 && cntPair == 1)){
            for (int i = 0; i < 10; i++) {
                int x = numCnt[i];
                int half = x / 2;
                for (int j = 0; j < half; j++) {
                    deque.addFirst((char) (i + '0'));
                }
                for (int j = 0; j < half; j++) {
                    deque.addLast((char) (i + '0'));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        if("".equals(sb.toString())){//全是0的情况
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LargestPalindromic6166().largestPalindromic("00011"));
        System.out.println(new LargestPalindromic6166().largestPalindromic("00011").equals("10001"));
    }
}
