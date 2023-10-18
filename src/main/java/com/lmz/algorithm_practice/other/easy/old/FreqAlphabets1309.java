package com.lmz.algorithm_practice.other.easy.old;

/**
 * @author: codeofli
 * @create: 2022-11-25 9:58
 */
public class FreqAlphabets1309 {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i++){
            if(s.charAt(i) != '#'){
                sb.append((char)(s.charAt(i) - '0' + 'a'));
            }else{
                int val = s.charAt(i - 1) - '0' + (s.charAt(i - 1) - '0') * 10;
                sb.append((char)(val + 'a'));
            }
        }
        return sb.reverse().toString();
    }
}
