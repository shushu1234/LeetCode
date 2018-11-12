package com.liuyao;

import java.util.LinkedList;
import java.util.List;

/**
 *
 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: nums = [1,2,3]
 输出:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={1,2,3};
        System.out.println(new Solution().subsets(arr));
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res=new LinkedList<List<Integer>>();
            LinkedList<Integer> list=new LinkedList<Integer>();
            if (nums==null || nums.length==0){
                return res;
            }
            subsets(nums,res,list,0);
            return res;
        }

        private void subsets(int[] nums, List<List<Integer>> res, LinkedList<Integer> list, int start) {
            res.add(new LinkedList<Integer>(list));
            for (int j = start; j < nums.length; j++) {
                list.addLast(nums[j]);
                subsets(nums,res,list,j+1);
                list.removeLast();
            }
        }
    }
}
