package com.liuyao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: [1,2,2]
 输出:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={1,2,2,2};
        System.out.println(new Solution().subsetsWithDup(arr));
    }
    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res=new LinkedList<List<Integer>>();
            LinkedList<Integer> list=new LinkedList<Integer>();
            if (nums==null || nums.length==0){
                return res;
            }
            Arrays.sort(nums);
            subsetsWithDup(nums,res,list,0);
            return res;
        }

        private void subsetsWithDup(int[] nums, List<List<Integer>> res, LinkedList<Integer> list, int start) {
            res.add(new LinkedList<Integer>(list));
            for (int j = start; j < nums.length; j++) {
//                这里用i>start
                if (j>start && nums[j]==nums[j-1]){
                    continue;
                }
                list.addLast(nums[j]);
                subsetsWithDup(nums,res,list,j+1);
                list.removeLast();
            }
        }
    }
}
