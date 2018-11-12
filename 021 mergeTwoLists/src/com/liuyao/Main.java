package com.liuyao;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
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
//        listNode3.next = listNode4;

        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        System.out.println(Solution.mergeTwoLists(null,null));
    }


      public static class ListNode {
          int val;
          ListNode next;
         ListNode(int x) { val = x; }
     }

    static class Solution {
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode listNode=new ListNode(0);
            ListNode head=listNode;
            while (l1!=null||l2!=null){
                if (l1==null){
                    listNode.next=l2;
                    listNode=listNode.next;
                    break;
                }
                if (l2==null){
                    listNode.next=l1;
                    listNode=listNode.next;
                    break;
                }
                if (l1.val<=l2.val){
                    listNode.next=l1;
                    l1=l1.next;
                    listNode=listNode.next;
                    continue;
                }
                if (l2.val<l1.val){
                    listNode.next=l2;
                    l2=l2.next;
                    listNode=listNode.next;
                    continue;
                }
            }

            return head.next;
        }
    }

    static class Solution2{
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1==null){
                return l2;
            }
            if (l2==null){
                return l1;
            }
            ListNode head=null;
            if (l1.val<l2.val){
                head=l1;
                head.next=mergeTwoLists(l1.next,l2);
            }else {
                head=l2;
                head.next=mergeTwoLists(l1,l2.next);
            }
            return head;
        }
    }
}
