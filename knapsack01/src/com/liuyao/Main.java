package com.liuyao;

import java.util.Arrays;

/**
 * 0-1背包问题
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] w={1,2,3};
        int[] v={6,10,12};
        Solution1 solution1=new Solution1();
        System.out.println(solution1.knapsack01(w, v, 5));
        Solution2 solution2=new Solution2();
        System.out.println(solution2.knapsack01(w, v, 5));
        Solution3 solution3=new Solution3();
        System.out.println(solution3.knapsack01(w, v, 5));
        Solution4 solution4=new Solution4();
        System.out.println(solution4.knapsack01(w, v, 5));
    }

    /**
     *自顶向下，记忆化搜索
     */
    static class Solution1{
         int[][] memo;
         /**
          * 0-1背包
          * @param w 物品重量的数组
          * @param v 物品价值的数组
          * @param C 背包最大的容量
          * @return 最后能装下的最大价值
          */
        public int knapsack01(int[] w,int[] v,int C){
            int n=w.length;
            memo=new int[n+1][C+1];
            for (int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i],-1);
            }
            return bestValue(w,v,n-1,C);
        }

         private int bestValue(int[] w, int[] v, int index, int c) {
            if (index <0 || c<=0){
                return 0;
            }
            if (memo[index][c]!=-1){
                return memo[index][c];
            }
            int res=bestValue(w,v,index-1,c);
            if (c>=w[index]){
                res=Math.max(res,v[index]+bestValue(w,v,index-1,c-w[index]));
            }
            memo[index][c]=res;
            return res;
         }
     }


    /**
     * 动态规划
     */
    static class Solution2{
         public int knapsack01(int[] w,int[] v,int C){
             int n=w.length;
             if (n==0 || C==0){
                 return 0;
             }
             int[][] memo= new int[n+1][C+1];
             for (int j = 0; j <= C; j++) {
                 memo[0][j]=(j>=w[0]?v[0]:0);
             }
             for (int i = 1; i < n; i++) {
                 for (int j = 0; j <=C; j++) {
                     memo[i][j]=memo[i-1][j];
                     if (j>=w[i]){
                         memo[i][j]=Math.max(memo[i][j],v[i]+memo[i-1][j-w[i]]);
                     }
                 }
             }
             return memo[n-1][C];
         }
     }

    /**
     * 动态规划优化版,只用两行
     */
    static class Solution3{
        public int knapsack01(int[] w,int[] v,int C){
            int n=w.length;
            if (n==0|| C==0){
                return 0;
            }
            int[][] memo= new int[2][C+1];
            for (int j = 0; j <= C; j++) {
                memo[0][j]=(j>=w[0]?v[0]:0);
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <=C; j++) {
                    memo[i%2][j]=memo[(i-1)%2][j];
                    if (j>=w[i]){
                        memo[i%2][j]=Math.max(memo[i%2][j],v[i]+memo[(i-1)%2][j-w[i]]);
                    }
                }
            }
            return memo[(n-1)%2][C];
        }
    }

    /**
     * 动态规划优化版,只用一行
     */
    static class Solution4{
        public int knapsack01(int[] w,int[] v,int C){
            int n=w.length;
            if (n==0|| C==0){
                return 0;
            }
            int[] memo= new int[C+1];
            for (int j = 0; j <= C; j++) {
                memo[j]=(j>=w[0]?v[0]:0);
            }
            for (int i = 1; i < n; i++) {
                for (int j = C; j >=w[i]; j--) {
                    memo[j]=Math.max(memo[j],v[i]+memo[j-w[i]]);
                }
            }
            return memo[C];
        }
    }
}
