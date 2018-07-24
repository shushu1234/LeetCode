package com.liuyao;

import java.util.Arrays;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

 例如，给定 n = 2，返回1（2 = 1 + 1）；给定 n = 10，返回36（10 = 3 + 3 + 4）。

 注意：你可以假设 n 不小于2且不大于58。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

   class Solution {

//        自顶向下，加记忆化搜索
        private int[] memo;
        public  int integerBreak(int n) {
            memo=new int[n+1];
            Arrays.fill(memo,-1);
            return breakInteger(n);
        }

       private  int breakInteger(int n) {
            if (n==1){
                return 1;
            }
            if (memo[n]!=-1){
                return memo[n];
            }
            int res=-1;
           for (int i = 1; i <= n-1; i++) {
              res=Math.max(res,Math.max(i*(n-i),i*breakInteger(n-i)));
           }
           memo[n]=res;
           return res;
       }
   }

   class Solution1{
       public  int integerBreak(int n) {
           int[] memo=new int[n+1];
           Arrays.fill(memo,-1);
           memo[1]=1;
           for (int i = 1; i <=n ; i++) {
               for (int j = 1; j <i ; j++) {
                   memo[i]=Math.max(memo[i],Math.max(j*(i-j),j*memo[i-j]));
               }
           }
           return memo[n];
       }
   }
}
