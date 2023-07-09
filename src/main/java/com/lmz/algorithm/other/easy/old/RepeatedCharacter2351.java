package com.lmz.algorithm.other.easy.old;

/**
 * @author: limingzhong
 * @create: 2023-01-01 9:55
 */
public class RepeatedCharacter2351 {
    public char repeatedCharacter(String s) {
        final  int N = 26;
        boolean[] letters =  new boolean[N];
        for(var c : s.toCharArray()){
            if(letters[c - 'a']){
                return  c;
            }
            letters[c - 'a'] = true;
        }
        return ' ';
    }
}
