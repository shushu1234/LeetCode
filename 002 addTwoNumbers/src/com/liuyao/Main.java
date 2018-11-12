package com.liuyao;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode listNode=new ListNode(5);
//        ListNode listNode1=new ListNode(4);
//        ListNode listNode2=new ListNode(3);
//        listNode.next=listNode1;
//        listNode1.next=listNode2;

        ListNode listNode3=new ListNode(5);
//        ListNode listNode4=new ListNode(6);
//        ListNode listNode5=new ListNode(8);
//        listNode3.next=listNode4;
//        listNode4.next=listNode5;

        System.out.println(Solution1.addTwoNumbers(listNode,listNode3).next.val);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode listNode=new ListNode(0);
            if (l1==null && l2==null){
                return listNode;
            }
            LinkedList<Integer> a=new LinkedList<>();
            LinkedList<Integer> b=new LinkedList<>();
            while (l1!=null){
                a.add(l1.val);
                l1=l1.next;
            }
            while (l2!=null){
                b.add(l2.val);
                l2=l2.next;
            }
            int temp=0;
            int total=0;
            ListNode head=listNode;
            LinkedList<Integer> c=new LinkedList<>();
            while (a.size()!=0 && b.size()!=0){
                total=a.peekFirst()+b.peekFirst()+temp;
                c.add((total)%10);
                temp=total/10;
                a.removeFirst();
                b.removeFirst();
            }
            while (a.size()!=0){
                total=a.removeFirst()+temp;
                c.add((total)%10);
                temp=total/10;
            }
            while (b.size()!=0){
                total=b.removeFirst()+temp;
                c.add((total)%10);
                temp=total/10;
            }
            if (temp!=0){
                c.add(temp);
            }
            while (c.size()!=0){
                listNode.next=new ListNode(c.removeFirst());
                listNode=listNode.next;
            }
            return head.next;
        }
    }

   static class Solution1 {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
           ListNode listNode=new ListNode(0);
           ListNode head=listNode;
           int temp=0;
           while (l1!=null || l2!=null||temp!=0){
               int sum=(l1!=null?l1.val:0)+(l2!=null?l2.val:0)+temp;
               temp=sum/10;
               listNode.next=new ListNode(sum%10);
               listNode=listNode.next;
               l1=(l1!=null?l1.next:l1);
               l2=(l2!=null?l2.next:l2);
           }
           return head.next;
        }
    }
}


