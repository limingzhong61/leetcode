package com.lmz.leetcode.practice.contest.old.c85;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class ShiftingLetters {
    public String shiftingLetters(String s, int[][] shifts) {
        //    1 <= s.length, shifts.length <= 5 * 10^4
        int n = s.length();
        char[] cs = s.toCharArray();
        long[] d = new long[n + 1];
        d[0] = 0;
        for (int i = 1; i < n; i++) {
            d[i] = cs[i] - cs[i - 1];
        }
        for (int[] shift : shifts) {
            int dir = shift[2];
            if (dir == 1) {
                d[shift[0]] += 1;
                d[shift[1] + 1] -= 1;
            } else {
                d[shift[0]] += -1;
                d[shift[1] + 1] -= -1;
            }
        }
        int letterCnt = 26;
        cs[0] = (char) (((cs[0] + d[0] - 'a')%letterCnt + letterCnt) % letterCnt + 'a');
        for (int i = 1; i < n; i++) {
            cs[i] = (char) (((cs[i - 1] + d[i] - 'a')%letterCnt + letterCnt) % letterCnt + 'a');
        }
        return String.valueOf(cs);
    }

    int getLg0(int x){
        if(x > 0){
            return x;
        }
        return  (- (x/26) + 1)*16 + x;
    }



    public static void main(String[] args) {
        ShiftingLetters shiftingLetters = new ShiftingLetters();
        //System.out.println(shiftingLetters.shiftingLetters("abc", TransformUtil.toIntMatrix("[[0,1,0],[1,2,1],[0,2,1]]")));
        //System.out.println(shiftingLetters.shiftingLetters("abc", TransformUtil.toIntMatrix("[[0,1,0],[1,2,1],[0,2,1]]")).equals("ace"));
        System.out.println(shiftingLetters.shiftingLetters("dztz", TransformUtil.toIntMatrix("[[0,0,0],[1,1,1]]")));
        System.out.println(shiftingLetters.shiftingLetters("dztz", TransformUtil.toIntMatrix("[[0,0,0],[1,1,1]]")).equals("catz"));

        System.out.println(shiftingLetters.shiftingLetters("dztz", TransformUtil.toIntMatrix("[[0,0,0],[1,1,1]]")));
        System.out.println(shiftingLetters.shiftingLetters("dztz", TransformUtil.toIntMatrix("[[0,0,0],[1,1,1]]")).equals("catz"));
    }
}
