package lmz.my.util.format_change;

import java.util.ArrayList;

public class GetArray {
        public  static  int[] ArrayListToIntArray(ArrayList<Integer> list){
            int[] nums = new int[list.size()];

            for(int i = 0; i < list.size(); i++){
                nums[i] = list.get(i);
            }
            return nums;
        }
}
