package com.lmz.algorithm.p.p_1000;

/**
 * @author: limingzhong
 * @create: 2023-07-24 10:07
 */
public class NumJewelsInStones771 {
    public int numJewelsInStones(String jewels, String stones) {
        return (int) stones.chars().boxed().map(jewels::indexOf).filter(item -> item > -1).count();
    }

    public static void main(String[] args) {
        NumJewelsInStones771 numJewelsInStones771 = new NumJewelsInStones771();
        System.out.println(numJewelsInStones771.numJewelsInStones("aA", "aAAbbbb"));
    }
}
