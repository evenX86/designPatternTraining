package io.github.evenX86.leetCode;

import io.github.evenX86.leetCode.addTwoNumbers.ListNode;

public class SolutionHasCycle {
    public  static  boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast=head,slow=head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);

        listNode.next = listNode1;
        listNode1.next = new ListNode(3);
        listNode.next.next = listNode1;


        /*listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);*/
        System.out.println(hasCycle(listNode));
    }
}
