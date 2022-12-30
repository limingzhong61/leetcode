package lmz.leetcode.other.easy;

/**
 * @author: limingzhong
 * @create: 2022-12-27 10:25
 */
public class MinimumMoves2027 {
    public int minimumMoves(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(cs[i] == 'X'){
                for(int j =0; j < 3 && j + i < n; j++){
                    cs[i + j] ='O';
                }
                cnt++;
            }
        }
        return  cnt;
    }
}
