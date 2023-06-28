package lmz.algorithm.find.binary_search.not_unusual;

/**
 * @author: limingzhong
 * @create: 2023-03-23 12:58
 */
public class PeakIndexInMountainArrayII069 {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0,high = arr.length - 1;
        int res = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] <= arr[mid + 1]){
                low = mid + 1;
            }else {
                high = mid - 1;
                res = high;
            }
        }
        return res;
    }
}
