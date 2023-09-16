package exam.old.meituan.t3;


import java.util.ArrayList;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        char[] cs = in.next().toCharArray();
        if (n == 1) {
            System.out.println(1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            if (i + 1 < n && cs[i] == cs[i + 1]) {
                i = i + 2;
            } else {
                list.add(cs[i] - '0');
                i++;
            }
        }
        int size = list.size();
        if(k * 2 <= size){
            size -= k * 2;
            System.out.println(size);
            // k * 2 > size
        }else{
            if(size % 2 == 0 && k % 2 == 1){
                System.out.println(2);
            }else{
                System.out.println(0);
            }
        }
    }
}
