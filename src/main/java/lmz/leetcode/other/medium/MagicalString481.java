package lmz.leetcode.other.medium;

/**
 * @author: codeofli
 * @create: 2022-10-31 16:37
 */
public class MagicalString481 {
    public int magicalString(int n) {
        var s1 = new int[n];
        var s2 = new int[n];
        int idx1 = 0, idx2 = 0;
        s1[idx1++] = 1;
        int groupCnt = 1;
        int oneCnt = 0;
        while (idx1 < n) {
            if (groupCnt == s1[idx2]) { //分组次数配对成功
                idx2++;
                s1[idx1] = s1[idx1 - 1] == 1 ? 2 : 1;
                idx1++;
                groupCnt = 1; //重置分组次数为1
            } else {  //分组次数不足
                s1[idx1] = s1[idx1 - 1];
                idx1++;
                groupCnt++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s1[i] == 1) {
                oneCnt++;
            }
        }
        return oneCnt;
    }

    public static void main(String[] args) {
        MagicalString481 magicalString481 = new MagicalString481();
        System.out.println(magicalString481.magicalString(6));
    }
}
