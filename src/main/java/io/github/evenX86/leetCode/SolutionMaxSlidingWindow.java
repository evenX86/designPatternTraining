package io.github.evenX86.leetCode;

import java.util.ArrayDeque;

public class SolutionMaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || nums.length <= 0) return new int[]{};
        if (k <= 1 || nums.length <= 1) return nums;
        int[] res = new int[nums.length-k+1];
        int cnt = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>(); // 记录索引
        for (int i=0;i<nums.length;i++) {
            while (!deque.isEmpty() && deque.peekFirst() +k <= i) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
           // System.out.println("nums : " +nums[i]);
            if (i>= k-1) res[cnt ++ ] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {

        int nums[] = {1,3,1,2,0,5};
        int res[] = maxSlidingWindow(nums, 3);
        for (int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }
}
