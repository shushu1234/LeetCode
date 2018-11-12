package com.liuyao;

/**
 * 利用范围检查的方式
 */
public class Solution {

    public static void main(String[] args) {
	// write your code here
        TreeNode treeNode0 = new TreeNode(1);
//        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
//        TreeNode treeNode3 = new TreeNode(1);
//        TreeNode treeNode4 = new TreeNode(2);
//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode6 = new TreeNode(7);

//        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
//        treeNode1.left = treeNode3;
//        treeNode1.right = treeNode4;
//        treeNode2.left = treeNode5;
//        treeNode2.right = treeNode6;
        System.out.println(new Solution().isValidBST(treeNode0));
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root==null){
            return true;
        }
        if (root.val>=maxValue||root.val<=minValue){
            return false;
        }
        return isValidBST(root.left,minValue,root.val)&&isValidBST(root.right,root.val,maxValue);
    }


}
