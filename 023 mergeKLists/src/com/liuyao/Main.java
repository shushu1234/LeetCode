package com.liuyao;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

 示例:

 输入:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 输出: 1->1->2->3->4->4->5->6
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);

        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);

        ListNode listNode6 = new ListNode(2);
        ListNode listNode7 = new ListNode(6);

        listNode0.next = listNode1;
        listNode1.next = listNode2;

        listNode3.next = listNode4;
        listNode4.next = listNode5;

        listNode6.next = listNode7;
        ListNode[] listNodes={};
        Solution.mergeKLists(listNodes);
    }
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    static class Solution {
        public static ListNode mergeKLists(ListNode[] lists) {
            if (lists.length==0 || lists==null){
                return null;
            }
            PriorityQueue<ListNode> priorityQueue=new PriorityQueue<ListNode>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val-o2.val;
                }
            });
            for (int i = 0; i < lists.length; i++) {
                while (lists[i]!=null){
                    priorityQueue.add(lists[i]);
                    lists[i]=lists[i].next;
                }
            }
            if (priorityQueue.isEmpty()){
                return null;
            }
            ListNode root=priorityQueue.poll();
            ListNode head=root;
            while (!priorityQueue.isEmpty()){
                root.next=priorityQueue.poll();
                root=root.next;
            }
            root.next=null;
            return head;
        }
    }
}
