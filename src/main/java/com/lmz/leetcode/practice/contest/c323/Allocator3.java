package com.lmz.leetcode.practice.contest.c323;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Allocator3 {
    class Allocator {
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        // [left,right]
        ArrayList<int[]> ranges = new ArrayList<>();
        int[] allocator;
        int n;

        public Allocator(int n) {
            allocator = new int[n];
            ranges.add(new int[]{0, n - 1});
            this.n = n;
        }

        public int allocate(int size, int mID) {
            for (int i = 0; i < ranges.size(); i++) {
                int[] range = ranges.get(i);
                System.out.println(Arrays.toString(range));
                int len = range[1] - range[0] + 1;
                if (len >= size) {
                    ArrayList<int[]> arrayList = map.getOrDefault(mID, new ArrayList<int[]>());
                    int[] newRange = {range[0], range[0] + size - 1};
                    arrayList.add(newRange);
                    map.put(mID, arrayList);
                    range = new int[]{range[0] + size, range[1]};
                    ranges.set(i, range);
                    return newRange[0];
                }
            }
            return -1;
        }

        public int free(int mID) {
            ArrayList<int[]> list = map.get(mID);
            if (list == null || list.size() == 0) return 0; // 不存在
            int totalLen = 0;
            for (var freeRange : list) {
                System.out.printf("%d,%d\n", freeRange[1], freeRange[0]);
                if (freeRange == null) return 0;
                int len = freeRange[1] - freeRange[0] + 1;
                totalLen += len;
                boolean add = false;
                for (int i = 0; i < ranges.size(); i++) {
                    int[] range = ranges.get(i);
                    if (freeRange[1] + 1 == range[0]) { //合并
                        range[0] = freeRange[0];
                        ranges.set(i, range);
                        add = true;
                        break;
                    } else if (freeRange[1] + 1 < range[0]) {
                        ranges.add(i, freeRange);
                        add = true;
                        break;
                    } else if (freeRange[0] - 1 == range[1]) {
                        range[1] = freeRange[1];
                        ranges.set(i, range);
                        add = true;
                        break;
                    }
                }
                if (!add)
                    ranges.add(freeRange);
            }

            return totalLen;
        }
    }
}
