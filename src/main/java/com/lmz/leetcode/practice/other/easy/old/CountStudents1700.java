package com.lmz.leetcode.practice.other.easy.old;

import java.util.*;

public class CountStudents1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.add(student);
        }
        Deque<Integer> temp = new ArrayDeque<>();
        for (var sandwich : sandwiches) {
            int size = queue.size();
            boolean consume = false;
            for(int i = 0; i < size; i++){
                //students.length == sandwiches.length
                if(sandwich == queue.peek()){
                    queue.poll();
                    consume = true;
                    break;
                }else{
                    queue.add(queue.poll());
                }
            }
            if(!consume){
                break;
            }
        }
        return queue.size();
    }
}
