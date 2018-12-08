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

    /**
     * 在第一版的基础上找到meet node 后找到start node
     * 代码简单，但蕴含代码背后的数学证明比较复杂，推荐视频讲解：https://www.youtube.com/watch?v=LUm2ABqAs1w
     * 可以证明head to start node 要走的路径和meet node 到start node 要走的路径 * loop 的整数倍是相同。
     * 所以reset to head之后开始走和meet node开始走，肯定可以共同走到start node
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode fast=head,slow=head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast.next == null || fast.next.next == null) return null; // 无环处理
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(5);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = listNode1;
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        listNode.next.next.next.next.next.next.next = listNode1;


        /*listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);*/
        System.out.println(detectCycle(listNode).val);
    }
}
