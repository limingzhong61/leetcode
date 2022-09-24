package codeofli.leetcode.other.easy;

public class ParkingSystem1603 {
    class ParkingSystem {
        int[] parkingNum = new int[4];
        public ParkingSystem(int big, int medium, int small) {
            parkingNum[1] = big;
            parkingNum[2] = medium;
            parkingNum[3] = small;
        }

        public boolean addCar(int carType) {
            if(parkingNum[carType] == 0){
                return  false;
            }
            parkingNum[carType]--;
            return true;
        }
    }
}
