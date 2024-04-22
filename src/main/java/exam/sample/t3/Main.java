package exam.sample.t3;

import java.util.HashMap;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        char[] cs = s.toCharArray();
        int ans = 0;
        for(int right = 0; right < n; right++){
            int max = 0;
            HashMap<Character,Integer> map = new HashMap<>();
            for(int left = right; left >= 0; left--){
                map.put(cs[left],map.getOrDefault(cs[left],0) + 1);
                max = Math.max(map.get(cs[left]),max);
                if(max * map.size() == right - left + 1){
                    ans++;
                    //System.out.println(k);
                    System.out.println(s.substring(left,right+1));
                    System.out.println("---");
                }
            }
        }
        System.out.println(ans);
    }

}
