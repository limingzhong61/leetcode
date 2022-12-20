package lmz.leetcode.contest.old.c317;

import java.util.*;

/**
 * @author: codeofli
 * @create: 2022-10-30 10:34
 */
public class MostPopularCreator {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        //1 <= n <= 105
        int n = creators.length;
        List<List<String>> res = new ArrayList<>();
        Map<String, Long> viewMap = new HashMap<>();
        //0 <= views[i] <= 105
        long max = 0;
        for (int i = 0; i < n; i++) {
            viewMap.put(creators[i], viewMap.getOrDefault(creators[i], 0L) + views[i]);
            if (viewMap.get(creators[i]) > max) {
                max = viewMap.get(creators[i]);
            }
        }
        HashMap<String, Integer> resIdMap = new HashMap<>();
        for (var entry : viewMap.entrySet()) {
            if (entry.getValue() == max) {
                List<String> cList = new ArrayList<>(2);
                cList.add(entry.getKey());
                res.add(cList);
                resIdMap.put(entry.getKey(), res.size() - 1);
            }
        }
        int size = res.size();
        var maxView = new int[size];
        var maxIds = new String[size];
        for (int i = 0; i < n; i++) {
            Integer idx = resIdMap.get(creators[i]);
            if (idx != null) {
                if (views[i] > maxView[idx]) {
                    maxView[idx] = views[i];
                    maxIds[idx] = ids[i];
                } else if (views[i] == maxView[idx]) {
                    if (maxIds[idx] == null || maxIds[idx].compareTo(ids[i]) > 0) {
                        maxIds[idx] = ids[i];
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            res.get(i).add(maxIds[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        MostPopularCreator mostPopularCreator = new MostPopularCreator();
        System.out.println(mostPopularCreator.mostPopularCreator(new String[]{"a","a"},
                new String[]{"a","a"}, new int[]{1, 1}));
    }
}









