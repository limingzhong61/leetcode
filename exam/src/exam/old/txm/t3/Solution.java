package exam.old.txm.t3;


import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param t string字符串
     * @return int整型
     */
    public int cntOfMethod(String t) {
        if (t.length() <= 2) return t.length();
        // write code here
        char[] cs = t.toCharArray();
        int n = cs.length;
        long[] f = new long[n];
        f[0] = 1;
        final long mod = 1_000_000_000 + 7;
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            f[i] = (f[i] + f[i-1]) % mod;
            for (int j = 0; j < i; j++) {
                set.add(t.substring(j,i+1));
            }
            for(String s : set){

                if(s.length() + i + 1 <= n){
                    String sub = t.substring(i + 1, i + s.length() + 1);
                    if(sub.equals(s)){
                        f[s.length() + i] = (f[s.length() + i] + f[i]) % mod;
                    }

                }
            }
        }
        System.out.println(Arrays.toString(f));
        return (int) f[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cntOfMethod("ababa"));
    }
}
