package com.lmz.algorithm.p.p_2000;

/**
 * @author: limingzhong
 * @create: 2023-08-10 14:30
 */
public class RemoveStars2390 {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int cnt = 0;
        for(int i = cs.length-1; i >= 0; i--){
            if(cs[i] == '*'){
                cnt++;
            }else{
                if(cnt > 0) cnt--;
                else{
                    sb.append(cs[i]);
                }

            }
        }
        return  sb.reverse().toString();
    }
}
