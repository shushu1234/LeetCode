package com.liuyao;

/**
 *
 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 示例:

 输入: [1,2,3,0,2]
 输出: 3
 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices==null || prices.length==0){
                return 0;
            }
            int s0=0;
            int s1=-prices[0];
            int s2=Integer.MIN_VALUE;
            for (int i = 1; i < prices.length; i++) {
                int pre0=s0;
                int pre1=s1;
                int pre2=s2;
                s0=Math.max(pre0,pre2);
                s1=Math.max(pre0-prices[i],pre1);
                s2=pre1+prices[i];
            }
            return Math.max(s0,s2);
        }
    }
}
