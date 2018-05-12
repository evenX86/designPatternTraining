package io.github.evenX86.leetCode;

import io.github.evenX86.leetCode.addTwoNumbers.ListNode;

import java.util.HashSet;
import java.util.Set;


public class Solution {
    /**
     * 很经典的一个题目,用来处理两个链表的关系, 工作中也会经常用到
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode parent = null;
        ListNode last = null;

        int jw = 0;
        while (l1 != null && l2 != null) {

            int x = l1.val;
            int y = l2.val;
            int z = (x + y + jw)%10;
            jw = (x+y+jw) / 10;
            ListNode currentNode = new ListNode(z);
            if (head == null) {
                head = currentNode;
                parent = head;
            } else {
                parent.next = currentNode;
                parent = parent.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            last = l1;
        }
        if (l2 != null) {
            last = l2;
        }
        while (last != null) {
            int x = last.val;
            if (jw > 0) {
                x = (x + jw) % 10;
                jw = (last.val + jw) / 10;
            }
            parent.next = new ListNode(x);
            parent = parent.next;
            last = last.next;
        }
        if (jw > 0) {
            parent.next = new ListNode(jw);
        }
        return head;
    }

    /**
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s==null || s.length() <= 0) return 0;
        Set<Character> charSet = new HashSet<Character>();
        int LEN = s.length();
        int start = 0;
        int end = 0;
        while (start < LEN && end < LEN) {
            if (!charSet.contains(s.charAt(end))) {
                charSet.add(s.charAt(end));
                end ++;
                max = Math.max(max, end - start);
            } else {
                charSet.remove(s.charAt(start));
                start ++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bvbk"));
    }
}
