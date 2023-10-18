package com.lmz.algorithm_practice.other.easy.old;

/**
 * @author: codeofli
 * @create: 2022-11-06 14:09
 */
public class Interpret1678 {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        char[] cs = command.toCharArray();
        for(int i = 0; i < cs.length; i++){
            if(cs[i] == '('){
                if(cs[i+1] == ')'){
                    sb.append('o');
                }
            } else if (cs[i] == ')') {

            }else{
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }
}
