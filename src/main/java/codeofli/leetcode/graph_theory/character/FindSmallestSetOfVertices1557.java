package codeofli.leetcode.graph_theory.character;

import codeofli.my.leetcode.StringTransformUtil;

import java.util.*;

public class FindSmallestSetOfVertices1557 {
    /**
     * 从入度为0得开始（因为是有向无环图，则肯定有入度为0的点）
     * 因为一定有解，故不用遍历
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        //2 <= n <= 10^5
        int[] inDegree = new int[n];
        for (var edge : edges) {
            inDegree[edge.get(1)]++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //入度=0
            if (inDegree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindSmallestSetOfVertices1557 findSmallestSetOfVertices1557 = new FindSmallestSetOfVertices1557();

        System.out.println(findSmallestSetOfVertices1557.findSmallestSetOfVertices(6,
                StringTransformUtil.toDoubleArrayList("[[0,1],[0,2],[2,5],[3,4],[4,2]]")));
        System.out.println(findSmallestSetOfVertices1557.findSmallestSetOfVertices(6,
                StringTransformUtil.toDoubleArrayList("[[0,1],[0,2],[2,5],[3,4],[4,2]]")).equals(StringTransformUtil.toArrayList("[0,3]")));

        System.out.println(findSmallestSetOfVertices1557.findSmallestSetOfVertices(5,
                StringTransformUtil.toDoubleArrayList("[[0,1],[2,1],[3,1],[1,4],[2,4]]")));
        System.out.println(findSmallestSetOfVertices1557.findSmallestSetOfVertices(5,
                StringTransformUtil.toDoubleArrayList("[[0,1],[2,1],[3,1],[1,4],[2,4]]")).equals(StringTransformUtil.toArrayList("[0,2,3]")));
    }
}
