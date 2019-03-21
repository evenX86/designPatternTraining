package io.github.evenX86.solution;

import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> priorityQueue;
    private int len;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<Integer>(k);
        len = k;
        for (int i: nums ){
            add(i);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < len) {
            priorityQueue.add(val);
        } else if (priorityQueue.peek() < val) {
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }
    public static void main(String[] args) {
        int k = 1;
        int[] arr ={ };
        KthLargest kthLargest = new KthLargest(k, arr);
        kthLargest.add(-3);
        System.out.println(kthLargest.add(10));   // returns 4
    }
}
