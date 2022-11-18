package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Test {
    /**
     * 向量法：构造一个B[i]，而不是直接构造子集A本身，
     * 其中当B[i]==j时表示A[i]的元素被选为分组group[j]
     */
    public List<List<List<Integer>>> combine(int[] nums, int[] groups) {
        int[] b = new int[nums.length];
        subset(nums,groups, b, 0);
        return res;
    }

    List<List<List<Integer>>> res = new ArrayList<>();

    private void subset(int[] nums, int[] groups, int[] b, int cur) {
        int n = nums.length;
        if (cur == n) {
            List<List<Integer>> temp = new ArrayList<>();
            for(int i = 0; i < groups.length; i++){
                temp.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                temp.get(b[i]).add(i);
            }
            for(int i = 0; i < groups.length; i++){
                if(temp.get(i).size() != groups[i]){
                    return;
                }
            }
            res.add(temp);
            return;
        }
        for(int i = 0; i < groups.length; i++){
            b[cur] = i;     //选第cur个元素到group[i]
            subset(nums,groups, b, cur + 1);
            //b[cur] = 0;
        }

    }

    public static void main(String[] args) {
        Test test = new Test();
        List<List<List<Integer>>> combine = test.combine(IntStream.range(0, 12).toArray(),
                new int[]{3, 5, 4});
        System.out.println(combine.size());
        System.out.println(combine);
    }


}
