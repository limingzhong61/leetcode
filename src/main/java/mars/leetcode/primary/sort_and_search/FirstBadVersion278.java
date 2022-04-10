package mars.leetcode.primary.sort_and_search;

public class FirstBadVersion278 {

    /**
     * my:二分查找
     * while <
     */
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        int mid = 0;
        while (low < high) {
            // 防止计算时溢出
            mid = low + (high - low) / 2;
            if(isBadVersion(mid)){ // true;
                high = mid;
            }else { // false;
                low = mid+1;
            }
        }
        return  low;
    }

    /**
     * while <=
     */
    public int firstBadVersion2(int n) {
        int low = 1;
        int high = n;
        int mid;
        while(low <= high){
            mid = low +(high - low) /2;
            if(isBadVersion(mid)){
                high = mid - 1; // 收缩右边界，锁定左边界
            }else{
                low = mid + 1;
            }
        }
        // if(low > n) return -1; // 在此可以判断是否越界或者 left位置的值是否等于目标值等
        return low;
    }

    public  boolean isBadVersion(int i){
        return true ;
    }
}
