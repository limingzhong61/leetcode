package lmz.leetcode.unc_good;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager1797 {
    /**
     * 所有函数的调用次数总共不超过 2000 次。
     * 用一个map记录验证码：
     * 每次都会有currentTime的时间，则每次操作数遍历
     */
    class AuthenticationManager {
        //<tokenId，endTime>
        Map<String, Integer> timeMap = new HashMap<>();
        int timeToLive = 0;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            timeMap.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            //过期事件 优先于 其他操作。
            if (timeMap.containsKey(tokenId)) {
                if (timeMap.get(tokenId) > currentTime) {
                    timeMap.put(tokenId, currentTime + timeToLive);
                }
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int cnt = 0;
            for (var entry : timeMap.entrySet()) {
                //过期事件 优先于 其他操作。
                if (entry.getValue() > currentTime) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
