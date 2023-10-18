package exam;//package main
//注意不要添加包名称，否则会报错。

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String[] split = s.replaceAll("\\[|\\]", "").split(",");
        int n = split.length - 1;
        int k = Integer.parseInt(split[n]);
        Deque<Integer> a= new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(split[i]));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        dfs(a,pq,k);

        System.out.println(ans);
    }
    static  int ans = 0;
    private static void dfs(Deque<Integer> a, PriorityQueue<Integer> pq, int k) {
        //System.out.println(k);
        if(k == 1){
            int sum = 0;
            while(!pq.isEmpty()){
                sum += pq.poll();
            }
            ans =  Math.max(ans,sum);

            return;
        }
        if(!pq.isEmpty() && pq.peek() < 0){
            int x = pq.poll();
            a.addLast(x);
            dfs(a,pq,k-1);
            pq.add(x);
            a.removeLast();

            a.addFirst(x);
            dfs(a,pq,k-1);
            pq.add(x);
            a.removeFirst();
        }

        int x = a.removeLast();
        pq.add(x);
        dfs(a,pq,k-1);
        pq.remove(x);
        a.addLast(x);

        x = a.removeFirst();
        pq.add(x);
        dfs(a,pq,k-1);
        pq.remove(x);
        a.addFirst(x);
    }
}
/**
 [-10,8,2,1,2,6],4
 */