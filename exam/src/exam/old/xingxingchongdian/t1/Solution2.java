package exam.old.xingxingchongdian.t1;


public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串
     * @return int整型
     */
    public int Substrings(String str) {
        // write code here
        char[] cs = str.toCharArray();
        int n = cs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j + 1 < n && cs[j + 1] == cs[i]) {
                j++;
            }
            int len = j - i + 1;
            i = j;
            ans += len * (len + 1) / 2;
        }
        return ans;
    }
}
