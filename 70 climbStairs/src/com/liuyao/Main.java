package com.liuyao;

/**
 *
 假设你正在爬楼梯。需要 n 步你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 注意：给定 n 是一个正整数。

 示例 1：

 输入： 2
 输出： 2
 解释： 有两种方法可以爬到楼顶。
 1.  1 步 + 1 步
 2.  2 步
 示例 2：

 输入： 3
 输出： 3
 解释： 有三种方法可以爬到楼顶。
 1.  1 步 + 1 步 + 1 步
 2.  1 步 + 2 步
 3.  2 步 + 1 步

 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Solution.climbStairs(44));
    }

   static class Solution {
        public static int climbStairs(int n) {
            if (n<=2){
                return n;
            }
            int[] ways=new int[n+1];
            ways[1]=1;
            ways[2]=2;
            for (int i = 3; i <=n ; i++) {
                ways[i]=ways[i-1]+ways[i-2];
            }
            return ways[n];
        }
    }
}
