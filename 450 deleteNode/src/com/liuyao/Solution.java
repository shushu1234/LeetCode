package com.liuyao;


public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null){
            return null;
        }
        if (key<root.val){
            root.left=deleteNode(root.left,key);
        }else if (key >root.val){
            root.right=deleteNode(root.right,key);
        }else {
            if (root.left==null){
                return root.right;
            }else if (root.right==null){
                return root.left;
            }
//            去找右孩子中的最小的一个元素
            TreeNode minNode=findMin(root.right);
//            改变当前root的值
            root.val=minNode.val;
//            删除右孩子中最小的元素
            root.right=deleteNode(root.right,minNode.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left!=null){
            node=node.left;
        }
        return node;
    }
}
