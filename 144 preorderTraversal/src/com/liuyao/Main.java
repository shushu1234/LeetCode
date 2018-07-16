package com.liuyao;



import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 给定一个二叉树，返回它的 前序 遍历。

 示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,2,3]
 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode treeNode0 = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);


        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
//        System.out.println(Solution.preorderTraversal(treeNode0));
    }

     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    static class Solution {
         class Command{
            String s;
            TreeNode node;

            public Command(String s, TreeNode node) {
                this.s = s;
                this.node = node;
            }
        }
        public  List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<Integer> linkedList=new LinkedList<>();
            if (root==null){
                return linkedList;
            }
//            模拟系统栈调用
            Stack<Command> stack=new Stack<>();
            stack.push(new Command("go",root));
            while (!stack.isEmpty()){
                Command command=stack.pop();
                if (command.s.equals("print")){
                    linkedList.add(command.node.val);
                }else {
//                    与递归的相反
                    if (command.node.right!=null){
                        stack.push(new Command("go",command.node.right));
                    }
                    if (command.node.left!=null){
                        stack.push(new Command("go",command.node.left));
                    }
                    stack.push(new Command("print",command.node));
                }
            }
            return linkedList;
        }

        //递归的方式遍历
        public List<Integer> preorderTraversal1(TreeNode root) {
            LinkedList<Integer> list=new LinkedList<>();
            if (root!=null){
                list.addLast(root.val);
                list.addAll(preorderTraversal1(root.left)); //要用addAll()方法
                list.addAll(preorderTraversal1(root.right));
            }
            return list;
        }
    }
}
