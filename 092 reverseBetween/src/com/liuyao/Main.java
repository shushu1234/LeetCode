package com.liuyao;

/**
 *
 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

 说明:
 1 ≤ m ≤ n ≤ 链表长度。

 示例:

 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 输出: 1->4->3->2->5->NULL
 */

//虚拟头结点
public class Main {

    public static void main(String[] args) {
        // write your code here

        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        ListNode listNode4 = new ListNode(5);


        listNode0.next = listNode1;
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;

        Solution.reverseBetween(listNode0,1,3);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public static ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode temphead=new ListNode(0);
            temphead.next=head;
            head=temphead;

            ListNode pre=null;
            ListNode cur=head;
            ListNode ne=head.next;
            ListNode temp1= null;
            ListNode temp2=null;

            if (m==n){
                return head.next;
            }
            for (int i = 0; i <= n+1; i++) {
                if (i==m-1){
                    pre=cur;
                    temp1=pre;
                    temp2=cur.next;
                    ne=cur.next;
                }else if (i >=m){
                    cur.next=pre;
                    pre=cur;
                    cur=ne;
                    if (ne ==null){
                        break;
                    }
                    ne=ne.next;
                }else {
                    cur=cur.next;
                }
            }
            temp1.next=pre;
            temp2.next=cur;
            return head.next;
        }
    }
}
