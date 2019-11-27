package io.github.evenX86.algo.sort;

/**
 * Created with design-pattern-training
 * <p>
 * 堆是一种完全二叉树 -- 使用数组存储
 * 堆中的每一个节点都必须大于等于(或者小于等于)其子树中的每个节点的数量
 * https://time.geekbang.org/column/article/69913
 *
 * @author xuyifei
 * @date 2019-11-10 5:21 PM
 */
public class HeapSort {

    /**
     * 存储数据数组，从1开始
     */
    private int[] a;
    /**
     * 最大长度
     */
    private int n;
    /**
     * 当前长度
     */
    private int count;

    public HeapSort(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) {
            return;
        }
        a[++count] = data;
        // 开始自下往上堆化
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            // 如果比父节点大，就与父节点交换，直到根节点。
            swap(a, i, i / 2);
        }
    }

    /**
     * 删除堆顶元素
     * @return
     */
    public int removeMax() {
        if (count <= 0) {
            return -1;
        }
        int val = a[count];
        a[1] = a[count--];
        heapify(a, count, 1);
        return val;

    }

    /**
     * 堆化
     *
     * @param a
     * @param count
     * @param i
     */
    private void heapify(int[] a, int count, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= count && a[i * 2] > a[i]) {
                // 交换左节点与当前节点
                maxPos = i * 2;
            }
            if ((i * 2 + 1) <= count && a[maxPos] > a[i]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 时间复杂度o(n)
     * @param a
     * @param n
     */
    public void buildHeap(int[] a, int n) {
        for (int i=n/2; i>=1 ; i--) {
            heapify(a, n, i);
        }

    }

    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            // 每次都把堆顶元素放在最右侧
            swap(a,1, k--);
            // 调整之后，重新堆化，堆顶又是剩下的堆中最大的值了
            heapify(a, k, 1);
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

}
