package codeofli.leetcode.contest.c1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: codeofli
 * @create: 2022-10-29 22:32
 */
public class OddString {
    public String oddString(String[] words) {
        int m = words.length, n = words[0].length();
        var rec = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                rec[i][j] = words[i].charAt(j) -  words[i].charAt(j-1);
            }
        }
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            map.put(Arrays.toString(rec[i]),map.getOrDefault(Arrays.toString(rec[i]), 0) + 1 );

        }
        for(int i = 1; i < m; i++){
            if(!Arrays.equals(rec[i],rec[i-1])){
                if(map.get(Arrays.toString(rec[i])) == 1){
                    return words[i];
                }else {
                    return words[i-1];
                }
            }
        }
        return "";
    }
}
