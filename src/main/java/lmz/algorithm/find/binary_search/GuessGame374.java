package lmz.algorithm.find.binary_search;

public class GuessGame374 {
    /**
     * 二分查找
     */
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    int guess(int num){
        return 1;
    }
}
