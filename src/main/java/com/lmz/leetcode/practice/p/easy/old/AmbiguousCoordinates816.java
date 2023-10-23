package com.lmz.leetcode.practice.p.easy.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: codeofli
 * @create: 2022-11-07 10:52
 */
public class AmbiguousCoordinates816 {
    /**
     * 如何获得一个字符串可以生成的所有合法数字？
     * 首先字符串本身是一个数字，然后同样是枚举分隔位置，加小数点。但是有以下几种特殊情况：
     *      1.如果只有一个数，则不能加小数点，返回它本身。
     *      2.如果字符串第一个数和最后一个数都是 0，则它必不合法。
     *      3.如果字符串第一个数不是 0 但最后一个数是 0，则它不能加小数点，因为会产生多余的 0。
     *      4.如果字符串有前导 0，则它只能以 0. 开头。
     */
    public List<String> ambiguousCoordinates(String s) {
        char[] cs = Arrays.copyOfRange(s.toCharArray(), 1, s.length() - 1);
        int n = cs.length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            List<String> leftList = digitCnt(cs, 0, i);
            List<String> rightList = digitCnt(cs, i + 1, n - 1);
            for (var s1 : leftList) {
                for (var s2 : rightList) {
                    res.add('(' + s1 + ", " + s2 + ')');
                    //System.out.printf("%s,%s\n", s1, s2);
                }
            }
        }
        return res;
    }

    private List<String> digitCnt(char[] cs, int start, int end) {
        List<String> list = new ArrayList<>();
        if (end == start) { //1.如果只有一个数，则不能加小数点，返回它本身。
            list.add(String.valueOf(cs[start]));
            return list;
        }
        if (cs[start] == '0' && cs[end] == '0') { // 2.如果字符串第一个数和最后一个数都是 0，则它必不合法。
            return list;
        }
        //3.如果字符串第一个数不是 0 但最后一个数是 0，则它不能加小数点，因为会产生多余的 0。
        if(cs[start] != '0' && cs[end] == '0'){
            list.add(String.valueOf(Arrays.copyOfRange(cs, start, end + 1)));
            return list;
        }
        if(cs[start] == '0'){ // 4.如果字符串有前导 0，则它只能以 0. 开头。
            // put dot in 0.
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            sb.append('.');
            for (int j = start + 1; j <= end; j++) {
                sb.append(cs[j]);
            }
            list.add(sb.toString());
            return list;
        }
        list.add(String.valueOf(Arrays.copyOfRange(cs, start, end + 1)));
        // put dot
        for (int i = start; i < end; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = start; j <= i; j++) {
                sb.append(cs[j]);
            }
            sb.append('.');
            for (int j = i + 1; j <= end; j++) {
                sb.append(cs[j]);
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        AmbiguousCoordinates816 ambiguousCoordinates816 = new AmbiguousCoordinates816();
        System.out.println(ambiguousCoordinates816.ambiguousCoordinates("(123)"));
    }
}
