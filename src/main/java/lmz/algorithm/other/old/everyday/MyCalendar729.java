package lmz.algorithm.other.old.everyday;

import lmz.my.leetcode.TransformUtil;

import java.util.*;

public class MyCalendar729 {
    /**
     * leetcode: 二分查找：使用TreeSet排序
     * 对于给定的区间[start,end)，我们每次查找起点大于等于 end 的第一个区间 $[l_1,r_1)，
     * 同时紧挨着 [l_1,r_1)$的前一个区间为  $[l_2,r_2)$，此时如果满足 $r_2   ≤start<end≤l_1$  ，则该区间可以预订。
     */
   static class MyCalendar {
        TreeSet<int[]> booked;

        public MyCalendar() {
            booked = new TreeSet<int[]>((a, b) -> a[0] - b[0]);
        }

        public boolean book(int start, int end) {
            if (booked.isEmpty()) {
                booked.add(new int[]{start, end});
                return true;
            }
            int[] tmp = {end, 0};
            // ceiling 返回 >= tmp的值如果存在，不存在为null
            int[] arr = booked.ceiling(tmp);
            int[] prev = arr == null ? booked.last() : booked.lower(arr);
            if (arr == booked.first() || booked.lower(tmp)[1] <= start) {
                booked.add(new int[]{start, end});
                return true;
            }
            return false;
        }
    }

    static class MyCalendar1 {

        ArrayList<int[]> list = new ArrayList<>();

        public MyCalendar1() { }

        /**
         * leetcode:直接遍历-判断是否存在交集
         * 由没有交集判断->推出交集判断
         * 对于两个区间$ [s_1, e_1)和 [s_2, e_2)$，如果二者没有交集，
         * 则此时应当满足 $s_1 >= e_2或者 s_2 >= e_1$，这就意味着如果满足 $s_1 < e_2并且 s_2 < e_1 $，则两者会产生交集。
         */
        public boolean book(int start, int end) {
            //判断是否交集
            for (var item : list) {
                //[]
                int left = item[0], right = item[1];
                if (start < right && left < end) {
                    return false;
                }
            }
            list.add(new int[]{start, end});
            return true;
        }

        /**
         * my：直接遍历并插入
         */
        public boolean book1(int start, int end) {
            //判断是否交集
            for (int i = 0; i < list.size(); i++) {
                int i0 = list.get(i)[0]; //[i0,i1)
                int i1 = list.get(i)[1];
                if (end <= i0) { // [start,end) [i0,..) case1
                    list.add(i, new int[]{start, end});
                    return true;
                } else if (i0 <= start && end <= i1) { //  case2 [i0,[start,end),i1)
                    return false;
                } else if (i1 <= start) {  // case3: [i0,i1) [start,end) continue judge;
                    continue;
                    //后面的 start < i1
                } else if (i0 <= start && i1 < end) { //case4 [i0, start,i1) end
                    return false;
                    //后面的 start < i0
                } else {
                    return false; //case5 start [i0, end,i1)
                    // case6 start [i0,i1) end;
                }
            }
            list.add(new int[]{start, end});
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        //testCase(myCalendar, "[[], [10, 20], [15, 25], [20, 30]]");
        testCase(myCalendar, "[[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]",
                "[true,true,false,false,true,false,true,true,true,false]");
        testCase(myCalendar, "[[],[37,50],[33,50],[4,17],[35,48],[8,25]]",
                "[true,false,true,false,false]");
        testCase(myCalendar, "[[],[97,100],[33,51],[89,100],[83,100],[75,92],[76,95],[19,30],[53,63],[8,23],[18,37]," +
                        "[87,100],[83,100],[54,67],[35,48],[58,75],[70,89],[13,32],[44,63],[51,62],[2,15]]",
                "[true,true,false,false,true,false,true,true,false,false,false," +
                        "false,false,false,false,false,false,false,false,true]");
    }

    private static void testCase(MyCalendar myCalendar, String s, String s2) {
        int[][] matrix2 = TransformUtil.toIntMatrix(s);
        boolean[] res = new boolean[matrix2.length - 1];
        boolean[] ans = TransformUtil.toBoolArray(s2);
        for (int i = 1; i < matrix2.length; i++) {
            res[i - 1] = myCalendar.book(matrix2[i][0], matrix2[i][1]);
            if (res[i - 1] != ans[i - 1]) {
                System.out.println("error in " + i);
                System.out.println("error in " + matrix2[i][0] + "," + matrix2[i][1]);
                System.out.println("real value " + ans[i - 1]);
            }
            System.out.println(res[i - 1]);
        }
        System.out.println(String.valueOf(Arrays.equals(res, ans)).toUpperCase(Locale.ROOT));
        System.out.println("-----------------------");
        //myCalendar.list.clear();
        myCalendar.booked.clear();
    }
}
