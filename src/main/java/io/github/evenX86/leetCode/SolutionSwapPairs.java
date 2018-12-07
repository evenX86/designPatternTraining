package io.github.evenX86.leetCode;

import io.github.evenX86.leetCode.addTwoNumbers.ListNode;

public class SolutionSwapPairs {
    public  static ListNode swapPairs(ListNode a) {
        if (a == null || a.next == null) return a;
        ListNode head = a.next;
        ListNode pre;
        while (true) {
                ListNode c = a.next.next;
                ListNode b = a.next;
                a.next = c;
                b.next = a;
                pre = a;
                a = a.next;
                if (a == null || a.next == null) {
                    pre.next = a;
                    break;
                } else {
                    pre.next = a.next;
                }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        /*listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);*/
        ListNode s = swapPairs(listNode);
        int i =0 ;
        while (s!=null) {
            System.out.print(s.val + "->");
            s = s.next;
            if (i++>10) break;

        }
    }
}
