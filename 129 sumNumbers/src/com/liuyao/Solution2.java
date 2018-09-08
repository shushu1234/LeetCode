package com.liuyao;

/**
 * @author liuyao
 * @date 2018/09/08
 */
public class Solution2 {
    private int sum=0;
    private int num=0;
    public int sumNumbers(TreeNode root){
        sum(root);
        return sum;
    }

    private void sum(TreeNode root) {
        if (root !=null){
            num=num*10+root.val;
            if (root.left==null&& root.right==null){
                sum+=num;
            }
            sum(root.left);
            sum(root.right);
            num/=10;
        }
    }
}
