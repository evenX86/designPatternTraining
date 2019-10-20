package io.github.evenX86.solution;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with design-pattern-training
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 快排思路
 * [3,2,1,5,6,4] 和 k = 2
 * 输出 5
 * @author xuyifei
 * @date 2019-09-24 3:30 PM
 */
public class SolutionFindKthLargest extends BaseSolution{
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        findKthLargest(nums,4);
    }

    public static void printQueue(Queue<Integer> queue) {
        Queue<Integer> tmpQueue = new PriorityQueue<>(queue);
        System.out.printf("size: " + tmpQueue.size() + " val : ");
        while (!tmpQueue.isEmpty()) {
            System.out.printf(String.valueOf(tmpQueue.poll()));
            System.out.printf(",");
        }
        System.out.println();

    }
}
