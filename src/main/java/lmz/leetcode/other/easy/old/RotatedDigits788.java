package lmz.leetcode.other.easy.old;

public class RotatedDigits788 {
    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            char[] cs = String.valueOf(i).toCharArray();
            int cnt1 = 0;
            int cnt2 = 0;
            for (int j = 0; j < cs.length; j++) {
                if (cs[j] == '0' || cs[j] == '1' || cs[j] == '8' ){
                    cnt1++;
                }else if(cs[j] == '2' || cs[j] == '5' || cs[j] == '6' || cs[j] == '9'){
                    cnt2++;
                }else{

                    break;
                }
            }
            if(cnt1 + cnt2 == cs.length && cnt2 > 0){
                res++;
            }
        }
        return res;
    }
}
