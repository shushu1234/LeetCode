package com.liuyao;


import java.util.Stack;

/**
 *
 计算给定二叉树的所有左叶子之和。

 示例：

 3
 / \
 9  20
 /  \
 15   7

 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
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
        public int sumOfLeftLeaves(TreeNode root) {
            int sum=0;
            Stack<TreeNode> stack=new Stack<TreeNode>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node=stack.pop();
                if (node !=null){
                    if (node.left!=null && node.left.left==null && node.left.right==null){
                        sum+=node.left.val;
                    }
                    stack.push(node.left);
                    stack.push(node.right);
                }
            }
            return sum;
        }

    }
}
