package com.liuyao;

import java.util.LinkedList;
import java.util.List;

/**
 *
 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

 说明：

 所有数字都是正整数。
 解集不能包含重复的组合。
 示例 1:

 输入: k = 3, n = 7
 输出: [[1,2,4]]
 示例 2:

 输入: k = 3, n = 9
 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(new Solution().combinationSum3(3, 7));
    }
    static class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res=new LinkedList<List<Integer>>();
            LinkedList<Integer> list=new LinkedList<Integer>();
            dfs(list,res,n,k,1);
            return res;
        }

        private void dfs( LinkedList<Integer> list, List<List<Integer>> res, int n, int k,int start) {
            if (n==0 && k==0){
                res.add(new LinkedList<Integer>(list));
                return;
            }
            for (int i = start; i <= 9; i++) {
                if (i<=n){
                    list.addLast(i);
                    k--;
                    dfs(list,res,n-i,k,i+1);
                    k++;
                    list.removeLast();
                }
            }
        }

    }
}
