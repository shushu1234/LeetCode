package com.liuyao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 给定一个可包含重复数字的序列，返回所有不重复的全排列。

 示例:

 输入: [1,1,2]
 输出:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums={1,2,1,1};
        System.out.println(new Solution().permuteUnique(nums));
    }
    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res=new ArrayList<List<Integer>>();
            if (nums==null || nums.length==0) {
                return res;
            }
            boolean[] used=new boolean[nums.length];
            List<Integer> list=new ArrayList<Integer>();
            Arrays.sort(nums);
            dfs(nums,used,list,res);
            return res;

        }

        private void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
            if (list.size()==nums.length){
                res.add(new ArrayList<Integer>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
//                如果当前的元素已经添加过了
                if (used[i]){
                    continue;
                }
//                和前面的元素相同的，且当前不是在前面那个元素的递归栈上，故需要跳出
//                考虑这种情况：
//                       1     1    2
//                      true false false
//                上面这种情况是可以添加的
//                       1      1    2
//                        false  false false
//                  上面这种情况在第二个一的时候，是不能添加的，因为前面已经添加过一次了
                if (i>0 && nums[i]==nums[i-1] && !used[i-1]) {
                    continue;
                }
                used[i]=true;
                list.add(nums[i]);
                dfs(nums,used,list,res);
//                还原状态
                used[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
}
