package com.lmz.leetcode.practice.other.easy.old;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator341 {
    public class NestedIterator implements Iterator<Integer> {
        List<Integer> nums = new ArrayList<>();
        int idx = 0;
        public NestedIterator(List<NestedInteger> nestedList) {
            parse(nestedList);
        }

        private void parse(List<NestedInteger> nestedList) {
            for(NestedInteger item : nestedList){
                if(item.isInteger()){
                    nums.add(item.getInteger());
                }else {
                    parse(item.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return nums.get(idx++);
        }

        @Override
        public boolean hasNext() {
            return idx < nums.size();
        }
    }
}
