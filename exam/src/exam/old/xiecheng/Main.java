package exam.old.xiecheng;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。



import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
public class Main {
    static  int ans = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        dfs(arr, 0);
        System.out.println(ans);
    }
    static HashSet<String> set = new HashSet<>();
    private static void dfs(int[] arr, int cur) {
        if (cur == arr.length) {
            //if(set.contains(Arrays.toString(arr))){
            //    return;
            //}
            //set.add(Arrays.toString(arr));
            ans++;
            //System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = cur; i < arr.length; i++) {
            if (cur == 0 || (cur > 0 && !isPrime(arr[cur - 1] + arr[i]))) {
                //System.out.println(Arrays.toString(arr));
                // System.out.println(cur);
                swap(arr, cur, i);
                dfs(arr, cur + 1);
                // 回溯
                swap(arr, cur, i);
            }
        }
    }

    private static void swap(int[] arr, int cur, int i) {
        int t = arr[i];
        arr[i] = arr[cur];
        arr[cur] = t;
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0)return false;
        }
        return true;
    }
}