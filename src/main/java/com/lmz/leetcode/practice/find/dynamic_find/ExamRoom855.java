package com.lmz.leetcode.practice.find.dynamic_find;

import java.util.TreeSet;

/**
 * @author: limingzhong
 * @create: 2022-12-30 11:14
 */
public class ExamRoom855 {
    /**
     * TreeMap：动态查找
     */
    class ExamRoom {
        TreeSet<Integer> treeSet;
        int n ;
        public ExamRoom(int n) {
            treeSet = new TreeSet<>();
            this.n = n;
        }

        public int seat() {
            if(treeSet.size() == 0){
                treeSet.add(0);
                return 0;
            }else {
                int maxDist = -1,arrangeSeat = 0;
                int lastLoc = -1;
                for(var val : treeSet){
                    int dist = (val - lastLoc) / 2;
                    if(dist > maxDist){
                        maxDist = dist;
                        arrangeSeat = lastLoc + dist;
                    }
                    lastLoc = val;
                }
                //开始和结尾特殊处理
                int startLoc = treeSet.first(),endLoc = n - 1;
                if(startLoc  > maxDist){
                    maxDist = startLoc;
                    arrangeSeat = 0;
                }
                if(endLoc - lastLoc  > maxDist){
                    arrangeSeat = endLoc;
                }
                treeSet.add(arrangeSeat);
                return  arrangeSeat;
            }
        }

        public void leave(int p) {
            treeSet.remove(p);
        }
    }
}
