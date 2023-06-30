package lmz.algorithm.other.old.easy.old;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-02-01 9:27
 */
public class DecodeMessage2325 {
    public String decodeMessage(String key, String message) {
        //key 由小写英文字母及 ' ' 组成
        //message 由小写英文字母和 ' ' 组成
        int[] map = new int[26];
        int cnt = 0,fillVal = -1;
        Arrays.fill(map,fillVal);
        for (char c : key.toCharArray()) {
            if (c != ' ' && map[c - 'a'] == fillVal) {
                // System.out.println(map[c - 'a']);
                map[c - 'a'] = cnt++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                res.append(' ');
                continue;
            }
            res.append((char)(map[c - 'a'] +'a'));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        DecodeMessage2325 decodeMessage2325 = new DecodeMessage2325();
        System.out.println(decodeMessage2325.decodeMessage("the quick brown fox jumps over the lazy dog",
                "vkbs bs t suepuv"));
    }
}
