package com.liuyao;

import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

 示例:

 输入: n = 4, k = 2
 输出:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    static class Solution {
        public List<List<Integer>> res=new LinkedList<>();

//        求解C(n,k)，当前已经找到的组合存储在c中，需要从start开始搜索新的元素
        public void generateCombinations(int n,int k,int start,LinkedList<Integer> c){
            if (c.size()==k){
                List<Integer> list=new LinkedList<>();
                list.addAll(c);
                res.add(list);
                return;
            }
//            还有k-c.size()个空位，所以，[i...n]中至少要有k-c.size()个元素
//            i最多为 n - (k-c.size())+1  即 n-k+c.size()+1  剪枝
//            for (int i = start; i <= n-(k-c.size())+1 ; i++) {
            for (int i = start; i <= n-k+c.size()+1 ; i++) {
                c.add(i);
                generateCombinations(n,k,i+1,c);
                c.removeLast();
            }
            return;
        }

        public List<List<Integer>> combine(int n, int k) {
            if (n<=0|| k <=0 || k >n){
                return res;
            }
            LinkedList<Integer> c=new LinkedList<>();
            generateCombinations(n,k,1,c);
            return res;
        }
    }
}
