package com.lmz.leetcode.practice.p.p_1000_2000;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: limingzhong
 * @create: 2023-08-04 14:48
 */
public class ReverseVowels345 {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(List.of('A', 'E', 'I', 'O', 'U'));
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] cs = s.toCharArray();
        for(int i = 0, j = cs.length - 1; i < j ;i++,j--){
            while(i < j && !set.contains(cs[j] )) j--;
            while(i < j && !set.contains(cs[i] )) i++;
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
        }
        return String.valueOf(cs);
    }
}
