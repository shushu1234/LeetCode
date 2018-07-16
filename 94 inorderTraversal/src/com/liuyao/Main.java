package com.liuyao;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。

 示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,3,2]
 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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

    class Solution{
        class Command{
            String s;
            TreeNode node;

            public Command(String s, TreeNode node) {
                this.s = s;
                this.node = node;
            }
        }
        public List<Integer> inorderTraversal(TreeNode root) {
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
                    stack.push(new Command("print",command.node));
                    if (command.node.left!=null){
                        stack.push(new Command("go",command.node.left));
                    }

                }
            }
            return linkedList;
        }

    }
}
