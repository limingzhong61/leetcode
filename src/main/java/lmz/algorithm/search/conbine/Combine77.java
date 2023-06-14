package lmz.algorithm.search.conbine;

import java.util.ArrayList;
import java.util.List;

public class Combine77 {
    /**
     * 利用子集生成的思想
     * 位向量法：构造一个位向量B[i]，而不是直接构造子集A本身，
     * 中当B[i]==1时表示A[i]的的元素被选取
     */
    public List<List<Integer>> combine(int n, int k) {
        boolean[] b = new boolean[n + 1];
        subset(n, b, 1, k);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    private void subset(int n, boolean[] b, int cur, int k) {
        if (k < 0) {  //选取元素过多
            return;
        }
        if (cur == n + 1) {
            if (k == 0) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 1; i <= n; i++) {
                    if (b[i]) {      //添加当前选取元素到集合
                        temp.add(i);
                    }
                }
                res.add(temp);
            }
            return;
        }
        b[cur] = true;     //选第cur个元素
        subset(n, b, cur + 1, k - 1);
        b[cur] = false;     //不选第cur个元素
        subset(n, b, cur + 1, k);
    }

    public static void main(String[] args) {
        Combine77 combine77 = new Combine77();
        System.out.println(combine77.combine(4, 2));
    }
}
