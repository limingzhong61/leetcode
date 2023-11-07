package test;

import java.util.concurrent.TimeUnit;

/**
 * @author: limingzhong
 * @create: 2023-06-30 21:39
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //String s = "00110";
        //String s = "0101110";
        String s = "011111";
        char[] cs = s.toCharArray();
        int cnt = 0, ans = 0;
        for(int i = cs.length - 1; i >= 0; i--){
            if(cs[i] == '0'){
                cnt++;
            }else{
                ans += cnt;
                cnt = 0;
            }
        }
        System.out.println(ans);
    }
}
