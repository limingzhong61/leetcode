package codeofli.leetcode.hash;

import java.util.Arrays;

public class IsIsomorphic205 {


    /**
     * 注意：有相同结构，是s->t,t->s有双向映射
     */
    public boolean isIsomorphic(String s, String t) {
        //s 和 t 由任意有效的 ASCII 字符组成
        int[] stMap =new int[128];
        int[] tsMap =new int[128];
        Arrays.fill(stMap,-1);
        Arrays.fill(tsMap,-1);
        //1 <= s.length <= 5 * 10^4
        int n = s.length();
        for(int i = 0; i < n; i++){
            char sc = s.charAt(i);
            char tc = s.charAt(i);
            if(stMap[sc] != -1){
                if(stMap[sc] != tc){
                    return false;
                }
            }else{
                stMap[sc] = tc;
            }
            if(tsMap[tc] != -1){
                if(tsMap[tc] != sc){
                    return false;
                }
            }else{
                tsMap[tc] = sc;
            }
        }
        return true;
    }
}
