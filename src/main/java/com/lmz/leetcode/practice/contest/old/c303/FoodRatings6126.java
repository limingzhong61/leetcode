package com.lmz.leetcode.practice.contest.old.c303;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.*;

public class FoodRatings6126 {
    static class FoodRating{
        String food;
        int rating;
        FoodRating(String food,int rating){
            this.food = food;
            this.rating = rating;
        }
    }

    /**
     * 用(评分，食物）排序
     */
    static class FoodRatings {
        /**
         * 有序+动态查找 平衡树-红黑树
         */
        // <烹饪方式,(评分，食物)>
        HashMap<String, TreeSet<FoodRating>> cuisineRatingMap;
        //<食物,(评分，食物)>
        HashMap<String, FoodRating> foodRatingMap;
        //<食物，烹饪方式>
        HashMap<String, String> cuiMap;
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            cuisineRatingMap = new HashMap<>();
            foodRatingMap = new HashMap<>();
            cuiMap = new HashMap<>();
            for(int i = 0; i < foods.length; i++){
                TreeSet<FoodRating> treeSet = cuisineRatingMap.getOrDefault(cuisines[i], new TreeSet<FoodRating>((a, b) -> {
                    if(a.rating == b.rating){
                        return a.food.compareTo(b.food);
                    }
                    return b.rating - a.rating;
                }));
                FoodRating foodRating = new FoodRating(foods[i], ratings[i]);
                treeSet.add(foodRating);
                foodRatingMap.put(foods[i], foodRating);
                cuiMap.put(foods[i], cuisines[i]);
                cuisineRatingMap.put(cuisines[i], treeSet);
            }
        }

        public void changeRating(String food, int newRating) {
            FoodRating foodRating = foodRatingMap.get(food);
            TreeSet<FoodRating> treeSet = cuisineRatingMap.get(cuiMap.get(food));
            treeSet.remove(foodRating);
            foodRatingMap.remove(foodRating);
            FoodRating foodRating1 = new FoodRating(food, newRating);
            foodRatingMap.put(food,foodRating1);
            treeSet.add(foodRating1);
        }

        public String highestRated(String cuisine) {
            return cuisineRatingMap.get(cuisine).first().food;
        }
    }
    /**
     * 1 <= n <= 2 * 104
     */
    static class FoodRatings2 {
        /**
         * 有序+动态查找 平衡树-红黑树
         */
        HashMap<String, TreeMap<Integer, ArrayList<String>>> cuisinesMap;
        HashMap<String, Integer> rateMap;
        HashMap<String, String> cuiMap;

        public FoodRatings2(String[] foods, String[] cuisines, int[] ratings) {
            // <cuiName,treeMap>
            cuisinesMap = new HashMap<>();
            //<food,rate>
            rateMap = new HashMap<>();
            //<food,cui>
            cuiMap = new HashMap<>();
            int n = foods.length;
            for (int i = 0; i < n; i++) {
                TreeMap<Integer, ArrayList<String>> treeMap = cuisinesMap.getOrDefault(cuisines[i], new TreeMap<Integer, ArrayList<String>>());
                ArrayList<String> list = treeMap.getOrDefault(ratings[i], new ArrayList<String>());
                list.add(foods[i]);
                treeMap.put(ratings[i], list);
                rateMap.put(foods[i], ratings[i]);
                cuiMap.put(foods[i], cuisines[i]);
                cuisinesMap.put(cuisines[i], treeMap);
            }
        }

        public void changeRating(String food, int newRating) {
            Integer rate = rateMap.get(food);
            //修改分数映射
            rateMap.put(food,newRating);
            String cui = cuiMap.get(food);
            TreeMap<Integer, ArrayList<String>> treeMap = cuisinesMap.get(cui);
            ArrayList<String> list = treeMap.get(rate);
            list.remove(food);
            if (list.size() == 0) {
                treeMap.remove(rate);
            } else {
                treeMap.put(rate, list);
            }
            ArrayList<String> list1 = treeMap.getOrDefault(rate, new ArrayList<String>());
            list1.add(food);
            treeMap.put(newRating, list1);
        }

        public String highestRated(String cuisine) {
            TreeMap<Integer, ArrayList<String>> treeMap = cuisinesMap.get(cuisine);
            if (treeMap == null) {
                return null;
            }
            ArrayList<String> list = treeMap.lastEntry().getValue();
            list.sort(String::compareTo);
            return list.get(0);
        }
    }

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(TransformUtil.toStringArray("[\"kimchi\",\"miso\",\"sushi\",\"moussaka\",\"ramen\",\"bulgogi\"]"),
                TransformUtil.toStringArray("[\"korean\",\"japanese\",\"japanese\",\"greek\",\"japanese\",\"korean\"]"
                ), TransformUtil.toIntArray("[9,12,8,15,14,7]"));
        String s = "[[\"korean\"],[\"japanese\"],[\"sushi\",16],[\"japanese\"],[\"ramen\",16],[\"japanese\"]]";
        String[] strings = TransformUtil.toStringArray(s);
        String opt = "[\"highestRated\",\"highestRated\",\"changeRating\",\"highestRated\",\"changeRating\",\"highestRated\"]";
        String[] opts = TransformUtil.toStringArray(opt);
        //int i = 0;
        for (int i = 0, j = 0; i < opts.length; i++) {
            if ("highestRated".equals(opts[i])) {
                System.out.println(foodRatings.highestRated(strings[j]));
                j++;
            } else {
                //String[] split = StringTransformUtil.toStringArray(strings[i]);
                foodRatings.changeRating(strings[j++], Integer.parseInt(strings[j++]));
                System.out.println("null");
            }
        }
    }

}
