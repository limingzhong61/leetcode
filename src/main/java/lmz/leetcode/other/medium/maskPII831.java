package lmz.leetcode.other.medium;

import lmz.newcoder.Main;

/**
 * @author: limingzhong
 * @create: 2023-04-01 13:49
 */
public class maskPII831 {
    public String maskPII(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (!Character.isLetter(cs[0])) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (Character.isDigit(cs[i])) {
                    cnt++;
                }
            }
            cnt -= 10;
            int i = 0;
            if (cnt > 0) {
                sb.append('+');
                while(cnt > 0){
                    if (Character.isDigit(cs[i])) {
                        sb.append('*');
                        cnt--;
                    }
                    i++;
                }
                sb.append('-');
            }

            int dCnt = 0;
            for (; i < n; i++) {
                if (Character.isDigit(cs[i])) {

                    if(dCnt >= 6){
                        sb.append(cs[i]);
                    }else{
                        sb.append('*');
                    }
                    dCnt++;
                    if(dCnt % 3 == 0 && dCnt <= 6){
                        sb.append('-');
                    }
                    cnt--;
                }
            }
        } else { // email
            sb.append(Character.toLowerCase(cs[0]));
            for (int i = 0; i < 5; i++)
                sb.append('*');
            int idx = s.indexOf('@');
            if(idx < 0){
                System.out.println(s);
                return "";
            }
            sb.append(Character.toLowerCase(cs[idx-1]));
            sb.append('@');
            for(int i = idx+1; i < n; i++){
                sb.append(Character.toLowerCase(cs[i]));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        maskPII831 maskPII831 = new maskPII831();
        System.out.println(maskPII831.maskPII("1(234)567-890"));
    }
}
