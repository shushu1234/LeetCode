package com.liuyao;


import java.util.*;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class Main {

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
        treeNode4.left = treeNode5;
        treeNode4.right = treeNode6;
        System.out.println(Solution.levelOrder2(treeNode0));
    }
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    static class Solution {
        public static List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res= new LinkedList<>();
            LinkedList<Map<TreeNode,Integer>> queue=new LinkedList<>();
            if (root==null){
                return res;
            }
            Map<TreeNode,Integer> map1=new HashMap<>();
            map1.put(root,0);
            queue.add(map1);
            while (!queue.isEmpty()){
                TreeNode node = null;
                int level = 0;
                for (Map.Entry<TreeNode,Integer> e:queue.removeFirst().entrySet()) {
                    node=e.getKey();
                    level=e.getValue();
                }
                if (level==res.size()){
                    res.add(new LinkedList<>());
                }
                res.get(level).add(node.val);
                if (node.left!=null){
                    Map<TreeNode,Integer> map=new HashMap<>();
                    map.put(node.left,level+1);
                    queue.add(map);
                }
                if (node.right!=null){
                    Map<TreeNode,Integer> map=new HashMap<>();
                    map.put(node.right,level+1);
                    queue.add(map);
                }
            }
            return res;
        }

        public static List<List<Integer>> levelOrder2(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

            if(root == null) return wrapList;

            queue.offer(root);
            while(!queue.isEmpty()){
//                queueNum为该层元素的个数
                int levelNum = queue.size();
//                创建一个list把该层的元素全部装进去
                List<Integer> subList = new LinkedList<Integer>();
//                循环该层的元素个数次，把改成元素全部装进sublist
                for(int i=0; i<levelNum; i++) {
                    if(queue.peek().left != null) queue.offer(queue.peek().left);
                    if(queue.peek().right != null) queue.offer(queue.peek().right);
                    subList.add(queue.poll().val);
                }
                wrapList.add(subList);
            }
            return wrapList;
        }
    }
}
