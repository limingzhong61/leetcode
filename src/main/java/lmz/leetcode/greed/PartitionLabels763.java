package lmz.leetcode.greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels763 {
    /**
     * leetcode: 贪心
     * 于同一个字母只能出现在同一个片段，显然同一个字母的第一次出现的下标位置和最后一次出现的下标位置必须出现在同一个片段。
     * 因此需要遍历字符串，得到每个字母最后一次出现的下标位置。
     */
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    /**
     * 划分区间，然后合并
     * S的长度在[1, 500]之间。
     * S只包含小写字母 'a' 到 'z'
     */
    public List<Integer> partitionLabels1(String s) {
        final int letterCnt = 26;
        //用range数组分别记录每一个字母的[start,end]区间
        int[][] range = new int[letterCnt][2];
        for (int[] temp : range) {
            Arrays.fill(temp, -1);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            if (range[idx][0] == -1) {
                range[idx][0] = i;
            }
            range[idx][1] = i;
        }
        Arrays.sort(range, (a, b) -> a[0] - b[0]);

        //合并区间
        int start = -1, end = -1; //前一个区间的range
        int rangeCnt = 0;
        List<Integer> rangeLen = new ArrayList<>();
        for (int i = 0; i < letterCnt; i++) {
            if (range[i][0] != -1) {
                if (start == -1) {
                    start = range[i][0];
                    end = range[i][1];
                    rangeLen.add(end - start + 1);
                    continue;
                }
                if (end >= range[i][0]) { //相交
                    end = Math.max(end, range[i][1]);
                    rangeLen.set(rangeLen.size()-1,end -start + 1);
                } else {
                    start = range[i][0];
                    end = range[i][1];
                    rangeLen.add(end - start + 1);
                }
            }
        }
        return rangeLen;
    }
}
