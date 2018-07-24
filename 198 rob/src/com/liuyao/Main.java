package com.liuyao;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

 示例 1:

 输入: [1,2,3,1]
 输出: 4
 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 偷窃到的最高金额 = 1 + 3 = 4 。
 示例 2:

 输入: [2,7,9,3,1]
 输出: 12
 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 偷窃到的最高金额 = = 2 + 9 + 1 = 12 。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={1,2,7,9,3,1};
        System.out.println(new Main().rob(arr));
    }
    public int rob(int[] nums) {
        int prevNo=0; //前一步不走
        int prevYes=0; //前一步走
        int temp;
        for (int n : nums) {
            temp=prevNo; //取得不走的临时值
            prevNo=Math.max(prevNo,prevYes); //在前面的走和不走选一个最大值
            prevYes=n+temp; //走当前这个
        }
        return Math.max(prevNo,prevYes);
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n > 2) {
            nums[2] += nums[0];
        }
        for (int i = 3; i < n; i++) {
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
        }
        return Math.max(nums[n-1], nums[n-2]);
    }

    class Solution {
//        自顶向下，记忆化搜索
        private int[] memo;
        public int rob(int[] nums) {
            memo=new int[nums.length+1];
            Arrays.fill(memo,-1);
            return tryRob(nums,0);
        }

        private int tryRob(int[] nums, int index) {
            if (index >= nums.length){
                return 0;
            }
            if (memo[index]!=-1){
                return memo[index];
            }
            int res=0;
            for (int i = index; i < nums.length; i++) {
                res=Math.max(res,nums[i]+tryRob(nums,i+2));
            }
            memo[index]=res;
            return res;
        }
    }
}
