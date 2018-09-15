package com.liuyao;


import java.util.HashMap;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

 示例 1:

 输入: [3,2,3,null,3,null,1]

 3
 / \
 2   3
 \   \
 3   1

 输出: 7
 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 示例 2:

 输入: [3,4,5,1,3,null,1]

 3
 / \
 4   5
 / \   \
 1   3   1

 输出: 9
 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
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
//        直接递归方式
        public int rob(TreeNode root) {
            if (root==null){
                return 0;
            }
            int val=0;

            if (root.left!=null){
                val+=rob(root.left.left)+rob(root.left.right);
            }

            if (root.right!=null){
                val+=rob(root.right.left)+rob(root.right.right);
            }

            return Math.max(val+root.val,rob(root.left)+rob(root.right));
        }

//        记忆化搜索方式
        public int rob1(TreeNode root){
            return robSub(root,new HashMap<TreeNode,Integer>());
        }

        private int robSub(TreeNode root, HashMap<TreeNode, Integer> map) {
            if (root==null){
                return 0;
            }
            if (map.containsKey(root)){
                return map.get(root);
            }
            int val=0;
            if (root.left!=null){
                val+=robSub(root.left.left,map)+robSub(root.left.right,map);
            }
            if (root.right!=null){
                val+=robSub(root.right.left,map)+robSub(root.right.right,map);
            }
            val=Math.max(val+root.val,robSub(root.left,map)+robSub(root.right,map));
            map.put(root,val);
            return val;
        }
    }
}
