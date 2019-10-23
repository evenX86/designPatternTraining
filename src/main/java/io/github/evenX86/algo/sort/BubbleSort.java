package io.github.evenX86.algo.sort;

/**
 * Created with design-pattern-training
 *
 * 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。
 * 如果不满足就让它俩互换。一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
 * @author xuyifei
 * @date 2019-10-23 8:53 PM
 */
public class BubbleSort implements BaseSort{

    @Override
    public int[] sort(int[] arr, int n) {
        if (n <= 1) {
            return arr;
        }
        for (int i=0;i<n; i++) {
            boolean flag = false;
            for (int j = 0; j<n - i -1 ; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = new int[]{1,3,2,5,3};
        for (int i : bubbleSort.sort(arr, 5)) {
            System.out.println(i);
        }
    }
}
