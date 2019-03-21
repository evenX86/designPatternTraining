package io.github.evenX86.solution;

import io.github.evenX86.solution.addTwoNumbers.ListNode;

/**
 *
 * https://leetcode.com/problems/reverse-linked-list/
 * 链表面试考的是代码能力
 * 链表的题目一般都比较直接，考验面试者代码是否简洁，逻辑是否清晰，可以通过多练习提升
 */
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

    /**
     * 链表翻转相邻k个元素
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode from = head, to=head,preTo=head;
        int count = 0, i;
        if(head == null || k < 2) return head;
        ListNode iter = head;
        for (;;) {
            ListNode res = null;
            ListNode tmp1 = iter;
            for (i =1;i<=k && tmp1 != null;i++) {
                tmp1 = tmp1.next; // 保存数量不足的group
            }
            if (i == k+1) {
                for (i=1;i<=k;i++) {
                    ListNode tmp = new ListNode(iter.val);
                    if (i==1) to = tmp;
                    tmp.next = res;
                    res  = tmp;
                    iter = iter.next;
                    if (iter == null) {
                        break;
                    }
                }
            } else { // 数量不足的反转段肯定到了处理尽头，跳出处理循环
                if (count > 0) preTo.next = iter; // 如果是第一次就不足k个，跳出，不反转
                break;
            }
            count ++; // 处理次数
            if (count == 1) {
                from = res;
            }
            if (count > 1) {
                preTo.next = res;
            }
            preTo = to; // 记录上一次的后继指针
            if (iter == null) break;
        }

        return from;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode newNode = reverseKGroup(listNode,2);
        //ListNode newNode = listNode;
        while (newNode != null) {
            System.out.print(newNode.val + "->");
            newNode = newNode.next;
        }

    }
}
