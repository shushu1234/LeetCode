package com.liuyao;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

 说明: 叶子节点是指没有子节点的节点。

 示例:
 给定如下二叉树，以及目标和 sum = 22，

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    public static class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    static class Solution {
        public static boolean hasPathSum(TreeNode root, int sum) {
            if (root==null)
                return false;
//            注意是叶子节点
            if (root.left==null && root.right==null)
                return root.val==sum;
            if (hasPathSum(root.left,sum-root.val)){
                return true;
            }
            if (hasPathSum(root.right,sum-root.val)){
                return true;
            }
            return false;
            // 或者直接采用下面这种写法
            //return (hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val));
        }
    }
}
