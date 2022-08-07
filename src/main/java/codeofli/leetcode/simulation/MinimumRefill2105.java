package codeofli.leetcode.simulation;

public class MinimumRefill2105 {
    /**
     * max(plants[i]) <= capacityA, capacityB <= 10^9
     */
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        //    1 <= n <= 105
        int n = plants.length;
        int pa = 0, pb = n - 1;
        int addTime = 0;
        int waterA = capacityA,waterB =  capacityB;
        for (; pa < pb; pa++, pb--) {
            if(waterA < plants[pa]){
                waterA = capacityA;
                addTime++;
            }
            waterA -= plants[pa];
            if(waterB < plants[pb]){
                waterB = capacityB;
                addTime++;
            }
            waterB -= plants[pb];
        }
        //pa == pb
        if(waterA >= waterB){
            if(waterA < plants[pa]){
                addTime++;
            }
        }else{
            if(waterB < plants[pb]){
                addTime++;
            }
        }
        return addTime;
    }
}
