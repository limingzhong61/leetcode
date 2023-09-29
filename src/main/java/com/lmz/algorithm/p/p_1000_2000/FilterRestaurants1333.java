package com.lmz.algorithm.p.p_1000_2000;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author: limingzhong
 * @create: 2023-09-27 13:38
 */
public class FilterRestaurants1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Stream.of(restaurants).filter(each ->{
            if(veganFriendly == 1 && each[2] == 0){
                return false;
            }
            return each[3] <= maxPrice && each[4] <= maxDistance;
        }).sorted((a,b) ->{
            if(a[1] == b[1]){
                return b[0] - a[0];
            }
            return b[1] - a[1];
        }).map(each -> each[0]).toList();
    }
}
