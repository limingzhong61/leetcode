package lmz.leetcode.other.easy.old;

/**
 * @author: limingzhong
 * @create: 2022-10-22 10:56
 */
public class CheckString2124 {
    public boolean checkString(String s) {
        char a = 'a', b= 'b';
        boolean findB = false;
        for(char c : s.toCharArray()){
            if(c == 'b'){
                findB = true;
            }else {
                if(findB){
                    return false;
                }
            }
        }
        return true;
    }
}
