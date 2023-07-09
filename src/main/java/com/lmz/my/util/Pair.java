package com.lmz.my.util;

/**
 * 通用泛型Pair类型
 */
public class Pair<V1, V2> {
    public V1 val1;
    public V2 val2;

    public Pair() {
    }

    public Pair(V1 val1, V2 val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "val1=" + val1 +
                ", val2=" + val2 +
                '}';
    }
}
