package com.liuyao;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

 例如，从根到叶子节点路径 1->2->3 代表数字 123。

 计算从根到叶子节点生成的所有数字之和。

 说明: 叶子节点是指没有子节点的节点。

 示例 1:

 输入: [1,2,3]
 1
 / \
 2   3
 输出: 25
 解释:
 从根到叶子节点路径 1->2 代表数字 12.
 从根到叶子节点路径 1->3 代表数字 13.
 因此，数字总和 = 12 + 13 = 25.
 示例 2:

 输入: [4,9,0,5,1]
 4
 / \
 9   0
 / \
 5   1
 输出: 1026
 解释:
 从根到叶子节点路径 4->9->5 代表数字 495.
 从根到叶子节点路径 4->9->1 代表数字 491.
 从根到叶子节点路径 4->0 代表数字 40.
 因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class Solution {


    public static void main(String[] args) {
        // write your code here
        TreeNode treeNode0 = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(9);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(5);

        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        System.out.println(new Solution().sumNumbers(treeNode0));
    }

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        int num = 0;
        sum=sumNumbers(root, sum, num);
        return sum;
    }

    private int sumNumbers(TreeNode root, int sum, int num) {
        if (root == null) {
            return sum;
        }
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            num /= 10;
            return sum;
        } else {
            sum=sumNumbers(root.left, sum, num);
            sum=sumNumbers(root.right, sum, num);
        }
        num /= 10;
        return sum;
    }


}

