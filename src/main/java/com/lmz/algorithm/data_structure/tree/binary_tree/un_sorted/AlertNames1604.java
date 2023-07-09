package com.lmz.algorithm.data_structure.tree.binary_tree.un_sorted;

import java.util.*;

/**
 * @author: limingzhong
 * @create: 2023-02-07 12:33
 */
public class AlertNames1604 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        HashMap<String, List<Integer>> timeMap = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            timeMap.putIfAbsent(name, new ArrayList<Integer>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            timeMap.get(name).add(hour * 60 + minute);
        }

        List<String> res = new ArrayList<>();
        for(var entry : timeMap.entrySet()){
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            for(int i = 2 ; i < list.size(); i++){
                int time1 = list.get(i-2),time2 = list.get(i);
                int diff = time2 - time1;
                if(diff <= 60){
                    res.add(entry.getKey());
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

}
