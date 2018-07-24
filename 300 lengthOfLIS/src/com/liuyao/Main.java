package com.liuyao;

import java.util.Arrays;

/**
 *
 给定一个无序的整数数组，找到其中最长上升子序列的长度。

 示例:

 输入: [10,9,2,5,3,7,101,18]
 输出: 4
 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 说明:

 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 你算法的时间复杂度应该为 O(n2) 。
 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class Solution {
        /**
         * 状态转移方程：LIS(i)=max(1+LIS(j) if nums[i]>nums[j]) j<i
         * @param nums
         * @return
         */
        public int lengthOfLIS(int[] nums) {
            if (nums.length==0){
                return  0;
            }
            int[] memo=new int[nums.length+1];
            Arrays.fill(memo,1);
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j]<nums[i]){
                        memo[i]=Math.max(memo[i],memo[j]+1);
                    }
                }
            }

            int res=1;
            for (int i = 0; i < memo.length; i++) {
                res=Math.max(res,memo[i]);
            }
            return res;
        }
    }
}
