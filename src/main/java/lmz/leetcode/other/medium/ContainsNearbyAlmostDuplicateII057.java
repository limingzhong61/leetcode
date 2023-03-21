package lmz.leetcode.other.medium;

import lmz.my.leetcode.TransformUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicateII057 {
    /**
     * 桶排序：我们将 int\texttt{int}int
     * 范围内的每一个整数x表示为 x=(t+1)×a+b(0≤b≤t) 的形式，这样  x 即归属于编号为  a 的桶。
     * 因为一个桶内至多只会有一个元素，所以我们使用哈希表实现即可。
     * 符合条件的t只会出现在 x当前桶k，和前后两个桶中
     */
    long size;
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        size = t + 1L;
        for (int i = 0; i < n; i++) {
            long u = nums[i];
            long idx = getIdx(u);
            // 目标桶已存在（桶不为空），说明前面已有 [u - t, u + t] 范围的数字
            if (map.containsKey(idx)) return true;
            // 检查相邻的桶
            long l = idx - 1, r = idx + 1;
            if (map.containsKey(l) && u - map.get(l) <= t) return true;
            if (map.containsKey(r) && map.get(r) - u <= t) return true;
            // 建立目标桶
            map.put(idx, u);
            // 移除下标范围不在 [max(0, i - k), i) 内的桶
            /**
             * 在一个窗口内有两个相同大小的数？
             * 假设这两个数的下标是 i 和 j
             * 在 j 被加入 TreeSet 的时候，已经返回 true 了 ~
             */
            if (i >= k) map.remove(getIdx(nums[i - k]));
        }
        return false;
    }
    long getIdx(long u) {
        return u >= 0 ? u / size : ((u + 1) / size) - 1;
    }

    /**
     * lc 优化:有序动态查找
     * 将 abs(x-y)<=t 转化为  x-t =< y <= x+t
     */
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            /**
             * 在一个窗口内有两个相同大小的数？
             * 假设这两个数的下标是 i 和 j
             * 在 j 被加入 TreeSet 的时候，已经返回 true 了 ~
             */
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    /**
     * 红黑树
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int n = nums.length;
        if (k == 0) {
            return false;
        }
        for (int i = 0; i < k && i < n; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) - 1);
            removeKey(treeMap, nums[i]);
            if (i - k - 1 > 0) {
                treeMap.put(nums[i - k - 1], treeMap.getOrDefault(nums[i - k - 1], 0) - 1);
                removeKey(treeMap, nums[i - k - 1]);
            }

            if (i - 1 > 0)
                treeMap.put(nums[i - 1], treeMap.getOrDefault(nums[i - 1], 0) + 1);
            if (i + k < n)
                treeMap.put(nums[i + k], treeMap.getOrDefault(nums[i + k], 0) + 1);
            if (treeMap.lowerKey(nums[i]) != null) {
                int low = treeMap.lowerKey(nums[i]);
                // 减法可能溢出，因为 nums[i]最大可取int最大范围值
                if ((long) nums[i] - low <= t) {
                    return true;
                }
            }
            if (treeMap.ceilingKey(nums[i]) != null) {
                int ceil = treeMap.ceilingKey(nums[i]);
                if ((long) ceil - nums[i] <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void removeKey(TreeMap<Integer, Integer> treeMap, int x) {
        if (treeMap.get(x) == 0) {
            treeMap.remove(x);
        }
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicateII057 containsNearbyAlmostDuplicateII057 = new ContainsNearbyAlmostDuplicateII057();
        //System.out.println(containsNearbyAlmostDuplicateII057.containsNearbyAlmostDuplicate(TransformUtil.toIntArray("[1,2,3,1]"), 3, 0));
        //System.out.println(containsNearbyAlmostDuplicateII057.containsNearbyAlmostDuplicate(TransformUtil.toIntArray("[1,5,9,1,5,9]"), 2, 3));
        //System.out.println(containsNearbyAlmostDuplicateII057.containsNearbyAlmostDuplicate(TransformUtil.toIntArray("[2147483640,2147483641]"), 1, 100));
        System.out.println(containsNearbyAlmostDuplicateII057.containsNearbyAlmostDuplicate(TransformUtil.toIntArray("[0]"), 0, 0));
    }
}
