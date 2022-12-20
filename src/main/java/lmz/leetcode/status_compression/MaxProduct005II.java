package lmz.leetcode.status_compression;

public class MaxProduct005II {
    /**
     * 状态压缩
     * 因为只含有小写字母，则可以用26位数组表示是否有相应的字母出现，
     * 而int有2^32，则可以将状态压缩为一个int.
     * 则两个字符没有相同字母表示为status[i] & status[j] = 0
     * words[i] 仅包含小写字母
     * O(n*n)
     * 2 <= words.length <= 1000
     */
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] status = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++){
            int stat = 0;
            for(int j = 0; j < words[i].length(); j++){
                stat |= (1 << (words[i].charAt(j) - 'a'));
            }
            status[i] = stat;
            for(int j = 0; j < i; j++){
                if((stat & status[j]) == 0){
                    res = Math.max(res,words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
