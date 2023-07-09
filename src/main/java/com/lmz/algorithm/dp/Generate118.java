package com.lmz.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

//118. 杨辉三角
public class Generate118 {
    /**
     * 第i层(层数从0开始)有i+1个:
     * (i,0)=(i,i) = 1;其他：
     * (i,j) = (i-1,j-1)+(i-1,j)
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>(1);
        list.add(1);
        ans.add(list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> last = ans.get(i-1);
            list = new ArrayList<>(i+1);
            list.add(1);
            for (int j = 1; j < i; j++) { //
                list.add(last.get(j) + last.get(j-1));
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        Generate118 generate118 = new Generate118();
        System.out.println(generate118.generate(5));
    }
}
