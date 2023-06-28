package lmz.algorithm.other.medium.old;

/**
 * @author: codeofli
 * @create: 2022-12-26 10:37
 */
public class CountHomogenous1759 {
    public int countHomogenous(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        final long mod = (long) (1e9 + 7);
        long res = 0;
        for(int i = 0; i < n; i++){
            int org = i;
            char start = cs[i];
            while(i + 1 < n && cs[i +1] == start){
                i++;
            }
            // System.out.printf("org=%d,i=%d\n",org,i);
            long len = i - org + 1;
            res = (res + len * (len + +1) / 2) % mod;
        }
        return (int) res;
    }
}
