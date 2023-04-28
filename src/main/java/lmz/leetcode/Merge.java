package lmz.leetcode;

import lmz.my.leetcode.TransformUtil;
import lmz.newcoder.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-04-28 13:57
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return  new int[0][0];
        }
        Arrays.sort(intervals,(a,b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return  a[0] - b[0];
        });
        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i = 1; i < n; i++){
            int[] a = list.get(list.size()-1);
            int[] b = intervals[i];
            // 因为a[0] <= b[0]所以 a[0] <= b[1]
            if(a[1] >= b[0]){
                //list.set(list.size()-1,new int[]{Math.min(b[0],b[0]),Math.max(b[1],b[1])});
                list.get(list.size()-1)[1] = Math.max(b[1],a[1]);
            }else{
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        System.out.println(Arrays.deepToString(merge.merge(TransformUtil.toIntMatrix("[[2,3],[4,5],[6,7],[8,9],[1,10]]"))));
        System.out.println(Arrays.deepToString(merge.merge(TransformUtil.toIntMatrix("[[1,3],[2,6],[8,10],[15,18]]"))));
        System.out.println(Arrays.deepToString(merge.merge(TransformUtil.toIntMatrix("[[1,4],[4,5]]"))));
        System.out.println(Arrays.deepToString(merge.merge(TransformUtil.toIntMatrix("[[1,4]]"))));
        System.out.println(Arrays.deepToString(merge.merge(new int[0][0])));
    }
}
