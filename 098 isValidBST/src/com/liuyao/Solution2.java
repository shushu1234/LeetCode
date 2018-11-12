package com.liuyao;

import java.util.ArrayList;

/**
 * @author liuyao
 * @date 2018/09/08
 */

/**
 * 利用中序遍历的方式，中序遍历得出的结果为有序的
 */
public class Solution2 {
    public boolean isValidBST(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for(int i = 1 ; i < list.size() ; i ++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode node, ArrayList<Integer> list){

        if(node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
