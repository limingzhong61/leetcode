package lmz.leetcode.contest.c322;

import java.util.Arrays;
import java.util.stream.IntStream;

public class dividePlayers {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int sum = IntStream.of(skill).sum();
        int n = skill.length;
        int need = sum / (n / 2);
        long res = 0;
        for(int i = 0; i < n / 2; i++){
            if(skill[i] + skill[n-i-1] != need){
                return -1 ;
            }
            res += (long)skill[i] * skill[n - i - 1];
        }
        return  res;
    }
}
