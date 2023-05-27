package lmz.algorithm.contest.c321;

public class AppendCharacters {
    public int appendCharacters(String s, String t) {
        int is = 0,it = 0;
        while(is < s.length()){
            if(s.charAt(is) == t.charAt(it)){
                it++;
                if(it == t.length()) break;
            }
            is++;
        }
        return t.length() - it - 1;
    }
}
