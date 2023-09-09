package exam.meituan.t1;



import java.util.HashMap;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();

        HashMap<Character,String> map = new HashMap<>();
        map.put('a',"bc");
        map.put('b',"ca");
        map.put('c',"ab");
        for(int i = 0; i < k; i++){
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                sb.append(map.get(c));
            }
            s = sb.toString();
        }
        System.out.println(s);
    }
}
