package exam.dw.t2;


import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        char[] cs = cin.next().toCharArray();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        long[] f = new long[n];
        final long mod = 1_000_000_000 + 7;
        f[0] = f[1] = 1;
        if (cs[0] == '1' && (cs[1] == '0' || cs[1] == '1')) {
            f[1] = 2;
        }

        for (int i = 2; i < n; i++) {
            if (cs[i-1] == '1' && (cs[i] == '0' || cs[i] == '1')) {
                f[i] = (f[i-1] + f[i-2]) % mod;
            }else{
                f[i] = f[i-1];
            }
        }
        System.out.println(f[n-1]);
    }
}