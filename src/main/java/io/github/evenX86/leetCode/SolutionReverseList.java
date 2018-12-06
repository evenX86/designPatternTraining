package io.github.evenX86.leetCode;

import io.github.evenX86.leetCode.addTwoNumbers.ListNode;

public class SolutionReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode tmpNode = new ListNode(head.val);
            tmpNode.next = res;
            res = tmpNode;
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ListNode newNode = reverseList(listNode);
        //ListNode newNode = listNode;
        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }

    }
}
