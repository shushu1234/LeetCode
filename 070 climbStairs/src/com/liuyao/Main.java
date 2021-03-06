package com.liuyao;

import java.util.Arrays;

/**
 * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 步 + 1 步
 * 2.  2 步
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 步 + 1 步 + 1 步
 * 2.  1 步 + 2 步
 * 3.  2 步 + 1 步
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(Solution.climbStairs(44));
    }

    static class Solution {
//===============方法一:动态规划
        public static int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            int[] ways = new int[n + 1];
            ways[1] = 1;
            ways[2] = 2;
            for (int i = 3; i <= n; i++) {
                ways[i] = ways[i - 1] + ways[i - 2];
            }
            return ways[n];
        }

//================方法二：记忆化搜索

        int[] memo;

        int calcWays(int n){
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            if (memo[n]==-1){
                memo[n]=calcWays(n-1)+calcWays(n-2);
            }
            return memo[n];
        }

        public  int climbStairs2(int n) {
            memo =new int[n+1];
            Arrays.fill(memo,-1);
            return calcWays(n);
        }
    }
}
