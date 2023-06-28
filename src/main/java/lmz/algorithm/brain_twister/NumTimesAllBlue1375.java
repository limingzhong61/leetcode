package lmz.algorithm.brain_twister;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: limingzhong
 * @create: 2023-06-14 9:43
 */
public class NumTimesAllBlue1375 {
    /**
     * 如果添加了f[i]后，刚好有1--i+1全为1，则ans++
     */
    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        HashSet<Integer> set = new HashSet<>();
        int start = 0,ans = 0;
        for(int i = 0; i < n; i++){
            set.add(flips[i]);
            while(set.contains(start+1)) start++;
            if(start == i + 1){
                ans++;
            }
        }
        return ans;
    }
}
