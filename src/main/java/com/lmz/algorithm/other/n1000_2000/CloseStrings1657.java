package com.lmz.algorithm.other.n1000_2000;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;


/**
 * @author: limingzhong
 * @create: 2023-08-15 10:35
 */
public class CloseStrings1657 {
    /**
     * 首先需要： 字母出现相等;如 aabbc,cabb,都出现了 abc
     * 第一个操作：保证只要每个对应字母出现的次数相等，则可以成功
     * 第二个操作：保证只要字母出现的次数相等，则可以转变为每个对应字母出现的次数相等
     *
     * 把题意翻译成充要条件就是：
     *
     * 1两字符串的长度相同
     * 2两字符串的字符种类相同， 例如，对于某个字符，要么都有，要么都没有。
     * 符合：word1=abbccc，word2=caabbb，都有 a、b、c
     *
     * 不符合：word1=abbccc，word2=abbccd，word1 只有3类字符a、b、c，无论如何转换 不出有4类字符的 word2
     *
     * 3字符频次相同。跟具体是什么字符无关，只要频次相同即可。
     * 符合：word1=abbccc，word2=caabbb，都有1、2、3频次
     *
     * 不符合，word1=abbccc，word2=aabbcc，word1 频次有1、2、3，word2 的频次只有2
     *
     * 所以： 解题过程实际上在验证是否满足3个条件，而不是寻求满足 word1 转换到 word2 的方法
     */
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character,Integer> charCnt = new HashMap<>();
        for(char c : word1.toCharArray()){
            charCnt.put(c,charCnt.getOrDefault(c,0)+1);
        }

        HashMap<Character,Integer> charCnt2 = new HashMap<>();
        for(char c : word2.toCharArray()){
            charCnt2.put(c,charCnt2.getOrDefault(c,0)+1);
        }
        //  字母出现相等;如 aabbc,cabb,都出现了 abc
        if (!charCnt2.keySet().equals(charCnt.keySet())) {
            return false;
        }



        HashMap<Integer,Integer> cntCnt = new HashMap<>();
        for(Integer x : charCnt.values()){
            cntCnt.put(x,cntCnt.getOrDefault(x,0)+1);
        }




        HashMap<Integer,Integer> cntCnt2 = new HashMap<>();
        for(Integer x : charCnt2.values()){
            cntCnt2.put(x,cntCnt2.getOrDefault(x,0)+1);
        }
        //  字母出现次数相等;如 abbccc,aaabbc,都出现了 1,2,3次的字母个数都为1个
        return cntCnt2.equals(cntCnt);
    }

    public static void main(String[] args) {
        CloseStrings1657 closeStrings1657 = new CloseStrings1657();
        System.out.println(closeStrings1657.closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff"));

    }


}
