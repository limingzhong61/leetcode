package baidu.t2;
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int x = in.nextInt();
            char[] cs = new char[]{'r', 'e', 'd'};
            long n = 0, total;
            while (n * (n + 1) / 2 < x) {
                n++;
            }
            if(n * (n + 1) /  2 > x){
                n--;
            }

            long sub = x - n * (n + 1) / 2;
            for (int i = 0; i < n; i++) {
                System.out.printf("%c", 'd');
            }
            for (int i = 0; i < sub; i++) {
                System.out.printf("%c", cs[i % 3]);
            }
        }
    }
}
