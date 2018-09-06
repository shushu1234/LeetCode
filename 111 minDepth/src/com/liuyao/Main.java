package com.liuyao;

/**
 * 给定一个二叉树，找出其最小深度。

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回它的最小深度  2.
 */
public class Main {

    public static void main(String[] args) {
	// write your code here

        TreeNode treeNode0 = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(8);
//        TreeNode treeNode2 = new TreeNode(7);
//        TreeNode treeNode3 = new TreeNode(9);
//        TreeNode treeNode4 = new TreeNode(2);
//        TreeNode treeNode5 = new TreeNode(4);
//        TreeNode treeNode6 = new TreeNode(5);

        treeNode0.left = treeNode1;
//        treeNode0.right = treeNode2;
//        treeNode1.left = treeNode3;
//        treeNode1.right = treeNode4;
//        treeNode4.left = treeNode5;
//        treeNode4.right = treeNode6;
        System.out.println(Solution.minDepth(treeNode0));
    }
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    static  class Solution {
        /**
         * 要对下面这种情况单独考虑：
         *     A
         *    /
         *   B
         *   或者
         *     A
         *      \
         *       B
         *  这个时候的最大深度要为左孩子的或者右孩子的
         * @param root
         * @return
         */
        public static int minDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
        }
    }
}
