package lmz.leetcode.other.medium;

import java.util.ArrayList;

/**
 * @author: codeofli
 * @create: 2022-11-25 9:30
 */
public class ExpressiveWords809 {
    public int expressiveWords(String s, String[] words) {
        ArrayList<Character> cList = new ArrayList<>();
        ArrayList<Integer> iList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while(j + 1 < s.length() && s.charAt(j + 1) == s.charAt(i)){
                j++;
            }
            cList.add(s.charAt(i));
            iList.add(j - i + 1);
            // System.out.printf("%c,%d\n",cList.get(cList.size()-1),iList.get(cList.size()-1));
            i = j;
        }
        // System.out.printf("\n");
        int res = 0;
        for(String word : words){
            int idx = 0;
            int i = 0;
            for(; i < word.length(); i++){
                if(idx == cList.size()){
                    break;
                }
                if(cList.get(idx) != word.charAt(i)){
                    break;
                }
                int j = i;
                while(j + 1 < word.length() && word.charAt(j + 1) == word.charAt(i)){
                    j++;
                }
                int cnt = j - i + 1;
                int cnt0 = iList.get(idx);
                if(cnt != cnt0){
                    if(cnt > cnt0){ //比给定字符串长
                        break;
                    }
                    //比给定字符串短，只有2不可达
                    if(cnt0 == 2){
                        break;
                    }
                }
                // System.out.printf("%c,%d,%d\n",word.charAt(i),cnt,cnt0);
                i = j;
                idx++;
            }
            if(idx == cList.size() && i == word.length()){
                res++;
            }
        }
        return res;
    }
}
