package com.liuyao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的数字可以无限制重复被选取。

 说明：

 所有数字（包括 target）都是正整数。
 解集不能包含重复的组合。
 示例 1:

 输入: candidates = [2,3,6,7], target = 7,
 所求解集为:
 [
 [7],
 [2,2,3]
 ]
 示例 2:

 输入: candidates = [2,3,5], target = 8,
 所求解集为:
 [
 [2,2,2,2],
 [2,3,3],
 [3,5]
 ]
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums={2,3,6,7};
        System.out.println(new Solution().combinationSum(nums, 7));
    }
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res=new LinkedList<List<Integer>>();
            if (candidates==null || candidates.length==0){
                return res;
            }
            boolean[] used=new boolean[candidates.length];
            LinkedList<Integer> list=new LinkedList<Integer>();
            Arrays.sort(candidates);
//            对于这种存在顺序的，可以把其实位置放在一起递归
            dfs(candidates,used,list,res,target,0);
            return res;
        }

        private void dfs(int[] candidates, boolean[] used, LinkedList<Integer> list, List<List<Integer>> res, int target,int start) {
            if (target==0){
                res.add(new LinkedList<Integer>(list));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i]<=target){
                    used[i]=true;
                    list.addLast(candidates[i]);
                    dfs(candidates,used,list,res,target-candidates[i],i);
                    used[i]=false;
                    list.removeLast();
                }
            }
        }

    }
}
