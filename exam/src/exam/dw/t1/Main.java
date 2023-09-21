package exam.dw.t1;


import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String s = cin.next();
        char[] cs = s.toCharArray();
        int n = cs.length;
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('C',12);
        map.put('H',1);
        map.put('O',16);
        map.put('N',14);

        for (int i = 0; i < n; i++) {
            char c = cs[i];
            int cnt = 0;
            while(i + 1 < n &&Character.isDigit(cs[i+1])){
                i++;
                cnt = cnt * 10 + cs[i] - '0';

            }
            if(cnt == 0){
                cnt = 1;
            }
            ans += cnt * map.get(c);
        }
        System.out.println(ans);

    }
}
