package com.liuyao;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。

 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={1,2,3};
        Solution solution=new Solution();
        System.out.println(solution.permute(arr));
    }
    static class Solution {
        List<List<Integer>> res=new LinkedList<>();
        boolean[] used;  //用来保存nums中的元素是否已经遍历过
//        p中保存了一个有index个元素的排列
//        向这个排列的末尾添加第index+1个元素，获得一个有index+1个元素的排列
        void generatePermutation(int[] nums,int index,LinkedList<Integer> p){
            if (index==nums.length){  //当index为length长度后则添加
                //注意要新建一个对象，因为p在不停的修改，
                // 如果只是添加p的话，最后返回的全是空数组
                LinkedList<Integer> temp=new LinkedList<>();
                temp.addAll(p);
                res.add(temp);
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]){  //如果当前元素没有被访问，则添加
                    p.addLast(nums[i]);
                    used[i]=true; //设置访问为true
                    generatePermutation(nums,index+1,p);
                    p.removeLast(); //访问完成后弹出最后一个元素
                    used[i]=false;  //恢复标记值
                }
            }
            return;
        }

        public List<List<Integer>> permute(int[] nums) {
            if (nums.length==0){
                return res;
            }
            used=new boolean[nums.length];
            LinkedList<Integer> p=new LinkedList<>();
            generatePermutation(nums,0,p);
            return res;
        }
    }
}
