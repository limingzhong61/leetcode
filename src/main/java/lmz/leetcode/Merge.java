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
            int[] a = intervals[i];
            int[] b = list.get(list.size()-1);
            if(a[1] >= b[0] && b[1] >= a[0]){
                list.remove(list.size()-1);
                list.add(new int[]{Math.min(a[0],b[0]),Math.max(a[1],b[1])});
            }else{
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[0][0]);
    }

    //public static void main(String[] args) {
    //    Merge merge = new Merge();
    //    System.out.println(Arrays.deepToString(merge.merge(TransformUtil.toIntMatrix("[[2,3],[4,5],[6,7],[8,9],[1,10]]"))));
    //    System.out.println(Arrays.deepToString(merge.merge(TransformUtil.toIntMatrix("[[1,3],[2,6],[8,10],[15,18]]"))));
    //    System.out.println(Arrays.deepToString(merge.merge(TransformUtil.toIntMatrix("[[1,4],[4,5]]"))));
    //    System.out.println(Arrays.deepToString(merge.merge(TransformUtil.toIntMatrix("[[1,4]]"))));
    //    System.out.println(Arrays.deepToString(merge.merge(new int[0][0])));
    //}
}
