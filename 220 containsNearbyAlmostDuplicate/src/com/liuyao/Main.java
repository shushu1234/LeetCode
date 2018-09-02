package com.liuyao;

import java.util.TreeSet;

/**
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] arr = {-2147483648, -2147483647};
        System.out.println(Solution.containsNearbyAlmostDuplicate(arr, 3, 3));
    }

    static class Solution {
        public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

            if (t < 0) {
                return false;
            }

            TreeSet<Long> record = new TreeSet<Long>();
            for (int i = 0; i < nums.length; i++) {

                if (record.ceiling((long) nums[i] - (long) t) != null &&
                        record.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t) {
                    return true;
                }

                record.add((long) nums[i]);

                if (record.size() == k + 1) {
                    record.remove((long) nums[i - k]);
                }
            }

            return false;
        }
    }
}
