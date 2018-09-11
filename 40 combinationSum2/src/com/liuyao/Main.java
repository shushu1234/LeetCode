package com.liuyao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的每个数字在每个组合中只能使用一次。

 说明：

 所有数字（包括目标数）都是正整数。
 解集不能包含重复的组合。
 示例 1:

 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 所求解集为:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 示例 2:

 输入: candidates = [2,5,2,1,2], target = 5,
 所求解集为:
 [
 [1,2,2],
 [5]
 ]
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums={10,1,2,7,6,1,5};
        System.out.println(new Solution().combinationSum(nums, 8));

    }
    static class Solution{
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res=new LinkedList<List<Integer>>();
            if (candidates==null || candidates.length==0){
                return res;
            }
            LinkedList<Integer> list=new LinkedList<Integer>();
            Arrays.sort(candidates);
//            对于这种存在顺序的，可以把其实位置放在一起递归
            dfs(candidates,list,res,target,0);
            return res;
        }

        private void dfs(int[] candidates, LinkedList<Integer> list, List<List<Integer>> res, int target,int start) {
            if (target==0){
                res.add(new LinkedList<Integer>(list));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (i>start && candidates[i]==candidates[i-1]){
                    continue;
                }
                if (candidates[i]<=target){
                    list.addLast(candidates[i]);
                    dfs(candidates,list,res,target-candidates[i],i+1);
                    list.removeLast();
                }
            }
        }

    }

}
