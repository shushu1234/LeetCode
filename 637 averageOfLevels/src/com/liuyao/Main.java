package com.liuyao;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.

 示例 1:

 输入:
 3
 / \
 9  20
 /  \
 15   7
 输出: [3, 14.5, 11]
 解释:
 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 注意：

 节点值的范围在32位有符号整数范围内。
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
        public List<Double> averageOfLevels(TreeNode root) {
            if (null==root){
                return null;
            }
            LinkedList<TreeNode> queue=new LinkedList<>();
            queue.addLast(root);
            LinkedList<Double> list=new LinkedList<>();
            while (!queue.isEmpty()){
                int size=queue.size();
                long total=0L;
                for (int i = 0; i <size ; i++) {
                    TreeNode node=queue.removeFirst();
                    if (node.left!=null)
                        queue.addLast(node.left);
                    if (node.right!=null)
                        queue.addLast(node.right);
                    total+=node.val;
                }
                list.addLast(1.0*total/size);
            }
            return list;
        }
    }
}
