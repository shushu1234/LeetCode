package com.liuyao;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:

 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 进阶:

 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums={2,3};
        System.out.println(Solution.maxSubArray(nums));
    }

    static class Solution {
        public static int maxSubArray(int[] nums) {
            if (nums.length==0 || nums==null){
                return 0;
            }
            if (nums.length==1){
                return nums[0];
            }
            int maxNum=nums[0];
            int total=nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (total<0){
                    total=nums[i];
                }else {
                    total+=nums[i];
                }
                maxNum=(total>maxNum?total:maxNum);
            }
            return maxNum;
        }
    }
}
