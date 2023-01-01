package lmz.leetcode.other.easy.old;

public class secondHighest {
    public int secondHighest(String s) {
        char[] cs = s.toCharArray();
        int max1 = -1,max2 = -1;
        for(var c : cs){
            if(Character.isDigit(c)){
                int val = c - '0';
                if(val > max1){
                    max1 = val;
                }else if(max1 == val){
                    max2 = max1;
                }else{
                    if(val > max2){
                        max2 = val;
                    }
                }
            }
        }
        return max2;
    }
}
