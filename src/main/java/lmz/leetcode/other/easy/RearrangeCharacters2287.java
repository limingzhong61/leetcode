package lmz.leetcode.other.easy;

/**
 * @author: limingzhong
 * @create: 2023-01-13 10:18
 */
public class RearrangeCharacters2287 {
    public int rearrangeCharacters(String s, String target) {
        int letterLen = 26;
        int[] letterCnt = new int[letterLen];
        int[] record = new int[letterLen];
        for (char c : target.toCharArray()) {
            letterCnt[c - 'a']++;
        }
        int cnt = 0;
        for(char c : s.toCharArray()){
            record[c - 'a']++;
            if(check(letterCnt,record,letterLen)){
                cnt++;
            }
        }
        return cnt;
    }

    private boolean check(int[] letterCnt, int[] record, int letterLen) {
        for(int i = 0; i < letterLen; i++){
            if(record[i] < letterCnt[i]){
                return false;
            }
        }
        //匹配成功，删除之前的记录
        for(int i = 0; i < letterLen; i++){
            record[i] -= letterCnt[i];
        }
        return  true;
    }
}
