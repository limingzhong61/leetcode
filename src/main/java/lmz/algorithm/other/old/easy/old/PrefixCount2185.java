package lmz.algorithm.other.old.easy.old;

/**
 * @author: limingzhong
 * @create: 2023-01-08 11:01
 */
public class PrefixCount2185 {
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for(String word : words){
            if(word.startsWith(pref)){
                cnt++;
            }
        }
        return cnt;
    }
}
