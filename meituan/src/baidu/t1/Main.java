package baidu.t1;
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int k = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            int cnt = 0;
            int i = 0;
            double sum = 0;
            for(int j = 0; j < k - 1; j++){
                sum += nums[i++];
            }
            long total = 0;
            int len = 0;
            for(; i < n; i++){
                total +=  nums[i];
                len++;
            }
            sum += total *1.0 / len;
            System.out.println(sum);
        }
    }
}
