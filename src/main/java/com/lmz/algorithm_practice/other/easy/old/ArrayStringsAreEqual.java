package com.lmz.algorithm_practice.other.easy.old;

/**
 * @author: codeofli
 * @create: 2022-11-01 9:30
 */
public class ArrayStringsAreEqual {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return join(word1).equals(join(word2));
    }

    private String join(String[] word1) {
        StringBuilder sb = new StringBuilder();
        for(var s : word1){
            sb.append(s);
        }
        return sb.toString();
    }
}
