package com.liuyao;

import java.util.LinkedList;
import java.util.List;

/**
 *
 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

 说明: 叶子节点是指没有子节点的节点。

 示例:
 给定如下二叉树，以及目标和 sum = 22，

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 返回:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(-2);
//        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(-3);
//        TreeNode treeNode3 = new TreeNode(11);
//        TreeNode treeNode4 = new TreeNode(13);
//        TreeNode treeNode5 = new TreeNode(4);
//        TreeNode treeNode6 = new TreeNode(7);
//        TreeNode treeNode7 = new TreeNode(2);
//        TreeNode treeNode8 = new TreeNode(5);
//        TreeNode treeNode9 = new TreeNode(1);


//        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;

//        treeNode1.left = treeNode3;
//
//        treeNode2.right = treeNode4;
//        treeNode2.right = treeNode5;
//
//        treeNode3.left = treeNode6;
//        treeNode3.right = treeNode7;
//
//        treeNode5.left = treeNode8;
//        treeNode5.right = treeNode9;

        System.out.println(new Solution().pathSum1(treeNode0, -5));
    }

    private List<List<Integer>> lists = new LinkedList<List<Integer>>();

    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        if (root == null) {
            return lists;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(root.val);
        sum -= root.val;
        pathSumHelp1(root, sum, list);
        return lists;
    }

    public void pathSumHelp1(TreeNode root, int sum, LinkedList<Integer> list) {
        if (root.left == null && root.right == null && sum == 0) {
            lists.add(new LinkedList<Integer>(list));
        }
        if (root.left != null && sum >= root.left.val) {
            list.addLast(root.left.val);
            sum -= root.left.val;
            pathSumHelp1(root.left, sum, list);
            list.removeLast();
            sum += root.left.val;
        }
        if (root.right != null && sum >= root.right.val) {
            list.addLast(root.right.val);
            sum -= root.right.val;
            pathSumHelp1(root.right, sum, list);
            list.removeLast();
            sum += root.right.val;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> currentResult = new LinkedList<Integer>();
        pathSum(root, sum, currentResult, result);
        return result;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
        if (root ==null) {
            return;
        }
        currentResult.add(new Integer(root.val));
        if (root.left==null && root.right==null && sum==root.val){
            result.add(new LinkedList<Integer>(currentResult));
            currentResult.remove(currentResult.size()-1);
            return;
        }else {
            pathSum(root.left,sum-root.val,currentResult,result);
            pathSum(root.right,sum-root.val,currentResult,result);
        }
        currentResult.remove(currentResult.size()-1);
    }
}

