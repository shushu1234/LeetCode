package com.liuyao;

import java.util.List;
/**
 *
 给定一个二叉树，返回所有从根节点到叶子节点的路径。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 输入:

 1
 /   \
 2     3
 \
 5

 输出: ["1->2->5", "1->3"]

 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res=new LinkedList<>();
            if (root==null){
                return res;
            }
            if (root.left==null && root.right==null){
                res.add(String.valueOf(root.val));
                return res;
            }
            List<String> lefts=binaryTreePaths(root.left);
            for (int i = 0; i < lefts.size(); i++) {
                res.add(root.val+"->"+lefts.get(i));
            }
            List<String> rights=binaryTreePaths(root.right);
            for (int i = 0; i < rights.size(); i++) {
                res.add(root.val+"->"+rights.get(i));
            }
            return res;
        }
    }
}
