package com.liuyao;

import java.util.Stack;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 1
 / \
 2   2
 \   \
 3    3
 说明:

 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return root == null || isSymmetricHelp(root.left, root.right);
        }

        private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
            if (left == null || right == null) {
                return left == right;
            }
            if (left.val != right.val) {
                return false;
            }
            return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
        }

        public boolean isSymmetric2(TreeNode root) {
            if (root == null) {
                return true;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode left, right;
            if (root.left != null) {
                if (root.right == null) {
                    return false;
                }
                stack.push(root.left);
                stack.push(root.right);
            } else if (root.right != null) {
                return false;
            }

            while (!stack.isEmpty()){
                if (stack.size()%2!=0){
                    return false;
                }
                right =stack.pop();
                left=stack.pop();
                if (right.val != left.val){
                    return false;
                }
                if (left.left !=null){
                    if (right.right==null){
                        return false;
                    }
                    stack.push(left.left);
                    stack.push(right.right);
                }else if (right.right!=null){
                    return false;
                }
                if (left.right!=null){
                    if (right.left==null){
                        return false;
                    }
                    stack.push(left.right);
                    stack.push(right.left);
                }else if (right.left!=null){
                    return false;
                }
            }
            return true;
        }
    }
}
