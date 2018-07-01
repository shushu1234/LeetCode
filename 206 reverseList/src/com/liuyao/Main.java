package com.liuyao;

/**
 * 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre=null;
            ListNode cur=head;
            while (cur!=null){
                ListNode next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
            }
            return pre;
        }
    }
}
