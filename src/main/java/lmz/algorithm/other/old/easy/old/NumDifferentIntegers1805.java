package lmz.algorithm.other.old.easy.old;

import java.util.HashSet;

/**
 * @author: codeofli
 * @create: 2022-12-06 9:26
 */
public class NumDifferentIntegers1805 {
    public int numDifferentIntegers(String word) {
        char[] cs = word.toCharArray();
        int n = cs.length,res = 0;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(Character.isDigit(cs[i])){
                int j = i;
                StringBuilder sb = new StringBuilder();
                sb.append(cs[i]);
                while(j + 1 < n && Character.isDigit(cs[j+1])){
                    j++;
                    sb.append(cs[j]);
                }
                // 前导的0
                int k = 0;
                for(; k < sb.length() - 1; k++){
                    if(sb.charAt(k) != '0'){
                        break;
                    }
                }
                sb.delete(0,k);
                // System.out.println(sb.toString());
                if(!set.contains(sb.toString())){
                    set.add(sb.toString());
                    res++;
                }
                i = j;
            }
        }
        return res;
    }
}
