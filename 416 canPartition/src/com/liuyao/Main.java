package com.liuyao;

import java.util.Arrays;

/**
 *
 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

 注意:

 每个数组中的元素不会超过 100
 数组的大小不会超过 200
 示例 1:

 输入: [1, 5, 11, 5]

 输出: true

 解释: 数组可以分割成 [1, 5, 5] 和 [11].


 示例 2:

 输入: [1, 2, 3, 5]

 输出: false

 解释: 数组不能分割成两个元素和相等的子集.
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    class Solution {
        //        memo[i][c] 表示使用索引为[0...i]的这些元素，是否可以完全填充一个容量为c的背包
//        -1：表示未计算，0表示不可以填充，1表示可以填充
        int[][] memo;

        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum % 2 != 0) {
                return false;
            }
            memo = new int[nums.length][sum / 2 + 1];
            for (int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i], -1);
            }
//            最多只能分割nums.length-1个，要分成两个数组
            return tryPartition(nums, nums.length - 1, sum / 2);
        }

        private boolean tryPartition(int[] nums, int index, int sum) {
            if (sum == 0) {
                return true;
            }
            if (sum < 0 || index < 0) {
                return false;
            }
            if (memo[index][sum] != -1) {
                return memo[index][sum] == 1;
            }
            memo[index][sum] = (tryPartition(nums, index - 1, sum) || tryPartition(nums, index - 1, sum - nums[index])) ? 1 : 0;
            return memo[index][sum] == 1;
        }

        public boolean canPartition2(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum % 2 != 0) {
                return false;
            }
            int n = nums.length;
            int C = sum / 2;
            boolean[] memo = new boolean[C+1];
            for (int i = 0; i <= C; i++) {
                memo[i] = (nums[0] == i); //如果nums[0] 为i的话，直接将nums[0]放进去填满背包
            }
            for (int i = 1; i < n; i++) {
                for (int j = C; j >= nums[i]; j--) {
                    memo[j] = memo[j] || memo[j - nums[i]];
                }
            }
            return memo[C];

        }

    }
}