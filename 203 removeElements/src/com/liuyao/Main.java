package com.liuyao;

/**
 * 删除链表中等于给定值 val 的所有节点。

 示例:

 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(4);

        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        Solution.removeElements(listNode0,2);
    }

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    static class Solution {
        public static ListNode removeElements(ListNode head, int val) {
//            设置一个虚拟的头结点
            ListNode dummyHead=new ListNode(0);
            dummyHead.next=head;
            ListNode cur=dummyHead;
            while (cur.next !=null){
                if (cur.next.val==val){
                    cur.next=cur.next.next;
                }else {
                    cur=cur.next;
                }
            }
            return dummyHead.next;
        }
    }
}
