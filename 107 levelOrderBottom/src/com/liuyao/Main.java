package com.liuyao;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

 例如：
 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其自底向上的层次遍历为：

 [
 [15,7],
 [9,20],
 [3]
 ]
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> lists=new LinkedList<List<Integer>>();
            if (root==null){
                return lists;
            }
            LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
            queue.offer(root);
            Stack<List<Integer>> stack=new Stack<List<Integer>>();
            while (!queue.isEmpty()){
                int size=queue.size();
                LinkedList<Integer> linkedList=new LinkedList<Integer>();
                while (size-->0){
                    TreeNode node=queue.pollFirst();
                    linkedList.addLast(node.val);
                    if (node.left!=null){
                        queue.offer(node.left);
                    }
                    if (node.right!=null){
                        queue.offer(node.right);
                    }
                }
                stack.push(linkedList);
            }
            while (!stack.isEmpty()){
                lists.add(stack.pop());
            }
            return lists;
        }
    }
}
