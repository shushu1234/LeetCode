package com.liuyao;

/**
 *
 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

 示例 1:

 输入: 1->1->2
 输出: 1->2
 示例 2:

 输入: 1->1->2->3->3
 输出: 1->2->3
 */
public class Main {

    public static void main(String[] args) {
        // write your code here

        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);


        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Solution.deleteDuplicates(listNode0);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public static ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode temp1 = head;
            ListNode temp2 = head.next;
            while (temp2 != null) {
                if (temp2.val != temp1.val) {
                    temp1.next = temp2;
                    temp1 = temp2;
                } else {
                    temp2 = temp2.next;
                }
            }
            temp1.next = null;
            return head;
        }
    }
}
