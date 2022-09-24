package codeofli.leetcode.other.easy;

public class Decrypt1652 {
    /**
     * lc: 不需要分情况
     */
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int ans [] = new int[len];
        int e = k >= 0 ? k == 0 ? 0 : 1 : -1;  //e取值为：[0,1,-1]
        for(int i = 0; i < len; i++){
            int sum = 0;
            for(int j = e; j != k + e; j += e){
                sum += code[(i + j + len) % len];
            }
            ans[i] = sum;
        }
        return ans;
    }

    public int[] decrypt1(int[] code, int k) {
        int len = code.length;
        int[] res = new int[len];
        if (k == 0) {
            return res;
        }
        if (k < 0) {
            for (int i = 0; i < len; i++) {
                int sum = 0;
                for (int j = 1; j >= k; j--) {
                    sum += code[(i - j + len) % len];
                }
                res[i] = sum;
            }
        } else {
            for (int i = 0; i < len; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += code[ (i + j) % len];
                }
                res[i] = sum;
            }
        }
        return res;
    }
}
