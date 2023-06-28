package lmz.algorithm.recall;

import java.util.ArrayList;
import java.util.List;

public class Combine80II {
    /**
     * 位向量法：递归
     * 用一个数组b表示i是否被选中
     */
    public List<List<Integer>> combine(int n, int k) {
        boolean[] a = new boolean[n+1];
        search(a,n,k,1);
        return res;
    }
    List<List<Integer>> res = new ArrayList<>();
    private void search(boolean[] b,int n, int k,int cur) {
        if(k < 0){ //选取数超过k个，剪枝
            return;
        }
        if(cur == n+1){
            if(k == 0){
                List<Integer> temp = new ArrayList<>();
                for(int i= 1; i <= n; i++){
                    if(b[i]){
                        temp.add(i);
                    }
                }
                res.add(temp);
            }
            return;
        }
        b[cur] = true;
        search(b,n,k-1,cur+1);
        b[cur] = false;
        search(b,n,k,cur+1);
    }

    public static void main(String[] args) {
        Combine80II combine80II = new Combine80II();
        System.out.println(combine80II.combine(4, 2));
        System.out.println(combine80II.combine(20, 10));
    }

}
