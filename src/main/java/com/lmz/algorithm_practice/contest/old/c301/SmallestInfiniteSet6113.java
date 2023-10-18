package com.lmz.algorithm_practice.contest.old.c301;

public class SmallestInfiniteSet6113 {
    class SmallestInfiniteSet {
        int[] set = new int[1001];

        public SmallestInfiniteSet() {

        }

        public int popSmallest() {
            for (int i = 1; i <= 1001; i++) {
                if (set[i] != 1){
                    set[i] = 1;
                    return i;
                }
            }
            return -1;
        }

        public void addBack(int num) {
            set[num] = 0;
        }
    }
}
